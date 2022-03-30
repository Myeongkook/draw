package com.portfolio.draw.controller;

import com.portfolio.draw.domain.Member;
import com.portfolio.draw.service.UserService;
import org.springframework.stereotype.Controller;
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
    public Member login(String id, String pw){
        Member member = new Member();
        member.setName(id);
        return member;
    }

    @ResponseBody
    @PostMapping(value = "/api/signup")
    public Long save(Member member){
        userService.join(member);
        return member.getUserId();
    }

    @ResponseBody
    @PostMapping(value = "/api/checkid")
    public boolean findById(String id){
        return userService.checkId(id);
    }

}
