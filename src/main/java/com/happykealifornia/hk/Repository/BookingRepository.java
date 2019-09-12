package com.happykealifornia.hk.Repository;

import com.happykealifornia.hk.Model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class BookingRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public void newBooking (Booking booking) {
        PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("insert into booking values (null, ?, ?, ?, ?, ?)");
                ps.setString(1, booking.getHotelID());
                ps.setInt(2, booking.getRoomID());
                ps.setInt(3, booking.getCustomerID());
                ps.setDate(4, booking.getFromDate());
                ps.setDate(5, booking.getToDate());

                return ps;
            }
        };
        jdbc.update(psc);
    }


}
