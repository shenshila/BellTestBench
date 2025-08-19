package com.melekhov.belltestbench.service;

public interface KafkaMessageService {
    public void sendMessage(String msgId, String method, String uri);
}
