package com.portfolio.draw.repository;

import com.portfolio.draw.domain.Member;

public interface UserRepository {
    Long save(Member member);
    Member findById(String id);
    Member findByNickName(String nickname);
}
