package org.study.spring5.aop.cache;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.study.spring5.StudyBean;
import org.study.spring5.aop.flow.BusinessRequest;

@Aspect
@Component
public class ConvertUserIDCacheAspect extends StudyBean {


    @Before("within(org.study..*)")
    public void createLog() {
        log("Call in org.study");
    }

    @Before("execution(* org.study.spring5.aop.service.LoginService.*(..))")
    public void cacheResponse(JoinPoint point) {
        BusinessRequest<?> request = (BusinessRequest) point.getArgs()[0];
        log("Caching result: %s", request.getPayload());
    }
}
