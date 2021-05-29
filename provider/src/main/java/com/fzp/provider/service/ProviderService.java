package com.fzp.provider.service;

public interface ProviderService {
    String sayHelloConsumer(String str);

    void setValue(String key, Object value, long time);

    String getValue(String key);
}
