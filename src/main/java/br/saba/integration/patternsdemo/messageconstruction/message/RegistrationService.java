package br.saba.integration.patternsdemo.messageconstruction.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private ReservationRecordGateway reservationRecordGateway;

    public void updateReservationRecord(ReservationRecord record){
        Message<ReservationRecord> message = MessageBuilder.withPayload(record)
                .setHeader("SEQUENCE_NUMBER", 1)
                .setHeader("SEQUENCE_SIZE", 5)
                .build();

        reservationRecordGateway.addRecord(message);
    }
}
