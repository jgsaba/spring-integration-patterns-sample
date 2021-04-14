package br.saba.integration.patternsdemo.messageconstruction.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class ReservationRecord {
    private String name;
    private LocalDate date;
}
