package br.saba.integration.patternsdemo.messageconstruction.command;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

@MessagingGateway(name = "swagGateway", defaultRequestChannel = "swagChannel")
public interface SwagGateway {

    @Gateway
    void sendSwag(Message<String> messageText);
}
