package com.portfolio.draw.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MessageGenerator {

    public String generateValue(){
        StringBuilder certificationNumber = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i<6;i++){
            certificationNumber.append(random.nextInt(10));
        }
        return certificationNumber.toString();
    }
}
