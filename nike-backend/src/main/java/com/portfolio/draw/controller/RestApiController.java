package com.portfolio.draw.controller;

import com.portfolio.draw.dto.LoginParam;
import com.portfolio.draw.domain.Member;
import com.portfolio.draw.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class RestApiController {


    UserService userService;

    public RestApiController(UserService UserService){
        this.userService = UserService;
    }

    @ResponseBody
    @GetMapping(value = "/api/login")
    public boolean login(@RequestBody LoginParam loginParam){
        System.out.println(loginParam.getId()+loginParam.getPw());
        return true;
    }

    @ResponseBody
    @PostMapping(value = "/api/signup")
    public Long save(Member member){
        userService.join(member);
        return member.getMemberId();
    }

    @ResponseBody
    @GetMapping(value = "/api/checkid")
    public boolean findById(@RequestBody String id){
        return userService.checkId(id);
    }

}
