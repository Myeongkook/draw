package com.portfolio.draw.service;


import com.portfolio.draw.domain.Draw;
import com.portfolio.draw.repository.DrawRepository;
import org.json.JSONArray;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrawServiceImpl implements DrawService{

    DrawRepository drawRepository;

    public DrawServiceImpl(DrawRepository drawRepository){
        this.drawRepository = drawRepository;
    }


    @Override
    public List<Draw> findAllDraws() {
        return drawRepository.AllDraws();
    }
}
