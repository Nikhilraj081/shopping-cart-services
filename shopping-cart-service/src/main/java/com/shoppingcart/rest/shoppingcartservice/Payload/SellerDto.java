package com.shoppingcart.rest.shoppingcartservice.Payload;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;

public class SellerDto {

    private String sellerName;

    private String sellerAddress;

  
    private String sellerEmailId;

   
    private String sellerMobileNo;

    @Schema(accessMode = AccessMode.WRITE_ONLY)
    private String sellerPassword;

    public SellerDto(String sellerName, String sellerAddress, String sellerEmailId, String sellerMobileNo,
            String sellerPassword) {
        this.sellerName = sellerName;
        this.sellerAddress = sellerAddress;
        this.sellerEmailId = sellerEmailId;
        this.sellerMobileNo = sellerMobileNo;
        this.sellerPassword = sellerPassword;
    }


    public SellerDto() {
    }


    public String getSellerPassword() {
        return sellerPassword;
    }


    public void setSellerPassword(String sellerPassword) {
        this.sellerPassword = sellerPassword;
    }


    public String getSellerName() {
        return sellerName;
    }


    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }


    public String getSellerAddress() {
        return sellerAddress;
    }


    public void setSellerAddress(String sellerAddress) {
        this.sellerAddress = sellerAddress;
    }


    public String getSellerEmailId() {
        return sellerEmailId;
    }


    public void setSellerEmailId(String sellerEmailId) {
        this.sellerEmailId = sellerEmailId;
    }


    public String getSellerMobileNo() {
        return sellerMobileNo;
    }


    public void setSellerMobileNo(String sellerMobileNo) {
        this.sellerMobileNo = sellerMobileNo;
    }
}
