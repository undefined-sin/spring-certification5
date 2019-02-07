package org.study.spring5.aop.audit;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.core.annotation.AnnotationUtils;
import org.study.spring5.aop.annotation.Audited;
import org.study.spring5.aop.flow.BusinessContext;
import org.study.spring5.aop.flow.DefaultBusinessRequest;
import org.study.spring5.aop.flow.DefaultBusinessResponse;
import org.study.spring5.aop.message.Messages;
import org.study.spring5.aop.message.SystemMessage;

import java.lang.reflect.Method;

public class AuditLogInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method m = invocation.getMethod();
        Class<?> clazz = invocation.getMethod().getDeclaringClass();
        Audited audited = AnnotationUtils.findAnnotation(clazz, Audited.class);
        if (audited == null) {
            audited = AnnotationUtils.findAnnotation(m, Audited.class);
        }
        if (audited != null) {
            StringBuilder str = new StringBuilder();
            str.append("[Audit]");
            str.append(System.currentTimeMillis());
            str.append("|");
            if (invocation.getArguments().length > 0) {
                Object argument = invocation.getArguments()[0];
                if (argument instanceof DefaultBusinessRequest) {
                    DefaultBusinessRequest msg = (DefaultBusinessRequest) argument;
                    BusinessContext ctx = msg.getContext();
                    str.append(ctx.getId());
                    str.append("|");
                    str.append(ctx.getUsername());
                    str.append("|");
                    str.append(ctx.getRole());
                    str.append("|");
                    str.append(msg.getPayload());
                }
                str.append("|");
                str.append(clazz.getSimpleName() + "." + m.getName());
                str.append("|");
                if (!audited.key().isEmpty()) {
                    str.append(audited.key());
                }
            }
            str.append("|");
            Object proceed = invocation.proceed();
            if (proceed instanceof SystemMessage) {
                DefaultBusinessResponse msg = (DefaultBusinessResponse) proceed;
                str.append(msg.getPayload());
                Messages messages = msg.getMessages();
                if (messages.hasMessages()) {
                    str.append("|");
                    str.append(messages.getHighestPriority());
                }
            }
            str.append("|");
            System.out.println(str);
        }
        return invocation.proceed();
    }
}
