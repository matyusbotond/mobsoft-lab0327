package com.example.mobsoft.mobsoft.network.api;

import retrofit2.Call;
import retrofit2.http.*;

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
