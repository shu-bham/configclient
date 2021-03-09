package com.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RefreshScope
@RestController
class MessageController {

    @Value("${message:default message, client server not invoked}")
    private String message;

    @Value("${vaultMessage:default vault message, client server not invoked}")
    private String vaultMessage;

    @GetMapping("/message")
    public String getMessage() {

        Map<String, String> stringMap = Map.of(
                "message", this.message,
                "vaultMessage", this.vaultMessage);
        return stringMap.toString();
    }
}