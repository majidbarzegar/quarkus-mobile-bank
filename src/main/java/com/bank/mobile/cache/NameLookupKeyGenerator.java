package com.bank.mobile.cache;

import io.quarkus.cache.CacheKeyGenerator;
import jakarta.enterprise.context.ApplicationScoped;

import java.lang.reflect.Method;

@ApplicationScoped
public class NameLookupKeyGenerator implements CacheKeyGenerator {

    private static final String PREFIX = "CACHE_ACCUNT_NUMBER_NAME_LOOKUP:";

    @Override
    public Object generate(Method method, Object... methodArgs) {
        String accountNumber = (String) methodArgs[0];
        return PREFIX + accountNumber;
    }
}