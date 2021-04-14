package br.saba.integration.patternsdemo.messageconstruction.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RegistrationService {

    @Autowired
    private EventGateway eventGateway;

    public void notifyObservers(Event event){
        Message<Event> message = MessageBuilder
                .withPayload(event)
                .setHeader("EXPIRATION_TIME", System.currentTimeMillis() + 60 * 60 * 1000)
                .build();

        eventGateway.publishEvent(message);
    }
}
