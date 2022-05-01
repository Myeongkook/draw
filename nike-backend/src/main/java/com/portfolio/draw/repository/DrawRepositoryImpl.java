package com.portfolio.draw.repository;


import com.portfolio.draw.domain.Draw;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class DrawRepositoryImpl implements DrawRepository{

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Draw> AllDraws() {
        return em.createQuery("select d from Draw as d",Draw.class)
                .getResultList();
    }
}
