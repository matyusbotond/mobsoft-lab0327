package com.example.mobsoft.mobsoft.mock.interceptors;

import android.net.Uri;

import com.example.mobsoft.mobsoft.helpers.GsonHelper;
import com.example.mobsoft.mobsoft.network.NetworkConfig;
import com.example.mobsoft.mobsoft.network.api.UsersApi;
import com.example.mobsoft.mobsoft.network.model.Invoice;
import com.example.mobsoft.mobsoft.repository.MemoryRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.mobsoft.mobsoft.mock.interceptors.MockHelper.makeResponse;

/**
 * Created by matyu on 2017. 05. 07..
 */

public class UsersMock {
    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString;
        int responseCode;
        Headers headers = request.headers();

        MemoryRepository memoryRepository = new MemoryRepository();

         if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "login") && request.method().equals("POST")) {
            memoryRepository.open(null);
            responseCode = 200;
        } else {
            responseString = "ERROR";
            responseCode = 503;
        }

        return makeResponse(request, headers, responseCode, null);
    }
}
