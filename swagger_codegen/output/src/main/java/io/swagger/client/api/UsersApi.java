package io.swagger.client.api;

import io.swagger.client.CollectionFormats.*;


import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import io.swagger.client.model.Error;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UsersApi {
  
  /**
   * Bejelentkezés
   * Felhasználó beléptetése
   * @param username Felhasználónév
   * @param password Hashelt jelszó
   * @return Call<Void>
   */
  
  @POST("login")
  Call<Void> loginPost(
    @Query("username") String username, @Query("password") String password
  );

  
  /**
   * Kijelentkezés
   * Bejelentkezett felhasználó kijelentkeztetése
   * @return Call<Void>
   */
  
  @POST("logout")
  Call<Void> logoutPost();
    

  
}
