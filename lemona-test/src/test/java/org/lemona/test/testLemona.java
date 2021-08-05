package org.lemona.test;

import org.lemona.test.httptools.ConnectionException;
import org.lemona.test.httptools.HttpResp;
import org.lemona.test.httptools.PooledHttpConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

@Test
@ContextConfiguration(locations = { "classpath:test-context.xml" })
public class testLemona extends AbstractTestNGSpringContextTests{
    @Autowired
    PooledHttpConnection pooledHttpConnection;

    @BeforeTest
    public void setup() throws Exception {
    }

    @Test
    public void smoke(){
        try {
          HttpResp response = pooledHttpConnection.get("http://localhost:8042/lemona", null, null);
          logger.info(response.getResponse());
        }catch (ConnectionException | IOException e){

        }
    }

    public void shutdown(){
    }
}