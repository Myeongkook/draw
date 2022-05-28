package com.portfolio.draw.service;

import com.portfolio.draw.domain.Draw;
import org.json.JSONArray;

import java.util.List;

public interface DrawService {
    List<Draw> findAllDraws();
}
