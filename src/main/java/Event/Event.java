package Event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;

public class Event extends ApplicationEvent {

    private final String data;

    public Event(String data) {
        super(data);
        this.data = data;
    }

    public String getData() {
        return data;
    }
}


