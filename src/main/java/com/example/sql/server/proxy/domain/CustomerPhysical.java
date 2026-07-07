package com.example.sql.server.proxy.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "CustomerPhysical", schema = "WebApp")
@PrimaryKeyJoinColumn(name = "CustomerId")
public class CustomerPhysical extends Customer {

    @Column(name = "FirstName", nullable = false, length = 50)
    private String firstName;

    @Column(name = "LastName", nullable = false, length = 50)
    private String lastName;

    @Column(name = "IdentificationNumber", length = 30)
    private String identificationNumber;

    @PrePersist
    public void setType() {
        super.setCustomerType(CustomerType.F);
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

    @Override
    public String toString() {
        return "CustomerPhysical{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", identificationNumber='" + identificationNumber + '\'' +
                '}';
    }
}
