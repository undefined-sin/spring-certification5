package org.study.spring5.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.study.spring5.StudyApp;
import org.study.spring5.aop.flow.BusinessContext;
import org.study.spring5.aop.flow.BusinessResponse;
import org.study.spring5.aop.flow.DefaultBusinessRequest;
import org.study.spring5.aop.service.LoginService;

@ComponentScan
@Configuration
@EnableAspectJAutoProxy
public class AspectJSupportApp extends StudyApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ProxyBasedExample.class);
        LoginService loginService = ctx.getBean(LoginService.class);

        BusinessContext businessCtx = new BusinessContext(1L, "ADMIN");
        businessCtx.setRole(BusinessContext.Role.NORMAL);

        BusinessResponse<Integer> response = loginService.convertUserToID(DefaultBusinessRequest.of(businessCtx, "This is payload"));

        ctx.close();

    }
}
