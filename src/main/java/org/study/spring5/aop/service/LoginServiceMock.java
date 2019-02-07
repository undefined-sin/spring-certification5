package org.study.spring5.aop.service;

import org.springframework.stereotype.Service;
import org.study.spring5.aop.domain.User;
import org.study.spring5.aop.flow.BusinessRequest;
import org.study.spring5.aop.flow.BusinessResponse;
import org.study.spring5.aop.flow.DefaultBusinessResponse;
import org.study.spring5.aop.message.Message;


@Service
public class LoginServiceMock implements LoginService {


    @Override
    public BusinessResponse<User> getUser(BusinessRequest<String> request) {
        User user = new User(1L, "Michael Jackson");
        return DefaultBusinessResponse.of(user);
    }

    @Override
    public BusinessResponse<String> deleteUser(BusinessRequest<Integer> request) {
        String id = String.valueOf(request.getPayload());
        DefaultBusinessResponse response = DefaultBusinessResponse.of(id);
        Message message = new Message("error", "default");
        message.setSeverity(Message.Severity.ERROR);
        response.addMessage(message);
        return response;
    }

    @Override
    public BusinessResponse<Void> logWarning(BusinessRequest<String> request) {
        System.out.println("Warning...");
        return DefaultBusinessResponse.of(Void.TYPE);
    }
}
