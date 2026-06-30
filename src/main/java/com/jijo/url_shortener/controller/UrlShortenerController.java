package com.jijo.url_shortener.controller;

import com.jijo.url_shortener.application.dto.UrlShortenerRequest;
import com.jijo.url_shortener.application.dto.UrlShortenerResponse;
import com.jijo.url_shortener.application.services.UrlShortenerService;
import com.jijo.url_shortener.common.api.Response;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/url-shortener")
@RequiredArgsConstructor
public class UrlShortenerController {

    private final UrlShortenerService urlShortenerService;

    @PostMapping
    public Response<UrlShortenerResponse> createUrlShortener(
            @Valid @RequestBody UrlShortenerRequest request) {

        return urlShortenerService.urlShortener(request);
    }
}
