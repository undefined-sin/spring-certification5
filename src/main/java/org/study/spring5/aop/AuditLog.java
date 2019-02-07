package org.study.spring5.aop;

public final class AuditLog {

    private static AuditLog INSTANCE;

    static {
        INSTANCE = new AuditLog();
    }

    private AuditLog() {
    }

    public AuditLog getLogger() {
        return this.INSTANCE;
    }

    public void audit(String message, Object... args) {
        System.out.println(String.format(message, args));
    }
}
