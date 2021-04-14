package br.saba.integration.patternsdemo.messageconstruction.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Event {

    private Long id;
    private String type;
}
