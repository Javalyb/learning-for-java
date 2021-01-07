package priv.lyb.roundinjection;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);
        A a = (A) applicationContext.getBean(A.class);
        System.out.println(a.getB());
        B b = (B) applicationContext.getBean(B.class);
        System.out.println(b);
        return;
    }


    @Override
    public void run(String... args) throws Exception {
    }
}
