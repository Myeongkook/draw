package com.portfolio.draw.service;

import com.portfolio.draw.domain.Member;
import com.portfolio.draw.repository.PersonRedisRepository;
import com.portfolio.draw.repository.UserRepository;
import com.portfolio.draw.util.MessageGenerator;
import com.portfolio.draw.util.SmsUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    UserRepository userRepository;
    SmsUtil smsUtil;
    PersonRedisRepository personRedisRepository;

    public UserServiceImpl(UserRepository userRepository, SmsUtil smsUtil, PersonRedisRepository personRedisRepository){
        this.userRepository = userRepository;
        this.smsUtil = smsUtil;
        this.personRedisRepository = personRedisRepository;
    }

    @Override
    public Long join(Member member) {
        member.setPhone(member.getPhone().replace("-", ""));
        return userRepository.save(member);
    }

    @Override
    public boolean checkId(String id) {
        return userRepository.findById(id) != null;
    }

    @Override
    public String smsCertification(String phone) {
        List<String> user = new ArrayList<>();
        user.add(phone);
        smsUtil.sendSMS(user, "492832");
        return "hello";
    }
}
