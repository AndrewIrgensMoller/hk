package com.happykealifornia.hk.Controller;

import com.happykealifornia.hk.Model.Room;
import com.happykealifornia.hk.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RoomController {

    @Autowired
    private RoomRepository roomRepo;

    @GetMapping("/room")
    public String room(Model model) {
        List<Room> roomList = roomRepo.findAllRooms();
        model.addAttribute("rooms", roomList);
        return "show-rooms";
    }

    @GetMapping("/addroom")
    public String addRoom(Model m) {
        m.addAttribute("roomform", new Room());
        return "add-room";
    }

    @PostMapping("/saveroom")
    //    @ResponseBody
    public String save(@ModelAttribute Room room) {
        Room roomInserted = roomRepo.insert(room);
        return "redirect:/room";
    }

    @GetMapping("/roomv")
    @ResponseBody
    public Room showRoom(int room_id) {
        Room room = roomRepo.findRoom(room_id);
        return room;
    }

    @GetMapping("/updateroom/{room_id}")
    public String updateRoom(@PathVariable(name = "room_id") int room_id, Model m) {
        Room roomData = roomRepo.findRoom(room_id);
        m.addAttribute("roomform", roomData);
        return "update-room";
    }

    @PostMapping("/saveupdates")
    public String saveUpdateRoom(@ModelAttribute Room room) {
        roomRepo.update(room);
        return "redirect:/room";
    }

    @GetMapping("/deleteroom/{room_id}")
    public String deleteRoom(@PathVariable(name = "room_id") int room_id) {
        roomRepo.delete(room_id);
        return "redirect:/room";
    }

}
