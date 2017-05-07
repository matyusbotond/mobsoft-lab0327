package com.example.mobsoft.mobsoft.mock.interceptors;

import android.net.Uri;

import com.example.mobsoft.mobsoft.helpers.GsonHelper;
import com.example.mobsoft.mobsoft.model.Roles;
import com.example.mobsoft.mobsoft.network.NetworkConfig;
import com.example.mobsoft.mobsoft.network.model.Invoice;
import com.example.mobsoft.mobsoft.network.model.Person;
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

public class PersonsMock {
    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString;
        int responseCode;
        Headers headers = request.headers();

        MemoryRepository memoryRepository = new MemoryRepository();

        List<Person> person = new ArrayList<>();
        Person f1 = new Person();
        f1.setId(BigDecimal.valueOf(1));
        f1.setName("Teszt Elek");
        f1.setPassword("valami");
        f1.setRole(Roles.Admin);
        f1.setUsername("teszt");
        person.add(f1);

        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "persons") && request.method().equals("POST")) {
            memoryRepository.open(null);
            responseString = GsonHelper.getGson().toJson(f1);
            responseCode = 200;
        } else if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "persons") && request.method().equals("GET")) {
            memoryRepository.open(null);
            responseString = GsonHelper.getGson().toJson(person);
            responseCode = 200;
        } else if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "persons/1") && request.method().equals("GET")) {
            memoryRepository.open(null);
            responseString = GsonHelper.getGson().toJson(f1);
            responseCode = 200;
        } else if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "persons/1") && request.method().equals("POST")) {
            memoryRepository.open(null);
            responseString = "";
            responseCode = 200;
        } else if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "persons/1") && request.method().equals("DELETE")) {
            memoryRepository.open(null);
            responseString = "";
            responseCode = 200;
        } else {
            responseString = "ERROR";
            responseCode = 503;
        }

        return makeResponse(request, headers, responseCode, responseString);
    }
}
