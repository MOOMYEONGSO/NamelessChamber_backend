package org.example.moomyeongso.domain.auth.core;

public record CustomPrincipal(
        String subject,
        String role
) { }
