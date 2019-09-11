package com.happykealifornia.hk.Model;

public class Room {
    //variables
    private int room_id;
    private String hotel;
    private int room_type;

    //constructor
    public Room() {
    }
    public Room(int room_id, String hotel, int room_type) {
        this.room_id = room_id;
        this.hotel = hotel;
        this.room_type = room_type;
    }

    public int getRoom_id() {
        return room_id;
    }

    public String getHotel() {
        return hotel;
    }

    public int getRoom_type() {
        return room_type;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public void setRoom_type(int room_type) {
        this.room_type = room_type;
    }

    @Override
    public String toString() {
        return "Room{" +
                "room_id=" + room_id +
                ", hotel='" + hotel + '\'' +
                ", room_type=" + room_type +
                '}';
    }
}
