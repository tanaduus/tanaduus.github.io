package tanaduus.github.io.design.reactor.java;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    private String buffer;

    private EventType type;

}