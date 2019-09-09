package com.happykealifornia.hk.Model;

public class Customer {
    private int customerID;
    private String customerName;
    private String customerContact;

    public Customer(int customerID, String customerName, String customerContact) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerContact = customerContact;
    }

    public Customer() {
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(String customerContact) {
        this.customerContact = customerContact;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", customerName='" + customerName + '\'' +
                ", customerContact='" + customerContact + '\'' +
                '}';
    }
}

