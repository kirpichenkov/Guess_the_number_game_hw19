package Event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class EventPub implements ApplicationContextAware {
    private ApplicationContext context;

    public void pubEvent(String event) {
        context.publishEvent(new Event(event));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
