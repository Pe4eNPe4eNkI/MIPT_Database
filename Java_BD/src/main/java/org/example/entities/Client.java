package org.example.entities;


import javax.xml.crypto.Data;
import java.sql.Date;

public class Client {

    private Integer clientId;

    private String firstName;

    private String secondName;

    private String lastName;

    private Date hbData;

    private String passportNumber;

    private String phoneNumber;

    public Client(Integer clientId, String firstName, String secondName, String lastName, Date hbData, String passportNumber, String phoneNumber) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.hbData = hbData;
        this.passportNumber = passportNumber;
        this.phoneNumber = phoneNumber;
    }

    public Client() {

    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getHbData() {
        return (Date) hbData;
    }

    public void setHbData(Date hbData) {
        this.hbData = hbData;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", firstName=" + firstName +
                ", secondName=" + secondName +
                ", lastName=" + lastName +
                ", hbData=" + hbData +
                ", passportNumber=" + passportNumber +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}

