package com.example.mobsoft.mobsoft.network.api;


import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import com.example.mobsoft.mobsoft.network.model.Invoice;
import com.example.mobsoft.mobsoft.network.model.Error;
import com.example.mobsoft.mobsoft.network.model.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface PersonsApi {
  
  /**
   * Számla lista
   * Visszaadja a bejelntkezett felhasználó összes számláját.
   * @return Call<List<Invoice>>
   */
  
  @GET("invoices")
  Call<List<Invoice>> invoicesGet();
    

  
  /**
   * Persons list
   * Visszaadja a bejelentkezett felhasználóhoz tartozó szeélyeket.
   * @return Call<List<Person>>
   */
  
  @GET("persons")
  Call<List<Person>> personsGet();
    

  
  /**
   * Új személyt szúr a bejelentkezett felhasználóhoz
   * Elment egy személyt.
   * @param person Felhasználó
   * @return Call<Person>
   */
  
  @POST("persons")
  Call<Person> personsPost(
          @Body Invoice person
  );

  
  /**
   * Persons
   * Visszaadja a bejelentkezett felhasználóhoz tartozó szeélyeket.
   * @param id Id szerint a felhasználó
   * @return Call<Person>
   */
  
  @GET("persons/{id}")
  Call<Person> personsIdGet(
          @Path("id") Double id
  );

  
  /**
   * save person
   * Elment egy személyt.
   * @param id Id szerint a felhasználó
   * @return Call<Person>
   */
  
  @PUT("persons/{id}")
  Call<Person> personsIdPut(
          @Path("id") Double id
  );

  
  /**
   * remove person
   * Kitöröl egy személyt.
   * @param id Id szerint a felhasználó
   * @return Call<Person>
   */
  
  @DELETE("persons/{id}")
  Call<Person> personsIdDelete(
          @Path("id") Double id
  );

  
}
