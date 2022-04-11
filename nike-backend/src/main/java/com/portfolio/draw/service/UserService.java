package com.portfolio.draw.service;

import com.portfolio.draw.domain.Member;

public interface UserService {
    Long join(Member member);
    boolean checkId(String id);
    String smsCertification(String phone);
}
