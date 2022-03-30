package com.portfolio.draw.repository;

import com.portfolio.draw.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository{

    @PersistenceContext
    EntityManager em;

    @Override
    public Long save(User user) {
        em.persist(user);
        return user.getUserId();
    }
}
