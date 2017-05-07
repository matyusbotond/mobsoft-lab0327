package com.example.mobsoft.mobsoft.network;

/**
 * Created by matyu on 2017. 05. 07..
 */

import com.example.mobsoft.mobsoft.helpers.GsonHelper;
import com.example.mobsoft.mobsoft.network.api.InvoicesApi;
import com.example.mobsoft.mobsoft.network.api.PersonsApi;
import com.example.mobsoft.mobsoft.network.api.UsersApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    public OkHttpClient.Builder provideOkHttpClientBuilder() {
        return new OkHttpClient().newBuilder();
    }


    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {
        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit.Builder().baseUrl(NetworkConfig.SERVICE_ENDPOINT).client(client)
                .addConverterFactory(GsonConverterFactory.create(GsonHelper.getGson())).build();
    }

    @Provides
    @Singleton
    public InvoicesApi provideInvoiceApi(Retrofit retrofit) {
        return retrofit.create(InvoicesApi.class);
    }

    @Provides
    @Singleton
    public PersonsApi providePersonsApi(Retrofit retrofit) {
        return retrofit.create(PersonsApi.class);
    }

    @Provides
    @Singleton
    public UsersApi provideUserApi(Retrofit retrofit) {
        return retrofit.create(UsersApi.class);
    }


}
