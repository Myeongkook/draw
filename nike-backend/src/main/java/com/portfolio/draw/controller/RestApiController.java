package com.portfolio.draw.controller;

import com.portfolio.draw.domain.Draw;
import com.portfolio.draw.dto.LoginParam;
import com.portfolio.draw.domain.Member;
import com.portfolio.draw.dto.PhoneCertificationDto;
import com.portfolio.draw.service.DrawService;
import com.portfolio.draw.service.UserService;
import org.json.JSONArray;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class RestApiController {


    UserService userService;
    DrawService drawService;

    public RestApiController(UserService userService, DrawService drawService){
        this.userService = userService;
        this.drawService = drawService;
    }

    @PostMapping(value = "/login")
    public boolean login(@RequestBody LoginParam loginParam){
        System.out.println(loginParam.getId()+loginParam.getPw());
        return true;
    }

    @PostMapping(value = "/signup")
    public Long save(@RequestBody Member member){
        userService.join(member);
        return member.getMemberId();
    }

    @GetMapping(value = "/checkid/{id}")
    public boolean findById(@PathVariable("id") String id){
        return userService.checkId(id);
    }

    @GetMapping(value = "/checknickname/{nickname}")
    public boolean findByNickName(@PathVariable("nickname") String id){
        return userService.checkNickName(id);
    }

    @PostMapping(value = "/sendsms")
    public ResponseEntity<Boolean> sendSmsAndSaveRedis(@RequestBody PhoneCertificationDto dto){
        if (userService.sendSmsAndSaveRedis(dto.getPhoneNumber().replace("-",""))){
            return ResponseEntity.ok(true);
        }else {
            return ResponseEntity.ok(false);
        }
    }

    @PostMapping(value = "/certification")
    public ResponseEntity<Boolean> certificationSmsMessage(@RequestBody PhoneCertificationDto dto){
        Boolean result = userService.certificationSmsMessage(dto);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/draws")
    public ResponseEntity<List<Draw>> getAllDraws(){
        List<Draw> allDraws = drawService.findAllDraws();
        return ResponseEntity.ok(allDraws);
    }
}
