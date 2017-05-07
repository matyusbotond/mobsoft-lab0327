package com.example.mobsoft.mobsoft.mock.interceptors;

/**
 * Created by matyu on 2017. 05. 07..
 */


import android.net.Uri;
import android.util.Log;

import com.example.mobsoft.mobsoft.network.NetworkConfig;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.mobsoft.mobsoft.mock.interceptors.MockHelper.makeResponse;

public class MockInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        return process(chain.request());
    }

    public Response process(Request request) {

        Uri uri = Uri.parse(request.url().toString());

        Log.d("Test Http Client", "URL call: " + uri.toString());
        Headers headers = request.headers();


        if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "invoice")) {
            return InvoicesMock.process(request);
        }

        if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "login")) {
            return UsersMock.process(request);
        }

        if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "persons")) {
            return PersonsMock.process(request);
        }

        return makeResponse(request, headers, 404, "Unknown");

    }

}
