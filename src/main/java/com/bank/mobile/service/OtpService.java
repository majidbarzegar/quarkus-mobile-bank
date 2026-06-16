package com.bank.mobile.service;

public interface OtpService {
    void sendOtp(String currentUserNationalCode);

    void checkOtp(String currentUserNationalCode, String otp);
}
