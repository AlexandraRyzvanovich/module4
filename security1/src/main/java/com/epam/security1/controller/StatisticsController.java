package com.epam.security1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StatisticsController {

  @GetMapping("/info")
  public String getStatistics() {

    return "index";
  }

  @RequestMapping("/login")
  public String getLogin() {
    return "login";
  }

  @GetMapping("/login?success")
  public String getLoginSuccess() {
    return "loginSuccess";
  }

  @GetMapping("/about")
  public String getAbout() {
    return "about";
  }

  @GetMapping("/admin")
  public String getAdmin() {
    return "admin";
  }

  @GetMapping("/user")
  public String getUser() {
    return "user";
  }

  @GetMapping("/guest")
  public String getGuest() {
    return "guest";
  }
}
