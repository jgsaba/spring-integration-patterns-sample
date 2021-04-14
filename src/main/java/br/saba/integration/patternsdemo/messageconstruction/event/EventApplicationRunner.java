package br.saba.integration.patternsdemo.messageconstruction.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventApplicationRunner implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EventApplicationRunner.class);
    }

    @Autowired
    RegistrationService registrationService;

    @Override
    public void run(String... args) throws Exception {
        registrationService.notifyObservers(new Event(1L, "EventType-1"));
    }
}
