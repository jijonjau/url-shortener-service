package com.jijo.url_shortener.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Table
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UrlShortener {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String originalUrl;

    @Column(nullable = false, unique = true)
    private String shortenedUrl;

    @CreatedDate
    private LocalDateTime createdDate;
}
