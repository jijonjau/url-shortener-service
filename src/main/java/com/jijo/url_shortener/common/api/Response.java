package com.jijo.url_shortener.common.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {

    private LocalDateTime responseDateTime;
    private int status;
    private String statusDesc;
    private T payload;

    public static <T> Response<T> success(int status, String statusDesc, T payload) {
        return Response.<T>builder()
                .responseDateTime(LocalDateTime.now())
                .status(status)
                .statusDesc(statusDesc)
                .payload(payload)
                .build();
    }

    public static <T> Response<T> error(int status, String statusDesc) {
        return Response.<T>builder()
                .responseDateTime(LocalDateTime.now())
                .status(status)
                .statusDesc(statusDesc)
                .build();
    }
}