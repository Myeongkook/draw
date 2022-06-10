package com.portfolio.draw.service;

import com.portfolio.draw.domain.Draw;
import org.assertj.core.api.Assertions;
import org.json.JSONArray;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.InstanceOf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DrawServiceImplTest {

    @Autowired
    DrawService drawService;

    @Test
    @DisplayName(value = "DB 내 모든 draw가 반환되어야 한다.")
    public void List2JsonArray(){
        List<Draw> allDraws = drawService.findAllDraws();
        Assertions.assertThat(allDraws).isNotEmpty();
    }
}