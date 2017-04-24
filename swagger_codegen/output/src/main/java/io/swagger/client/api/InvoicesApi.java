package io.swagger.client.api;

import io.swagger.client.CollectionFormats.*;


import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import io.swagger.client.model.Invoice;
import io.swagger.client.model.Error;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface InvoicesApi {
  
  /**
   * Új számlát szúr be
   * Egy még nem létező számlát beszúr.
   * @param invoice Számla
   * @return Call<Invoice>
   */
  
  @POST("invoices")
  Call<Invoice> invoicesPost(
    @Body Invoice invoice
  );

  
  /**
   * Egy számlát ad vissza
   * Visszaadja a megfelelő Id-jó számlát.
   * @param id Id szerinti számla
   * @return Call<Invoice>
   */
  
  @GET("invoices/{id}")
  Call<Invoice> invoicesIdGet(
    @Path("id") Double id
  );

  
  /**
   * Számla mentése
   * Megadott Id-val elmenti a számlát.
   * @param id Id szerint a számla
   * @return Call<Invoice>
   */
  
  @PUT("invoices/{id}")
  Call<Invoice> invoicesIdPut(
    @Path("id") Double id
  );

  
  /**
   * Kitöröli a megadott számlát
   * A megadott azonosítóval rendelkező számlát kitörli.
   * @param id Id szerint a számla
   * @return Call<Invoice>
   */
  
  @DELETE("invoices/{id}")
  Call<Invoice> invoicesIdDelete(
    @Path("id") Double id
  );

  
}
