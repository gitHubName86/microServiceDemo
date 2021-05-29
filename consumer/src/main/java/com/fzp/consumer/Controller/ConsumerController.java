package com.fzp.consumer.Controller;

import com.fzp.common.constants.Constants;
import com.fzp.provider.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@ImportResource(value = "consumer.xml")
@RestController
public class ConsumerController {

    @Autowired
    private ProviderService providerService;

    @GetMapping("/hello")
    public void sayHello(){
        String str = providerService.sayHelloConsumer("No Hello, just hi. ");
        System.out.println("consumer get str = " + str + " from Provider");
    }

    @GetMapping("/setValue")
    public String setValue(String key, String value) {
        // 设置 key 有效时间为 10s ,便于测试
        providerService.setValue(key, value, Constants.CACHE_EXP_TEN_SECONDS);
        return "key : " + key + " value : " + value;
    }

    @GetMapping("/getValue")
    public String getValue(String key){
        return providerService.getValue(key);
    }
}
