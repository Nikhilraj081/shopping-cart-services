package com.shoppingcart.rest.shoppingcartservice.Payload;

public class AddressDto {

  
    private int addressId;

    private String name;

    private String phoneNo;;

    private int pinCode;

    private String state;

    private String city;

    private String area;
   
    private String addressType;

    public AddressDto(int addressId, String name, String phoneNo, int pinCode, String state, String city, String area,
            String addressType) {
        this.addressId = addressId;
        this.name = name;
        this.phoneNo = phoneNo;
        this.pinCode = pinCode;
        this.state = state;
        this.city = city;
        this.area = area;
        this.addressType = addressType;
    }

    public AddressDto() {
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    

}
