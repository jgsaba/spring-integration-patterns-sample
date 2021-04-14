package br.saba.integration.patternsdemo.messageconstruction.requestreply;

import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@MessageEndpoint
public class HotelBookingService {

    @ServiceActivator(inputChannel = "hotelBookingChannel")
    public Message<Boolean> checkAvailability(Message<Integer> numberOfGuests){
        Integer guests = numberOfGuests.getPayload();
        log.info("[APPLICATION] verifying availability for {} guests", guests);
        return MessageBuilder.withPayload(true).build();
    }
}
