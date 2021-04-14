package br.saba.integration.patternsdemo.messageconstruction.event;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

@MessagingGateway(name = "eventGateway", defaultRequestChannel = "eventChannel")
public interface EventGateway {

    void publishEvent(Message<Event> message);
}
