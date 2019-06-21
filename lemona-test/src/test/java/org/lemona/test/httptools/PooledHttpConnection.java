package org.lemona.test.httptools;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.*;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Required;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Map;

public class PooledHttpConnection implements InitializingBean, DisposableBean {
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String CONTENT_ENCODING = "Content-Encoding";
    private static final String ACCEPT_ENCODING = "Accept-Encoding";
    private final Log log = LogFactory.getLog(PooledHttpConnection.class);
    private String defaultCharSet;
    private String defaultContentType;
    // Default to not use compression for backward compatibility
    private Boolean enableCompression = false;
    private Integer poolSize;
    private Integer defaultMaxConnectionsPerHost = -1;
    private Integer responseTimeout;//timeout on waiting for respone
    private Integer socketCreationTimeout;//timeout on waiting for socket to be available
    private Integer connectionManagerTimeout = null;
    private String username;
    private String password;
    private String proxyHostName;
    private int proxyPort = -1;
    protected CloseableHttpClient client;

    @Required
    public void setCharSet(String charSet) {
        this.defaultCharSet = charSet;
    }

    @Required
    public void setDefaultContentType(String defaultContentType) {
        this.defaultContentType = defaultContentType;
    }

    public void setEnableCompression(Boolean enableCompression) {
        this.enableCompression = enableCompression;
    }

    @Required
    public void setPoolSize(Integer poolSize) {
        this.poolSize = poolSize;
    }

    public void setDefaultMaxConnectionsPerHost(Integer defaultMaxConnectionsPerHost) {
        this.defaultMaxConnectionsPerHost = defaultMaxConnectionsPerHost;
    }

    @Required
    public void setResponseTimeout(Integer responseTimeout) {
        this.responseTimeout = responseTimeout;
    }

    @Required
    public void setSocketCreationTimeout(Integer socketCreationTimeout) {
        this.socketCreationTimeout = socketCreationTimeout;
    }

