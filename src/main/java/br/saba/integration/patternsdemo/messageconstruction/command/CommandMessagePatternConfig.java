package br.saba.integration.patternsdemo.messageconstruction.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.MessageChannel;

@Configuration
@EnableIntegration
public class CommandMessagePatternConfig {

    @Bean
    public MessageChannel swagChannel(){
        return new DirectChannel();
    }

    @Autowired
    private RegistrationService service;
}
