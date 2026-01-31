package org.example.moomyeongso.admin.user.dto.request;

import jakarta.validation.constraints.NotNull;
import org.example.moomyeongso.domain.user.entity.UserStatus;

public record AdminUserRequestDto(
        @NotNull
        UserStatus status
) {
}