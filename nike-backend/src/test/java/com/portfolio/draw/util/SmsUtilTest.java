package com.portfolio.draw.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SmsUtilTest {

    @Autowired
    SmsUtil smsUtil;

    @Test
    @DisplayName(value = "문자가 정상 발송되는지")
    void sendSMS(){
        List<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add("01084898972");
        smsUtil.sendSMS(phoneNumbers, "문자 테스트입니다.");
    }

}