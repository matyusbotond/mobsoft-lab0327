package com.example.mobsoft.mobsoft.mock.interceptors;

/**
 * Created by matyu on 2017. 05. 07..
 */
import android.net.Uri;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.example.mobsoft.mobsoft.network.NetworkConfig;
import com.example.mobsoft.mobsoft.network.model.Invoice;
import com.example.mobsoft.mobsoft.repository.MemoryRepository;
import com.example.mobsoft.mobsoft.helpers.GsonHelper;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.mobsoft.mobsoft.mock.interceptors.MockHelper.makeResponse;

public class InvoicesMock {
    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString;
        int responseCode;
        Headers headers = request.headers();

        MemoryRepository memoryRepository = new MemoryRepository();

        List<Invoice> invoice = new ArrayList<>();
        Invoice f1 = new Invoice();
        f1.setCreated("2017. 01. 01.");
        f1.setFromAddress("2117 Isaszeg Mátyás király utca 29.");
        f1.setFromName("Teszt elek");
        f1.setId(BigDecimal.valueOf(1));
        f1.setNetAmount(BigDecimal.valueOf(100));
        f1.setTax(BigDecimal.valueOf(27));
        f1.setFromAddress("");
        invoice.add(f1);

        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "invoices") && request.method().equals("POST")) {
            memoryRepository.open(null);
            responseString = GsonHelper.getGson().toJson(f1);
            responseCode = 200;
        } else if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "invoices") && request.method().equals("GET")) {
            memoryRepository.open(null);
            responseString = GsonHelper.getGson().toJson(invoice);
            responseCode = 200;
        } else if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "invoices/1") && request.method().equals("GET")) {
            memoryRepository.open(null);
            responseString = GsonHelper.getGson().toJson(f1);
            responseCode = 200;
        } else if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "invoices/1") && request.method().equals("POST")) {
            memoryRepository.open(null);
            responseString = "";
            responseCode = 200;
        } else if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "invoices/1") && request.method().equals("DELETE")) {
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