package com.usermanagement.controller.base;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public abstract class ResponseMessages {

    private static String RESPONSE_MESSAGE_TITLE = "responseMessage";

    protected MultiValueMap<String, String> responseMesagge(String messageContent) {

        MultiValueMap<String, String> message = new LinkedMultiValueMap<>();
        message.set(RESPONSE_MESSAGE_TITLE, messageContent);

        return  message;
    }
}
