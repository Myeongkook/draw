package com.portfolio.draw.service;

import com.portfolio.draw.domain.User;
import com.portfolio.draw.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public Long join(User user) {
        return userRepository.save(user);
    }
}
