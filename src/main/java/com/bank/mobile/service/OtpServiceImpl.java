package com.bank.mobile.service;

import com.bank.mobile.exception.BusinessException;
import io.quarkus.redis.datasource.RedisDataSource;
import io.quarkus.redis.datasource.value.ValueCommands;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.Duration;
import java.util.Random;

import static com.bank.mobile.exception.Message.*;

@ApplicationScoped
public class OtpServiceImpl implements OtpService{

    private final ValueCommands<String, String> otpCommands;
    private static final String PREFIX = "CACHE_OTP:";

    @Inject
    public OtpServiceImpl(RedisDataSource redisDataSource) {
        this.otpCommands = redisDataSource.value(String.class, String.class);
    }

    @Override
    public void sendOtp(String currentUserNationalCode) {
        String randomOtp = String.format("%05d", new Random().nextInt(100000));
        String redisKey = PREFIX + currentUserNationalCode;
        otpCommands.setex(redisKey, Duration.ofMinutes(2).toSeconds(), randomOtp);
        System.out.println("Sending OTP " + randomOtp + " to national code " + currentUserNationalCode);
    }

    @Override
    public void checkOtp(String currentUserNationalCode, String otp) {
        String redisKey = PREFIX + currentUserNationalCode;
        String cachedOtp = otpCommands.get(redisKey);
        if (cachedOtp == null) {
            throw new BusinessException(OTP_EXPIRED_OR_NOT_FOUND);
        }
        if (!cachedOtp.equals(otp)) {
            throw new BusinessException(INVALID_OTP);
        }
//        otpCommands.getdel(redisKey);
    }
}
