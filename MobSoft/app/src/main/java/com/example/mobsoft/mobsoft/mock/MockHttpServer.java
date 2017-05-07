package com.example.mobsoft.mobsoft.mock;

/**
 * Created by matyu on 2017. 05. 07..
 */

import com.example.mobsoft.mobsoft.mock.interceptors.MockInterceptor;

import okhttp3.Request;
import okhttp3.Response;

public class MockHttpServer {

    public static Response call(Request request) {
        MockInterceptor mockInterceptor = new MockInterceptor();
        return mockInterceptor.process(request);
    }
}
