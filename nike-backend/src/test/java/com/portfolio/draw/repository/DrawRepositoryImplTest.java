package com.portfolio.draw.repository;

import com.portfolio.draw.domain.Draw;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DrawRepositoryImplTest {

    @Autowired
    DrawRepository drawRepository;

    @Test
    @DisplayName(value = "모든 응모 정보가 리턴되어야 한다.")
    public void findAll(){
        List<Draw> draws = drawRepository.AllDraws();
        for (Draw draw : draws) {
            System.out.println("draw = " + draw.getProduct());
        }
    }

}