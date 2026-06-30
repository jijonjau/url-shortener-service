package com.jijo.url_shortener.application.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UrlShortenerRequest {
    @NotBlank(message = "Url is required")
    private String originalUrl;
}
