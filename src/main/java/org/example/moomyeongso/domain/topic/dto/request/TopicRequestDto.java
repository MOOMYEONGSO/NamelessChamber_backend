package org.example.moomyeongso.domain.topic.dto.request;

import jakarta.validation.constraints.NotBlank;

public record TopicRequestDto(
        @NotBlank
        String title,
        @NotBlank
        String subtitle
) {}