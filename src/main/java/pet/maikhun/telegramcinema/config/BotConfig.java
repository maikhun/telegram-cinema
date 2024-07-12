package pet.maikhun.telegramcinema.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Класс с инфой телеграмм бота
 */
@Data
@NoArgsConstructor
@Configuration
public class BotConfig {

    /**
     * Название бота
     */
    @Value("${bot.name}")
    private String name;

    /**
     * Токен для подключения к боту
     */
    @Value("${bot.token}")
    private String token;

    /**
     * Идентификатор диалога с пользователем
     */
    @Value("${bot.chatId}")
    private String chatId;
}
