package com.example.sql.server.proxy.dto;

import java.io.Serializable;

public class CustomerRequestDTO implements Serializable {

    private String type; // "F" o "M"

    private String phone;
    private String email;

    // Físico
    private String firstName;
    private String lastName;
    private String identificationNumber;

    // Moral
    private String businessName;
    private String rnc;

    public CustomerRequestDTO(String type, String phone, String email, String firstName, String lastName, String identificationNumber, String businessName, String rnc) {
        this.type = type;
        this.phone = phone;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.identificationNumber = identificationNumber;
        this.businessName = businessName;
        this.rnc = rnc;
    }

    public CustomerRequestDTO() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getRnc() {
        return rnc;
    }

    public void setRnc(String rnc) {
        this.rnc = rnc;
    }

    @Override
    public String toString() {
        return "CustomerRequestDTO{" +
                "type='" + type + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", identificationNumber='" + identificationNumber + '\'' +
                ", businessName='" + businessName + '\'' +
                ", rnc='" + rnc + '\'' +
                '}';
    }
}
