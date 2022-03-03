package com.portfolio.draw.controller;

import com.portfolio.draw.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

    @ResponseBody
    @GetMapping("member")
    public Member getMember(){
        Member member = new Member();
        member.setName("test");
        member.setId(1L);
        return member;
    }
}
