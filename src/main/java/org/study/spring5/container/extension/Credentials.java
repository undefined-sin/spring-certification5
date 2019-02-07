package org.study.spring5.container.extension;

public class Credentials {
    private String instanceID;
    private String secret;
    private char[] password;

    public Credentials() {
    }

    public Credentials(String instanceID) {
        this.instanceID = instanceID;
    }

    public String getInstanceID() {
        return instanceID;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public static String normalizeString(String key) {
        key = key.replace("ENCRYPTED[", "");
        key = key.replace("]", "");
        return key;
    }
}
