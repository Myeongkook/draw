package com.portfolio.draw.repository;

import com.portfolio.draw.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class UserRepositoryImpl implements UserRepository{

    @PersistenceContext
    EntityManager em;

    @Override
    public Long save(Member member) {
        em.persist(member);
        return member.getMemberId();
    }

    @Override
    public Member findById(String id) {
        try {
            return em.createQuery("select u from Member as u where u.id =:name", Member.class)
                    .setParameter("name", id)
                    .getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public Member findByNickName(String nickname) {
        try {
            return em.createQuery("select m from Member as m where m.name =:nickname", Member.class)
                    .setParameter("nickname", nickname)
                    .getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public Member findByPhone(String phoneNumber) {
        try{
            return em.createQuery("select m from Member as m where m.phone =:phone", Member.class)
                    .setParameter("phone", phoneNumber)
                    .getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }
}
