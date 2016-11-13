package com.mohanfoundation.mohanfoundation;

/**
 * Created by 986513 on 2/11/2016.
 */
public class DataObjectEyeBank {
    private String state;
    private String city;
    private String nameOfEyebank;
    private String postalAddress;
    private String phone;



    DataObjectEyeBank(String state, String city, String nameOfEyebank, String postalAddress, String phone) {
        this.state = state;
        this.city = city;
        this.nameOfEyebank = nameOfEyebank;
        this.postalAddress = postalAddress;
        this.phone = phone;

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

    public String getNameOfEyebank() {
        return nameOfEyebank;
    }

    public void setNameOfEyebank(String nameOfEyebank) {
        this.nameOfEyebank = nameOfEyebank;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

   }