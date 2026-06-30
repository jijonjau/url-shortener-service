package com.jijo.url_shortener.domain.repository;

import com.jijo.url_shortener.domain.entity.UrlShortener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlShortenerRepo extends JpaRepository<UrlShortener, Long> {
    Optional<UrlShortener> findByShortenedUrl(String shortenedUrl);
}
