package com.portfolio.draw.service;

import com.portfolio.draw.domain.Member;
import com.portfolio.draw.domain.PhoneAuth;
import com.portfolio.draw.dto.PhoneCertificationDto;
import com.portfolio.draw.repository.PersonRedisRepository;
import com.portfolio.draw.repository.UserRepository;
import com.portfolio.draw.util.MessageGenerator;
import com.portfolio.draw.util.SmsUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    UserRepository userRepository;
    SmsUtil smsUtil;
    PersonRedisRepository personRedisRepository;
    MessageGenerator messageGenerator;

    public UserServiceImpl(UserRepository userRepository, SmsUtil smsUtil, PersonRedisRepository personRedisRepository, MessageGenerator messageGenerator){
        this.userRepository = userRepository;
        this.smsUtil = smsUtil;
        this.personRedisRepository = personRedisRepository;
        this.messageGenerator = messageGenerator;
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

    public Boolean sendSmsAndSaveRedis(String phone) {
        String certificationNumber = messageGenerator.generateValue();
        smsUtil.sendSMS(new ArrayList<>(List.of(phone)),"The Draw 인증번호 \n[ "+ certificationNumber +" ]");
        personRedisRepository.save(new PhoneAuth(phone, certificationNumber));
        return true;
    }

    @Override
    public Boolean certificationSmsMessage(PhoneCertificationDto dto) {
        personRedisRepository.findById(dto.getPhoneNumber());
        return null;
    }


}
