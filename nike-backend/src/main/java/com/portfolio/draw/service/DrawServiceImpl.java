package com.portfolio.draw.service;


import com.portfolio.draw.repository.DrawRepository;
import org.json.JSONArray;
import org.springframework.stereotype.Service;

@Service
public class DrawServiceImpl implements DrawService{

    DrawRepository drawRepository;

    public DrawServiceImpl(DrawRepository drawRepository){
        this.drawRepository = drawRepository;
    }

    @Override
    public JSONArray findAllDraws() {
        return new JSONArray(drawRepository.AllDraws());
    }
}
