package com.portfolio.draw.domain;

import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;

@Getter
@RedisHash(value = "phone", timeToLive = 180)
public class PhoneAuth {

    @Id
    private String id;
    private String certificationNumber;

    public PhoneAuth(String id, String certificationNumber) {
        this.id = id;
        this.certificationNumber = certificationNumber;
    }
}
