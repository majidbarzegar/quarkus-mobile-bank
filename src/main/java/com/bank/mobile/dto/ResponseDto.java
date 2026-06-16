package com.bank.mobile.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto<T> {
    private T response;
    private boolean success;
    private String text;
    private Integer code;

    public ResponseDto(T response) {
        this.response = response;
        this.success = true;
    }

    public ResponseDto(T response, String text) {
        this.response = response;
        this.success = true;
        this.text = text;
        this.code = 1;
    }

    public ResponseDto(String text, Integer code) {
        this.success = false;
        this.text = text;
        this.code = code;
    }

    public ResponseDto(String text, Integer code, boolean success) {
        this.success = success;
        this.text = text;
        this.code = code;
    }
}
