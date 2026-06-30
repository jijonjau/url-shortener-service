package com.jijo.url_shortener.application.services;

import com.jijo.url_shortener.application.dto.UrlShortenerRequest;
import com.jijo.url_shortener.application.dto.UrlShortenerResponse;
import com.jijo.url_shortener.common.api.Response;
import com.jijo.url_shortener.domain.entity.UrlShortener;
import com.jijo.url_shortener.domain.repository.UrlShortenerRepo;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class UrlShortenerService {

    private final UrlShortenerRepo urlShortenerRepo;

    @Value("${app.base-url}")
    private String baseUrl;

    public Response<UrlShortenerResponse> urlShortener(UrlShortenerRequest request) {

        String url = request.getOriginalUrl();

        // 1. Validate URL
        try {
            new URI(url);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid URL");
        }

        // 2. Generate unique short code
        String shortUrl = RandomStringUtils.secure().nextAlphanumeric(6);
        while (urlShortenerRepo.findByShortenedUrl(shortUrl).isPresent()) {
            shortUrl = RandomStringUtils.secure().nextAlphanumeric(6);
        }

        // 3. Save
        UrlShortener entity = UrlShortener.builder()
                .originalUrl(url)
                .shortenedUrl(shortUrl)
                .build();

        urlShortenerRepo.save(entity);

        // 4. Response
        String fullShortUrl = baseUrl + "/" + shortUrl;
        UrlShortenerResponse response = UrlShortenerResponse.builder()
                .shortenedUrl(fullShortUrl)
                .build();

        return Response.success(
                HttpStatus.CREATED.value(),
                "success",
                response
        );
    }
}
