package org.lemona.test.httptools;

import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpUtil {
    public static String getPayload(HttpEntity entity){
        try {
            return EntityUtils.toString(entity);
        }catch (IOException e){
            return "";
        }

    }
}
