package br.saba.integration.patternsdemo.messageconstruction.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class DocumentApplicationRunner implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DocumentApplicationRunner.class);
    }

    @Autowired
    private RegistrationService registrationService;

    @Override
    public void run(String... args) throws Exception {
        registrationService.updateReservationRecord(new ReservationRecord("Person A", LocalDate.now()));
    }
}
