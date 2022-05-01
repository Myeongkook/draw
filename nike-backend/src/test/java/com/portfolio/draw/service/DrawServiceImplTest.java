package com.portfolio.draw.service;

import org.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.InstanceOf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DrawServiceImplTest {

    @Autowired
    DrawService drawService;

    @Test
    @DisplayName(value = "List가 Json형태로 반한되어야 한다.")
    public void List2JsonArray(){
        JSONArray allDraws = drawService.findAllDraws();
        org.assertj.core.api.Assertions.assertThat(allDraws).isInstanceOf(JSONArray.class).isNotEmpty();

    }
}