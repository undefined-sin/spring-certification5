package org.study.spring5.container.extension;

import org.springframework.beans.factory.FactoryBean;
import org.study.spring5.StudyBean;

import java.util.Base64;
import java.util.UUID;

public class CredentialsBeanFactory extends StudyBean implements FactoryBean<Credentials> {

    private String secret;

    public CredentialsBeanFactory(String secret) {
        this.secret = secret;
    }

    @Override
    public Credentials getObject() throws Exception {
        String id = UUID.randomUUID().toString();
        log("Creating new credentials with ID: %s", id);
        Credentials credentials = new Credentials(id);
        String password = Credentials.normalizeString(secret);
        credentials.setPassword(new String(Base64.getDecoder().decode(password)).toCharArray());
        return credentials;
    }

    @Override
    public Class<?> getObjectType() {
        return Credentials.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
