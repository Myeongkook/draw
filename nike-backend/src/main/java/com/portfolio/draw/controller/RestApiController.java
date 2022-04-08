package com.portfolio.draw.controller;

import com.portfolio.draw.dto.LoginParam;
import com.portfolio.draw.domain.Member;
import com.portfolio.draw.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class RestApiController {


    UserService userService;

    public RestApiController(UserService UserService){
        this.userService = UserService;
    }

    @ResponseBody
    @GetMapping(value = "/login")
    public boolean login(@RequestBody LoginParam loginParam){
        System.out.println(loginParam.getId()+loginParam.getPw());
        return true;
    }

    @ResponseBody
    @PostMapping(value = "/signup")
    public Long save(@RequestBody Member member){
        userService.join(member);
        return member.getMemberId();
    }

    @ResponseBody
    @GetMapping(value = "/checkid/{id}")
    public boolean findById(@PathVariable("id") String id){
        return userService.checkId(id);
    }

}
