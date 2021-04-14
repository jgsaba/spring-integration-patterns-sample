package br.saba.integration.patternsdemo.messageconstruction.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommandApplicationRunner implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CommandApplicationRunner.class, args);
    }

    @Autowired
    RegistrationService registrationService;

    @Override
    public void run(String... args) throws Exception {
        registrationService.commit("001");
    }
}
