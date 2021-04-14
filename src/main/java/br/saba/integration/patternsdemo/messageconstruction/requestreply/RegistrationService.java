package br.saba.integration.patternsdemo.messageconstruction.requestreply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private HotelBookingGateway hotelBookingGateway;

    public Boolean checkAvailability(Integer numberOfGuests){
        Message<Integer> message = MessageBuilder.withPayload(numberOfGuests).build();
        Message<Boolean> response = hotelBookingGateway.checkAvailability(message);

        return response.getPayload();
    }
}
