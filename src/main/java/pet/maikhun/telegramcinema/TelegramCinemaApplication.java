package pet.maikhun.telegramcinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class TelegramCinemaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TelegramCinemaApplication.class, args);
    }

}
