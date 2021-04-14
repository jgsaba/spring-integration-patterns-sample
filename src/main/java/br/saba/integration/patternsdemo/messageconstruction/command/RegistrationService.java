package br.saba.integration.patternsdemo.messageconstruction.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private SwagGateway swagGateway;

    public void commit(String userId){
        Message<String> message = MessageBuilder
                .withPayload("Greetings from Brazil!")
                .setHeader("USERID", userId)
                .build();

        swagGateway.sendSwag(message);
    }
}
