package com.happykealifornia.hk.Repository;

import com.happykealifornia.hk.Model.Room;
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
public class RoomRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public Room findRoom(int room_id) {
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM room WHERE Room_ID = " + room_id);
        Room room = new Room();
        while (rs.next()) {
            room.setRoom_id(rs.getInt("room_id"));
            room.setRoom_id(rs.getInt("hotel_id"));
            room.setHotel(rs.getString("hotel"));
            room.setRoom_type(rs.getString("room_type"));
        }
        return room;
    }

    public List<Room> findAllRooms() {
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM room");
        List<Room> roomList = new ArrayList<>();
        while (rs.next()) {
            Room room = new Room();
            room.setRoom_id(rs.getInt("room_id"));
            room.setHotel_id(rs.getInt("hotel_id"));
            room.setHotel(rs.getString("hotel"));
            room.setRoom_type(rs.getString("room_type"));

            roomList.add(room);
        }
        return roomList;
    }

    public Room insert(Room room) {

        PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO room VALUES(null , null,?,?)", new String[]{"room_id"});
                ps.setString(1, room.getHotel());
                ps.setString(2, room.getRoom_type());

                return ps;
            }
        };

        KeyHolder id = new GeneratedKeyHolder();
        jdbc.update(psc, id);
        room.setRoom_id(id.getKey().intValue());
        return room;
    }

    public void update(Room room) {
        String sql = "UPDATE room SET hotel=?, room_type=? WHERE room_id=" + room.getRoom_id();
        jdbc.update(sql, room.getHotel(), room.getRoom_type());
    }

    public void delete(int room_id) {
        jdbc.update("DELETE FROM room WHERE room_id = " + room_id);
    }


}
