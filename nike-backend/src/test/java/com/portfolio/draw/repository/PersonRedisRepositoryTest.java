package com.portfolio.draw.repository;

import com.portfolio.draw.domain.PhoneAuth;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonRedisRepositoryTest {
    @Autowired
    private PersonRedisRepository repo;

    @Test
    @DisplayName(value = "레디스 테스트")
    void test() {
        PhoneAuth phoneAuth = new PhoneAuth("01084898972", "123456");
        repo.save(phoneAuth);
        Optional<PhoneAuth> byId = repo.findById(phoneAuth.getId());
        byId.ifPresent(phoneAuth1 -> {
            Assertions.assertThat(phoneAuth1.getCertificationNumber()).isEqualTo("123456");
        });
        Assertions.assertThat(repo.count()).isOne();
    }
}