package com.portfolio.draw.service;

import com.portfolio.draw.domain.Member;
import com.portfolio.draw.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserService userService;

    @Test
    @DisplayName(value = "존재하는 아이디를 조회하면 객체를 불러와야한다.")
    void checkId() {
        Member admin = userRepository.findById("admin");
        Assertions.assertThat(admin.getId()).isEqualTo("admin");
    }
    @Test
    @DisplayName(value = "존재하지 않는 아이디를 조회하면 null을 반환한다.")
    void checkIdFail() {
        Member findCheckTester = userRepository.findById("findCheckTester");
        Assertions.assertThat(findCheckTester).isNull();
    }

    @Test
    @DisplayName(value = "패스워드가 평문으로 노출되면 안된다")
    void passwordEncoding(){
        String password = "123456";
        String encode = passwordEncoder.encode(password);
        Assertions.assertThat(passwordEncoder.matches(password, encode)).isTrue();
    }


    @Test
    @DisplayName(value = "등록된 핸드폰번호로 인증번호를 요청하면 False를 반환하고 저장되지 않는다.")
    void sendSmsAndSaveRedis(){
        Boolean aBoolean = userService.sendSmsAndSaveRedis("01084898972");
        Assertions.assertThat(aBoolean).isFalse();
    }

    @Test
    @DisplayName(value = "등록되지않은 핸드폰번호로 인증번호를 요청하면 문자가 발송된다")
    void sendSmsAndSaveRedis2(){
        Boolean aBoolean = userService.sendSmsAndSaveRedis("01084898972");
        Assertions.assertThat(aBoolean).isTrue();
    }
}