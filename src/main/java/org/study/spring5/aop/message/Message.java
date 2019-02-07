package org.study.spring5.aop.message;

public class Message {

    enum Severity {
        DEFAULT,
        INFO,
        ERROR,
        VALIDATION
    }

    private String code;
    private String path;
    private Severity severity = Severity.DEFAULT;

    public Message(String code, String path) {
        this.code = code;
        this.path = path;
    }

    public String getCode() {
        return code;
    }

    public String getPath() {
        return path;
    }

    public Severity getSeverity() {
        return severity;
    }
}
