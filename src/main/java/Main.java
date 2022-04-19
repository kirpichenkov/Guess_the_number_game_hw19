import Event.EventPub;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;
import java.util.Scanner;

public class Main implements ApplicationContextAware {
    private static ApplicationContext context;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");
        Locale locale = Locale.getDefault();
        Scanner scanner = new Scanner(System.in);
               int factor = 1000;
        int number = (int)(Math.random()*factor);
        System.out.println(locale.getCountry());
        System.out.println(number);

        EventPub pub = context.getBean(EventPub.class);
        pub.pubEvent(context.getMessage("hello", null, Locale.getDefault()));
        pub.pubEvent(context.getMessage("condition", null, Locale.getDefault()));

        while (true){

            int inputNumber = scanner.nextInt();
            if(inputNumber == number){
                pub.pubEvent(context.getMessage("guessed", new Object[]{number}, locale));

                break;
            } else if(inputNumber>number){
                pub.pubEvent(context.getMessage("less", null, locale));

            }else {
                pub.pubEvent(context.getMessage("big", null, locale));

            }

        }
        scanner.close();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
