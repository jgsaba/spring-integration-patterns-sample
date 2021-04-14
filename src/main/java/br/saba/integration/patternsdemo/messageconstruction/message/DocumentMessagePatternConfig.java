package br.saba.integration.patternsdemo.messageconstruction.message;

import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.MessageChannel;

@Configuration
@EnableIntegration
public class DocumentMessagePatternConfig {

    public MessageChannel reservationRecordChannel(){
        return new DirectChannel();
    }
}
