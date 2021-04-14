package br.saba.integration.patternsdemo.messageconstruction.event;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.MessageChannel;

@Configuration
@EnableIntegration
public class EventMessagePatternConfig {

    @Bean
    public MessageChannel eventChannel(){
        return new PublishSubscribeChannel();
    }
}
