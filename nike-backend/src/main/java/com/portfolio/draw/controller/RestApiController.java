package com.portfolio.draw.controller;

import com.portfolio.draw.domain.User;
import com.portfolio.draw.repository.UserRepository;
import com.portfolio.draw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestApiController {


    UserService userService;

    public RestApiController(UserService UserService){
        this.userService = UserService;
    }

    @ResponseBody
    @PostMapping(value = "/api/login")
    public User login(String id, String pw){
        User user = new User();
        user.setName(id);
        return user;
    }

    @ResponseBody
    @PostMapping(value = "/api/signup")
    public Long save(User user){
        userService.join(user);
        return user.getUserId();
    }

}
