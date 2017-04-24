package io.swagger.client.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

import com.google.gson.annotations.SerializedName;




@ApiModel(description = "")
public class Person   {
  
  @SerializedName("id")
  private BigDecimal id = null;
  
  @SerializedName("name")
  private String name = null;
  
  @SerializedName("username")
  private String username = null;
  
  @SerializedName("role")
  private String role = null;
  
  @SerializedName("password")
  private String password = null;
  

  
  /**
   * Egyedi azonosító.
   **/
  @ApiModelProperty(value = "Egyedi azonosító.")
  public BigDecimal getId() {
    return id;
  }
  public void setId(BigDecimal id) {
    this.id = id;
  }

  
  /**
   * Megjelenítendő név.
   **/
  @ApiModelProperty(value = "Megjelenítendő név.")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   * Felhasználó egyedi felhasználóneve.
   **/
  @ApiModelProperty(value = "Felhasználó egyedi felhasználóneve.")
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }

  
  /**
   * Felhasználó jogosultsági szerepköre.
   **/
  @ApiModelProperty(value = "Felhasználó jogosultsági szerepköre.")
  public String getRole() {
    return role;
  }
  public void setRole(String role) {
    this.role = role;
  }

  
  /**
   * Felhasználó jelszava.
   **/
  @ApiModelProperty(value = "Felhasználó jelszava.")
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Person person = (Person) o;
    return Objects.equals(id, person.id) &&
        Objects.equals(name, person.name) &&
        Objects.equals(username, person.username) &&
        Objects.equals(role, person.role) &&
        Objects.equals(password, person.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, username, role, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Person {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
