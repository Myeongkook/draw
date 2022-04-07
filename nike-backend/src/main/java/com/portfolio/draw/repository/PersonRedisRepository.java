package com.portfolio.draw.repository;

import com.portfolio.draw.domain.PhoneAuth;
import org.springframework.data.repository.CrudRepository;

public interface PersonRedisRepository extends CrudRepository<PhoneAuth, String> {
}
