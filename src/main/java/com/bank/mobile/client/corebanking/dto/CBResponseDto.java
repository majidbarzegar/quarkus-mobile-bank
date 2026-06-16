package com.bank.mobile.client.corebanking.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CBResponseDto<T> {
    private T response;
    private boolean success;
    private String text;
    private Integer code;

    public CBResponseDto(T response) {
        this.response = response;
        this.success = true;
    }

    public CBResponseDto(T response, String text) {
        this.response = response;
        this.success = true;
        this.text = text;
        this.code = 1;
    }

    public CBResponseDto(String text, Integer code) {
        this.success = false;
        this.text = text;
        this.code = code;
    }

    public CBResponseDto(String text, Integer code, boolean success) {
        this.success = success;
        this.text = text;
        this.code = code;
    }
}
