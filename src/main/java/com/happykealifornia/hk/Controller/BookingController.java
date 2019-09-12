package com.happykealifornia.hk.Controller;

import com.happykealifornia.hk.Model.Booking;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookingController {

    //
    @GetMapping("/add-booking")
    public String newBooking(Model m) {
        m.addAttribute("newBooking", new Booking());
        return "/add-booking";
    }

}
