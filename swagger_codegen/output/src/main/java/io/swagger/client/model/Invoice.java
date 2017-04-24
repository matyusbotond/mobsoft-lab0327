package io.swagger.client.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

import com.google.gson.annotations.SerializedName;




@ApiModel(description = "")
public class Invoice   {
  
  @SerializedName("id")
  private BigDecimal id = null;
  
  @SerializedName("fromAddress")
  private String fromAddress = null;
  
  @SerializedName("fromName")
  private String fromName = null;
  
  @SerializedName("created")
  private String created = null;
  
  @SerializedName("netAmount")
  private BigDecimal netAmount = null;
  
  @SerializedName("tax")
  private BigDecimal tax = null;
  

  
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
   * Kiállító cég címe
   **/
  @ApiModelProperty(value = "Kiállító cég címe")
  public String getFromAddress() {
    return fromAddress;
  }
  public void setFromAddress(String fromAddress) {
    this.fromAddress = fromAddress;
  }

  
  /**
   * Kiállító cég neve.
   **/
  @ApiModelProperty(value = "Kiállító cég neve.")
  public String getFromName() {
    return fromName;
  }
  public void setFromName(String fromName) {
    this.fromName = fromName;
  }

  
  /**
   * Keletkezés dátuma.
   **/
  @ApiModelProperty(value = "Keletkezés dátuma.")
  public String getCreated() {
    return created;
  }
  public void setCreated(String created) {
    this.created = created;
  }

  
  /**
   * Nettó végösszeg
   **/
  @ApiModelProperty(value = "Nettó végösszeg")
  public BigDecimal getNetAmount() {
    return netAmount;
  }
  public void setNetAmount(BigDecimal netAmount) {
    this.netAmount = netAmount;
  }

  
  /**
   * Áfa tartalom
   **/
  @ApiModelProperty(value = "Áfa tartalom")
  public BigDecimal getTax() {
    return tax;
  }
  public void setTax(BigDecimal tax) {
    this.tax = tax;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Invoice invoice = (Invoice) o;
    return Objects.equals(id, invoice.id) &&
        Objects.equals(fromAddress, invoice.fromAddress) &&
        Objects.equals(fromName, invoice.fromName) &&
        Objects.equals(created, invoice.created) &&
        Objects.equals(netAmount, invoice.netAmount) &&
        Objects.equals(tax, invoice.tax);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, fromAddress, fromName, created, netAmount, tax);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Invoice {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    fromAddress: ").append(toIndentedString(fromAddress)).append("\n");
    sb.append("    fromName: ").append(toIndentedString(fromName)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    netAmount: ").append(toIndentedString(netAmount)).append("\n");
    sb.append("    tax: ").append(toIndentedString(tax)).append("\n");
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
