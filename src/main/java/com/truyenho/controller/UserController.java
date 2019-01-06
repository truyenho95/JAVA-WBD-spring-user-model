package com.truyenho.controller;

import com.truyenho.dao.UserDao;
import com.truyenho.model.Login;
import com.truyenho.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

  @GetMapping("/home")
  public ModelAndView home() {
    return new ModelAndView("home", "login", new Login());
  }

  @PostMapping("/login")
  public ModelAndView login(@ModelAttribute("login") Login login){
    User user = UserDao.checkLogin(login);
    if(user == null){
      ModelAndView modelAndView = new ModelAndView("error");
      return modelAndView;
    } else {
      ModelAndView modelAndView = new ModelAndView("user");
      modelAndView.addObject("user", user);
      return modelAndView;
    }
  }
}
