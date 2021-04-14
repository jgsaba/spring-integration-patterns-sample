package br.saba.integration.patternsdemo.messageconstruction.event;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EventListenerOne {

    @ServiceActivator(inputChannel = "eventChannel")
    public void receivedEvent(Message<Event> eventMessage){
        log.info("[APPLICATION] Listener 1 received event: {} with expTime: {}",
                eventMessage.getPayload(), new HeaderAccessor(eventMessage).getExpirationTime());
    }

    @ServiceActivator(inputChannel = "eventChannel")
    public void receivedEvent2(Message<Event> eventMessage){
        log.info("[APPLICATION] Listener 2 received event: {} with expTime: {}",
                eventMessage.getPayload(), new HeaderAccessor(eventMessage).getExpirationTime());
    }

    @Getter
    private static class HeaderAccessor{
        private Long expirationTime;

        public HeaderAccessor(Message<Event> recordMessage){
            MessageHeaders headers = recordMessage.getHeaders();
            expirationTime = (Long) headers.get("EXPIRATION_TIME");
        }
    }
}
