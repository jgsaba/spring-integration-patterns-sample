package br.saba.integration.patternsdemo.messageconstruction.requestreply;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class RequestReplyApplicationRunner implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RequestReplyApplicationRunner.class);
    }

    @Autowired
    RegistrationService registrationService;

    @Override
    public void run(String... args) throws Exception {
        Boolean availability = registrationService.checkAvailability(4);
        log.info("[APPLICATION] the response was {}", availability);
    }
}
