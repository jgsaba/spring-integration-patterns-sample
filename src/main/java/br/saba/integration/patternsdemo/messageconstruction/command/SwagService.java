package br.saba.integration.patternsdemo.messageconstruction.command;

import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@MessageEndpoint
public class SwagService {

    @ServiceActivator(inputChannel = "swagChannel")
    public void sendSwag(Message<String> messageText){
        log.info("1 Receiving following message: {}. From {}", messageText.getPayload(), messageText.getHeaders().get("USERID"));
    }

    @ServiceActivator(inputChannel = "swagChannel")
    public void sendSwag2(Message<String> messageText){
        log.info("2 Receiving following message: {}. From {}", messageText.getPayload(), messageText.getHeaders().get("USERID"));
    }
}
