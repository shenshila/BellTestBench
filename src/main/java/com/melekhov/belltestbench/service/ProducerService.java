package com.melekhov.belltestbench.service;

public interface ProducerService {
    public void sendMessage(String msgId, String method, String uri);
}
