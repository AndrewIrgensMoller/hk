package com.happykealifornia.hk.Controller;

import com.happykealifornia.hk.Model.Hotel;
import com.happykealifornia.hk.Repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HotelController {

    @Autowired
    private HotelRepository hotelRepo;

    @GetMapping("/hotel")
    public String hotel(Model model) {
        List<Hotel> hotelList = hotelRepo.findAllHotels();
        model.addAttribute("hotels", hotelList);
        return "show-hotels";
    }

    @GetMapping("/addhotel")
    public String addHotel(Model m) {
        m.addAttribute("hotelform", new Hotel());
        return "add-hotel";
    }

    @PostMapping("/savehotel")
    //    @ResponseBody
    public String save(@ModelAttribute Hotel hotel) {
        Hotel hotelInserted = hotelRepo.insert(hotel);
        return "redirect:/hotel";
    }

    @GetMapping("/hotelv")
    @ResponseBody
    public Hotel showHotel(int hotel_id) {
        Hotel hotel = hotelRepo.findHotel(hotel_id);
        return hotel;
    }

    @GetMapping("/updatehotel/{hotel_id}")
    public String updateHotel(@PathVariable(name = "hotel_id") int hotel_id, Model m) {
        Hotel hotelData = hotelRepo.findHotel(hotel_id);
        m.addAttribute("hotelform", hotelData);
        return "update-hotel";
    }

    @PostMapping("/saveupdate")
    public String saveUpdateHotel(@ModelAttribute Hotel hotel) {
        hotelRepo.update(hotel);
        return "redirect:/hotel";
    }

    @GetMapping("/deletehotel/{hotel_id}")
    public String deleteHotel(@PathVariable(name = "hotel_id") int hotel_id) {
        hotelRepo.delete(hotel_id);
        return "redirect:/hotel";
    }


}
