package com.portfolio.draw.service;

import com.portfolio.draw.domain.Member;
import com.portfolio.draw.domain.PhoneAuth;
import com.portfolio.draw.dto.PhoneCertificationDto;
import com.portfolio.draw.repository.PersonRedisRepository;
import com.portfolio.draw.repository.UserRepository;
import com.portfolio.draw.util.MessageGenerator;
import com.portfolio.draw.util.SmsUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
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
    PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, SmsUtil smsUtil, PersonRedisRepository personRedisRepository, MessageGenerator messageGenerator, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.smsUtil = smsUtil;
        this.personRedisRepository = personRedisRepository;
        this.messageGenerator = messageGenerator;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public Long join(Member member) {
        member.setPhone(member.getPhone().replace("-", ""));
        member.setPw(passwordEncoder.encode(member.getPw()));
        return userRepository.save(member);

    }

    @Override
    public boolean checkId(String id) {
        return userRepository.findById(id) != null;
    }

    @Override
    public boolean checkNickName(String nickname) {
        return userRepository.findByNickName(nickname) != null;
    }

    @Override
    public Boolean sendSmsAndSaveRedis(String phone) {
        if(userRepository.findByPhone(phone) == null){
            String certificationNumber = messageGenerator.generateValue();
            smsUtil.sendSMS(new ArrayList<>(List.of(phone)),"The Draw 인증번호 \n[ "+ certificationNumber +" ]");
            personRedisRepository.save(new PhoneAuth(phone, certificationNumber));
            return true;
        }
        return false;
    }

    @Override
    public Boolean certificationSmsMessage(PhoneCertificationDto dto) {
        Optional<PhoneAuth> byId = personRedisRepository.findById(dto.getPhoneNumber());
        if(byId.isPresent()){
            PhoneAuth phoneAuth = byId.get();
            return phoneAuth.getCertificationNumber().equals(dto.getCertificationNumber());
        }
        return false;
    }


}
