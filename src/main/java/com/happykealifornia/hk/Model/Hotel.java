package com.happykealifornia.hk.Model;

public class Hotel {

    //variables
    private int hotel_id;
    private String hotel;

    //constructor
    public Hotel(){}
    public Hotel(int hotel_id, String hotel) {
        this.hotel_id = hotel_id;
        this.hotel = hotel;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel=hotel;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotel_id=" + hotel_id +
                ", hotel='" + hotel + '\'' +
                '}';
    }
}
