package com.portfolio.draw.service;

import com.portfolio.draw.domain.Member;
import com.portfolio.draw.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    UserRepository userRepository;

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


}