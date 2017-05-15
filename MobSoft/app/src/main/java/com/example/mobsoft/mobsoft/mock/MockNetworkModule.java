package com.example.mobsoft.mobsoft.mock;

/**
 * Created by matyu on 2017. 05. 07..
 */
import com.example.mobsoft.mobsoft.network.NetworkModule;
import com.example.mobsoft.mobsoft.network.api.InvoicesApi;
import com.example.mobsoft.mobsoft.network.api.PersonsApi;
import com.example.mobsoft.mobsoft.network.api.UsersApi;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;

@Module
public class MockNetworkModule {
    private NetworkModule networkModule = new NetworkModule();

    @Provides
    @Singleton
    public OkHttpClient.Builder provideOkHttpClientBuilder() {
        return networkModule.provideOkHttpClientBuilder();
    }


    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {

        builder.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                return MockHttpServer.call(request);
            }
        });

        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client) {
        return networkModule.provideRetrofit(client);
    }

    @Provides
    @Singleton
    public InvoicesApi provideInvoicesApi(Retrofit retrofit) {
        return retrofit.create(InvoicesApi.class);
    }

    @Provides
    @Singleton
    public PersonsApi providePersonsApi(Retrofit retrofit) {
        return retrofit.create(PersonsApi.class);
    }

    @Provides
    @Singleton
    public UsersApi provideUsersApi(Retrofit retrofit) {
        return retrofit.create(UsersApi.class);
    }



}
