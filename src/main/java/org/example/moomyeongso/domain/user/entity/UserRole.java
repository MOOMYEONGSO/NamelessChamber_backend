package org.example.moomyeongso.domain.user.entity;

public enum UserRole {
    USER,
    ANONYMOUS,
    ADMIN;

    public boolean isUser() {
        return this == USER;
    }
}
