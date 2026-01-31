package org.example.moomyeongso.domain.auth.dto.request;

import jakarta.validation.constraints.NotBlank;

public record LoginRequestDto(
        @NotBlank
        String email,
        @NotBlank
        String password
) {}
