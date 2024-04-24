package com.shoppingcart.rest.shoppingcartservice.Payload;

public class SellerDto {

    private String sellerName;

    private String sellerAddress;

  
    private String sellerEmailId;

   
    private String sellerMobileNo;


    public SellerDto(String sellerName, String sellerAddress, String sellerEmailId, String sellerMobileNo) {
        this.sellerName = sellerName;
        this.sellerAddress = sellerAddress;
        this.sellerEmailId = sellerEmailId;
        this.sellerMobileNo = sellerMobileNo;
    }


    public SellerDto() {
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
