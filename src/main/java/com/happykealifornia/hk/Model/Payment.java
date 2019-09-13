package com.happykealifornia.hk.Model;

import java.math.BigDecimal;

public class Payment {
    //variables
    private int payment_id;
    private int customer_id;
    private int booking_id;
    private BigDecimal amount;

    Booking booking = new Booking();
    Room room = new Room();

    //constructor

    public Payment(int payment_id, int customer_id, int booking_id) {
        this.payment_id = payment_id;
        this.customer_id = customer_id;
        this.booking_id = booking_id;
        this.amount = getTotalRoomsCost();
    }

    //getters and setters

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    // returns Total nights * costPerNight
    public BigDecimal getTotalRoomsCost() {
        long nights = booking.getTotalNights();
        if (nights == 0) {
            return BigDecimal.ZERO;
        }
        return room.getCostPerNight().multiply(BigDecimal.valueOf(nights));
    }

    // converts currency DKK to HDD and vice-versa


    @Override
    public String toString() {
        return "Payment{" +
                "payment_id=" + payment_id +
                ", customer_id=" + customer_id +
                ", booking_id=" + booking_id +
                ", amount=" + amount +
                '}';
    }
}
