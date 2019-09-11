package com.happykealifornia.hk.Repository;

import com.happykealifornia.hk.Model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class HotelRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public Hotel findHotel(int hotel_id) {
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM hotel WHERE hotel = " + hotel_id);
        Hotel hotel = new Hotel();
        while (rs.next()) {
            hotel.setHotel_id(rs.getInt("hotel_id"));
            hotel.setHotel(rs.getString("hotel"));
        }
        return hotel;
    }

    public List<Hotel> findAllHotels() {
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM hotel");
        List<Hotel> hotelList = new ArrayList<>();
        while (rs.next()) {
            Hotel hotel = new Hotel();
            hotel.setHotel_id(rs.getInt("hotel_id"));
            hotel.setHotel(rs.getString("hotel"));

            hotelList.add(hotel);
        }
        return hotelList;
    }

    public Hotel insert(Hotel hotel) {
        PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO hotel VALUES(null,?)", new String[]{"hotel_id"});
                ps.setString(1, hotel.getHotel());
                return ps;
            }
        };

        KeyHolder id = new GeneratedKeyHolder();
        jdbc.update(psc, id);
        hotel.setHotel_id(id.getKey().intValue());
        return hotel;
    }

    public void update(Hotel hotel) {
        String sql = "UPDATE hotel SET hotel=?, WHERE hotel_id=" + hotel.getHotel_id();
        jdbc.update(sql, hotel.getHotel());
    }

    public void delete(int hotel_id) {
        jdbc.update("DELETE FROM hotel WHERE hotel_id = " + hotel_id);
    }


}
