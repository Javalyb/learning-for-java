package priv.lyb.study;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MysqlApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(MysqlApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
