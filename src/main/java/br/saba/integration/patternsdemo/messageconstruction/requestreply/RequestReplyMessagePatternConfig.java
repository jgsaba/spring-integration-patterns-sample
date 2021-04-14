package br.saba.integration.patternsdemo.messageconstruction.requestreply;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.MessageChannel;

@Configuration
@EnableIntegration
public class RequestReplyMessagePatternConfig {

    @Bean
    public MessageChannel hotelBookingChannel(){
        return new DirectChannel();
    }
}
