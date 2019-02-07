package org.study.spring5.aop.flow;

public class BusinessContext {

    private final long id;
    private final String username;
    private Role role;

    public enum Role {
        NOT_SET,
        NORMAL,
        ADMIN
    }

    public BusinessContext(long id, String username) {
        this.id = id;
        this.username = username;
        this.role = Role.NOT_SET;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
