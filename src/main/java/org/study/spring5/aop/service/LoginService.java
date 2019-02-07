package org.study.spring5.aop.service;


import org.springframework.stereotype.Service;
import org.study.spring5.aop.annotation.Audited;
import org.study.spring5.aop.domain.User;
import org.study.spring5.aop.flow.BusinessRequest;
import org.study.spring5.aop.flow.BusinessResponse;

@Service
public interface LoginService {
    @Audited(description = "Critical part that requires audit.", key = "load_user")
    BusinessResponse<User> getUser(BusinessRequest<String> request);
}
