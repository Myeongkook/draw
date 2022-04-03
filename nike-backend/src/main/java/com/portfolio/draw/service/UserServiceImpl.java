package com.portfolio.draw.service;

import com.portfolio.draw.domain.Member;
import com.portfolio.draw.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserServiceImpl implements UserService{

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public Long join(Member member) {
        return userRepository.save(member);
    }

    @Override
    public boolean checkId(String id) {
        return userRepository.findById(id) != null;
    }
}
