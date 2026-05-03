package com.example.sql.server.proxy.dto;

import lombok.Builder;

@Builder
public class CustomerResponseDTO {

    private Integer id;
    private String type;
    private String phone;
    private String email;

    private String firstName;
    private String lastName;
    private String identificationNumber;

    private String businessName;
    private String rnc;

    public CustomerResponseDTO(Integer id, String type, String phone, String email, String businessName, String rnc) {
        this.id = id;
        this.type = type;
        this.phone = phone;
        this.email = email;
        this.businessName = businessName;
        this.rnc = rnc;
    }

    public CustomerResponseDTO(Integer id, String type, String phone, String email, String firstName, String lastName, String identificationNumber) {
        this.id = id;
        this.type = type;
        this.phone = phone;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.identificationNumber = identificationNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        return "CustomerResponseDTO{" +
                "id=" + id +
                ", type='" + type + '\'' +
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
