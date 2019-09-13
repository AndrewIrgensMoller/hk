package com.happykealifornia.hk.Model;

import java.math.BigDecimal;

public class Room {
    //variables
    private int room_id;
    private int hotel_id;
    private String hotel;
    private String room_type;
    private BigDecimal costPerNight;

    //constructor
    public Room() {
    }

    public Room(int room_id, int hotel_id, String hotel, String room_type, BigDecimal costPerNight) {
        this.room_id = room_id;
        this.hotel_id = hotel_id;
        this.hotel = hotel;
        this.room_type = room_type;
        this.costPerNight=costPerNight;
    }

    public BigDecimal getCostPerNight() {
        return costPerNight;
    }

    public void setCostPerNight(BigDecimal costPerNight) {
        this.costPerNight = costPerNight;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    @Override
    public String toString() {
        return "Room{" +
                "room_id=" + room_id +
                ", hotel_id=" + hotel_id +
                ", hotel='" + hotel + '\'' +
                ", room_type='" + room_type + '\'' +
                ", costPerNight=" + costPerNight +
                '}';
    }
}

