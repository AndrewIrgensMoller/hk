package com.happykealifornia.hk.Model;

import java.sql.Date;

public class Booking {
    private int BookingID;
    private String HotelName;
    private String HotelID;
    private int RoomType;
    private int RoomID;
    private int CustomerID;
    private Date FromDate;
    private Date ToDate;

    public Booking(int bookingID, String hotelName, int roomType, int roomID, Date fromDate, Date toDate) {
        BookingID = bookingID;
        HotelName = hotelName;
        RoomType = roomType;
        RoomID = roomID;
        FromDate = fromDate;
        ToDate = toDate;
    }

    public Booking() {}

    public int getBookingID() {
        return BookingID;
    }

    public void setBookingID(int bookingID) {
        BookingID = bookingID;
    }

    public String getHotelName() {
        return HotelName;
    }

    public String getHotelID() {
        return HotelID;
    }

    public void setHotelID(String hotelID) {
        HotelID = hotelID;
    }

    public void setHotelName(String hotelName) {
        HotelName = hotelName;
    }

    public int getRoomType() {
        return RoomType;
    }

    public void setRoomType(int roomType) {
        RoomType = roomType;
    }

    public int getRoomID() {
        return RoomID;
    }

    public void setRoomID(int roomID) {
        RoomID = roomID;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public Date getFromDate() {
        return FromDate;
    }

    public void setFromDate(Date fromDate) {
        FromDate = fromDate;
    }

    public Date getToDate() {
        return ToDate;
    }

    public void setToDate(Date toDate) {
        ToDate = toDate;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "BookingID=" + BookingID +
                ", HotelName='" + HotelName + '\'' +
                ", HotelID='" + HotelID + '\'' +
                ", RoomType=" + RoomType +
                ", RoomID=" + RoomID +
                ", CustomerID=" + CustomerID +
                ", FromDate=" + FromDate +
                ", ToDate=" + ToDate +
                '}';
    }
}
