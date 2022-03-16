package com.portfolio.draw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestApiController {


    @ResponseBody
    @PostMapping(value = "/api/login")
    public boolean Login(String id, String pw){
        return id.equals("test") & pw.equals("pw");
    }
}
