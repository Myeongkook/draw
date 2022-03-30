package com.portfolio.draw.repository;

import com.portfolio.draw.domain.User;

public interface UserRepository {
    Long save(User user);
}
