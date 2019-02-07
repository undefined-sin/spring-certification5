package org.study.spring5.aop.service;

import org.springframework.stereotype.Service;
import org.study.spring5.aop.domain.User;
import org.study.spring5.aop.flow.BusinessRequest;
import org.study.spring5.aop.flow.BusinessResponse;
import org.study.spring5.aop.flow.DefaultBusinessResponse;

@Service
public class LoginServiceMock implements LoginService {


    @Override
    public BusinessResponse<User> getUser(BusinessRequest<String> request) {
        User user = new User(1L, "Michael Jackson");
        BusinessResponse response = new DefaultBusinessResponse(user);
        return response;
    }
}