    public void setConnectionManagerTimeout(Integer connectionManagerTimeout) {
        this.connectionManagerTimeout = connectionManagerTimeout;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setProxyHostName(String proxyHostName) {
        this.proxyHostName = proxyHostName;
    }

    public void setProxyPort(String proxyPort) {
        if (proxyPort != null && !proxyPort.isEmpty()) {
            try {
                this.proxyPort = Integer.parseInt(proxyPort);
            } catch (NumberFormatException e) {
                log.warn("The proxy port is invalid. " + proxyPort);
            }
        }
    }

    // end spring setters

    public void destroy() throws Exception {
        ClientConnectionManager mgr = client.getConnectionManager();
        mgr.shutdown();
        client.close();
    }

    public void afterPropertiesSet() throws Exception {
        //setup the client
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        //set the max total connections
        cm.setMaxTotal(poolSize);
        //set the max connections per host
        if (this.defaultMaxConnectionsPerHost != -1)
            cm.setDefaultMaxPerRoute(this.defaultMaxConnectionsPerHost);
        else
            cm.setDefaultMaxPerRoute(poolSize);

        connectionManagerTimeout = connectionManagerTimeout == null ? socketCreationTimeout : connectionManagerTimeout;
        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setConnectTimeout(socketCreationTimeout)
                .setSocketTimeout(responseTimeout)
                .setConnectionRequestTimeout(connectionManagerTimeout)
                .build();

        HttpClientBuilder builder = HttpClientBuilder.create();
        builder.setConnectionManager(cm);
        builder.setDefaultRequestConfig(defaultRequestConfig);

        if(proxyHostName != null && !proxyHostName.isEmpty()){
            DefaultProxyRoutePlanner routePlanner = new DefaultProxyRoutePlanner(new HttpHost(proxyHostName, proxyPort));
            builder.setRoutePlanner(routePlanner);
        }

        // do http authentication if username and password are set
        if (username != null && password != null) {
            httpAuthentication(builder, username, password);
        }

        client = builder.build();
    }

    private void httpAuthentication(HttpClientBuilder builder, String username, String password) {
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT, AuthScope.ANY_REALM),
                new UsernamePasswordCredentials(username, password));
        builder.setDefaultCredentialsProvider(credsProvider);
    }

    protected String getMethodUrl(String url) throws IOException {
        return url;
    }

    /**
     * get a request
     *
     * @param url         get url
     * @param queryParams query parameters
     * @param headers     request headers
     * @return HttpResponse
     * @throws ConnectionException
     * @throws UnsupportedEncodingException
     * @throws IOException
     */
    public HttpResp get(String url, Map<String, String> queryParams, Map<String, String> headers)
            throws ConnectionException, IOException {
        HttpGet getMethod = new HttpGet(getMethodUrl(url));
        return executeMethod(getMethod, queryParams, headers);
    }

    public HttpResp delete(String url, Map<String, String> queryParams, Map<String, String> headers)
            throws ConnectionException, IOException {
        HttpDelete deleteMethod = new HttpDelete(getMethodUrl(url));
        return executeMethod(deleteMethod, queryParams, headers);
    }


    public HttpResp put(String url, Map<String, String> putParams,
                            String requestBody, Map<String, String> headers)
            throws ConnectionException, IOException {
        HttpPut putMethod = new HttpPut(getMethodUrl(url));
        try {
            if (putParams != null) {
                URI uri = new URIBuilder(putMethod.getURI()).addParameters(Arrays.asList(getNVPairs(putParams))).build();
                putMethod.setURI(uri);
            }

            if (requestBody != null) {
                //set body
                requestBody = new String(requestBody.getBytes(), defaultCharSet);
                putMethod.setEntity(new StringEntity(requestBody, defaultContentType, defaultCharSet));
            }

            //set headers
            putMethod.setHeader(CONTENT_TYPE, defaultContentType + "; charset=" + defaultCharSet);

            for (String key : headers.keySet()) {
                putMethod.setHeader(key, headers.get(key));
            }

            HttpResp response = this.client.execute(putMethod, new ConvertResponseHandler());
            return response;
        } catch (URISyntaxException e) {
            throw new ConnectionException("Build URI failed: : " + url, e);
        } finally {
            //make sure to release connection in the pool
            putMethod.releaseConnection();
        }
    }

    /**
     * POST params and body
     *
     * @param url         post url
     * @param postParams  post query parameters
     * @param requestBody request body
     * @param headers     request header
     * @return HttpResponse
     * @throws ConnectionException
     * @throws IOException
     */
    public HttpResp post(String url, Map<String, String> postParams, String requestBody, Map<String, String> headers)
            throws ConnectionException, IOException {
        return post(url, postParams, requestBody, defaultContentType, headers);
    }

    /**
     * POST params and body
     *
     * @param url         post url
     * @param postParams  post query parameters
     * @param requestBody request body
     * @param contentType content type
     * @param headers     request header
     * @return HttpResponse
     * @throws ConnectionException
     * @throws IOException
     */
    public HttpResp post(String url, Map<String, String> postParams, String requestBody, String contentType, Map<String, String> headers)
            throws ConnectionException, IOException {
        HttpPost postMethod = new HttpPost(getMethodUrl(url));
        try {
            if (postParams != null) {
                //set post params
                URI uri = new URIBuilder(postMethod.getURI()).addParameters(Arrays.asList(getNVPairs(postParams))).build();
                postMethod.setURI(uri);
            }

            if (requestBody != null) {
                //set body
                requestBody = new String(requestBody.getBytes(), defaultCharSet);
                postMethod.setEntity(new StringEntity(requestBody, contentType, defaultCharSet));
            }

            //set headers
            postMethod.setHeader(CONTENT_TYPE, contentType + "; charset=" + defaultCharSet);

            if (headers != null) {
                for (String key : headers.keySet()) {
                    postMethod.setHeader(key, headers.get(key));
                }
            }

            HttpResp response = this.client.execute(postMethod, new ConvertResponseHandler());
            return response;
        } catch (URISyntaxException e) {
            throw new ConnectionException("Build URI failed: : " + url, e);
        } finally {
            //make sure to release connection in the pool
            postMethod.releaseConnection();
        }
    }

    public HttpResp patch(String url, String requestBody, Map<String, String> headers)
            throws IOException {
        HttpPatch patchMethod = new HttpPatch(getMethodUrl(url));
        try {
            if (requestBody != null) {
                //set body
                requestBody = new String(requestBody.getBytes(), defaultCharSet);
                patchMethod.setEntity(new StringEntity(requestBody, defaultContentType, defaultCharSet));
            }
            //set headers
            patchMethod.setHeader(CONTENT_TYPE, defaultContentType + "; charset=" + defaultCharSet);
            if (headers != null) {
                for (String key : headers.keySet()) {
                    patchMethod.setHeader(key, headers.get(key));
                }
            }
            HttpResp response = this.client.execute(patchMethod, new ConvertResponseHandler());
            return response;
        } finally {
            //make sure to release connection in the pool
            patchMethod.releaseConnection();
        }
    }

    private HttpResp executeMethod(HttpRequestBase httpMethod, Map<String, String> queryParams, Map<String, String> headers) throws ConnectionException, IOException{
        try {
            //set query params
            if (queryParams != null && queryParams.size() > 0) {
                URI uri = new URIBuilder(httpMethod.getURI()).addParameters(Arrays.asList(getNVPairs(queryParams))).build();
                httpMethod.setURI(uri);
            }

            //set headers
            httpMethod.setHeader(CONTENT_TYPE, defaultContentType + "; charset=" + defaultCharSet);

            if (headers != null) {
                for (String key : headers.keySet()) {
                    httpMethod.addHeader(key, headers.get(key));
                }
            }

            HttpResp response = this.client.execute(httpMethod, new ConvertResponseHandler());
            return response;
        } catch (URISyntaxException e) {
            throw new ConnectionException("Build URI failed: : " + httpMethod.getURI(), e);
        } finally {
            //make sure to release connection in the pool
            httpMethod.releaseConnection();
        }
    }

    private class ConvertResponseHandler implements ResponseHandler<HttpResp> {

        @Override
        public HttpResp handleResponse(org.apache.http.HttpResponse httpResponse) throws ClientProtocolException, IOException {
            HttpResp response = new HttpResp();
            response.setStatusCode(httpResponse.getStatusLine().getStatusCode());
            HttpEntity entity = httpResponse.getEntity();
            try {
                String payload = entity != null ? EntityUtils.toString(entity) : null;
                if (payload != null)
                    response.setResponse(payload);
            } catch (IOException e) {
                log.warn("Convert http response body failed.", e);
                throw e;
            }
            for (Header header : httpResponse.getAllHeaders()) {
                response.headers.put(header.getName(), header.getValue());
            }
            return response;
        }
    }

    private class ConvertGzipResponseHandler implements ResponseHandler<HttpResponse> {
        @Override
        public HttpResponse handleResponse(org.apache.http.HttpResponse httpResponse) throws ClientProtocolException, IOException {
            HttpResponse response = new BasicHttpResponse(httpResponse.getStatusLine());

            HttpEntity entity = httpResponse.getEntity();

            if (log.isDebugEnabled())
                log.debug("Reading whole stream, content is " + entity.getContentLength() + " in " + entity.getContentType().getValue());

            // Check if server sent it back compressed
            if (entity.getContentEncoding() != null &&
                    entity.getContentEncoding().getValue().toLowerCase().indexOf("gzip") > -1) {
                log.debug("Response stream is using gzip compression");
                entity = new GzipDecompressingEntity(entity);
            } else {
                log.debug("Response stream is uncompressed");
            }

            String responseBody = EntityUtils.toString(entity, PooledHttpConnection.this.defaultCharSet);
            if (log.isDebugEnabled())
                log.debug("Read " + responseBody.length() + " characters from stream.");

            int responseCode = httpResponse.getStatusLine().getStatusCode();
            if (responseCode != HttpStatus.SC_OK) {
                throw new RuntimeResponseException(responseCode, "unexpected response code: " + responseCode + "\n" + responseBody);
            }
            response.setEntity(entity);

            for (Header header : httpResponse.getAllHeaders()) {
                 response.addHeader(new BasicHeader(header.getName(), header.getValue()));
            }

            return response;
        }
    }

    private class ConvertGzipResponseWithErrorResponseCodeHandler implements ResponseHandler<HttpResponse> {
        @Override
        public HttpResponse handleResponse(org.apache.http.HttpResponse httpResponse) throws ClientProtocolException, IOException {
            HttpResponse response = new BasicHttpResponse(httpResponse.getStatusLine());

            HttpEntity entity = httpResponse.getEntity();

            if (log.isDebugEnabled())
                log.debug("Reading whole stream, content is " + entity.getContentLength() + " in " + entity.getContentType().getValue());

            // Check if server sent it back compressed
            if (entity.getContentEncoding() != null &&
                    entity.getContentEncoding().getValue().toLowerCase().indexOf("gzip") > -1) {
                log.debug("Response stream is using gzip compression");
                entity = new GzipDecompressingEntity(entity);
            } else {
                log.debug("Response stream is uncompressed");
            }

            String responseBody = EntityUtils.toString(entity, PooledHttpConnection.this.defaultCharSet);
            if (log.isDebugEnabled())
                log.debug("Read " + responseBody.length() + " characters from stream.");

            response.setEntity(entity);
            for (Header header : httpResponse.getAllHeaders()) {
                response.addHeader(new BasicHeader(header.getName(), header.getValue()));
            }

            return response;
        }
    }

    private class GzipAwareResponseHandler implements ResponseHandler<String> {
        @Override
        public String handleResponse(org.apache.http.HttpResponse httpResponse) throws ClientProtocolException, IOException {
            HttpEntity entity = httpResponse.getEntity();

            if (log.isDebugEnabled())
                log.debug("Reading whole stream, content is " + entity.getContentLength() + " in content type: " + entity.getContentType());

            // Check if server sent it back compressed
            if (entity.getContentEncoding() != null &&
                    entity.getContentEncoding().getValue().toLowerCase().indexOf("gzip") > -1) {
                log.debug("Response stream is using gzip compression");
                entity = new GzipDecompressingEntity(entity);
            } else {
                log.debug("Response stream is uncompressed");
            }

            String responseBody = EntityUtils.toString(entity, PooledHttpConnection.this.defaultCharSet);
            if (log.isDebugEnabled())
                log.debug("Read " + responseBody.length() + " characters from stream.");

            int responseCode = httpResponse.getStatusLine().getStatusCode();
            if (responseCode != HttpStatus.SC_OK) {
                throw new RuntimeResponseException(responseCode, "unexpected response code: " + responseCode + "\n" + responseBody);
            }

            return responseBody;
        }
    }

    private NameValuePair[] getNVPairs(Map<String, String> postParams){
        NameValuePair[] nvps = new NameValuePair[postParams.size()];
        int count = 0;
        for (Map.Entry<String, String> entry : postParams.entrySet()) {
            nvps[count++] = new BasicNameValuePair(entry.getKey(), entry.getValue());
        }
        return nvps;
    }

    static class RuntimeResponseException extends RuntimeException {
        private final int code;

        public RuntimeResponseException(int code, String message) {
            super(message);
            this.code = code;
        }

        public RuntimeResponseException(int code, String message, Throwable e) {
            super(message, e);
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }
}

