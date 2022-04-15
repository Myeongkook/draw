package com.portfolio.draw.service;

import com.portfolio.draw.domain.Member;
import com.portfolio.draw.dto.PhoneCertificationDto;

public interface UserService {
    Long join(Member member);
    boolean checkId(String id);
    boolean checkNickName(String nickname);
    Boolean sendSmsAndSaveRedis(String phone);
    Boolean certificationSmsMessage(PhoneCertificationDto dto);
}
