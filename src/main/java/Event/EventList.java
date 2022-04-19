package Event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;

@Slf4j
public class EventList implements ApplicationListener<Event> {
    @Override
    public void onApplicationEvent(Event event) {
        log.info(event.getData());
    }
}
