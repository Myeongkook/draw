package com.portfolio.draw.service;

import com.portfolio.draw.domain.Member;
import com.portfolio.draw.dto.PhoneCertificationDto;

public interface UserService {
    Long join(Member member);
    boolean checkId(String id);
    Boolean sendSmsAndSaveRedis(String phone);
    Boolean certificationSmsMessage(PhoneCertificationDto dto);
}
