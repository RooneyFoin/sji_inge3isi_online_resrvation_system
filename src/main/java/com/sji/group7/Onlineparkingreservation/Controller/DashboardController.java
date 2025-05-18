package com.sji.group7.Onlineparkingreservation.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/Admin/Admin")
    public String adminDashboard(HttpSession session, Model model) {
        // The welcomeMessage is set in the session on login success
        // It can be accessed in Thymeleaf via session.welcomeMessage
        return "Admin/Admin"; // this corresponds to admin_dashboard.html template
    }

    @GetMapping("/User/user")
    public String userDashboard(HttpSession session, Model model) {
        // The welcomeMessage is set in the session on login success
        return "User/user"; // this corresponds to user_dashboard.html template
    }
}
