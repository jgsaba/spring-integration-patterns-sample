package br.saba.integration.patternsdemo.messageconstruction.message;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@MessageEndpoint
public class ReservationService {

    @ServiceActivator(inputChannel = "reservationRecordChannel")
    public void addRecord(Message<ReservationRecord> recordMessage){
        HeaderAccessor accessor = new HeaderAccessor(recordMessage);
        log.info("Sequence: {} / {}", accessor.getSequenceNumber(), accessor.getSequenceSize());
        log.info("Reservation record: {}", recordMessage.getPayload());
    }

    @Getter
    private static class HeaderAccessor{
        private Integer sequenceNumber;
        private Integer sequenceSize;

        public HeaderAccessor(Message<ReservationRecord> recordMessage){
            MessageHeaders headers = recordMessage.getHeaders();
            sequenceNumber = (Integer) headers.get("SEQUENCE_NUMBER");
            sequenceSize = (Integer) headers.get("SEQUENCE_SIZE");
        }

    }
}
