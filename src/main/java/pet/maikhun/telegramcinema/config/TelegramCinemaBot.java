package pet.maikhun.telegramcinema.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import pet.maikhun.telegramcinema.config.BotConfig;

import java.util.List;

/**
 * Реализация телеграмм бота
 */
@Slf4j
@Component
public class TelegramCinemaBot extends TelegramLongPollingBot {

    /**
     * Название бота в телеграмме
     */
    private final String name;

    public TelegramCinemaBot(BotConfig botConfig) {
        super(botConfig.getToken());
        this.name = botConfig.getName();
    }

    @Override
    public void onUpdateReceived(Update update) {
        // Событие == Получил сообщение
        if(update.hasMessage() && update.getMessage().hasText()){
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            String memberName = update.getMessage().getFrom().getFirstName();

            // TODO
            switch (messageText){
                case "/start":
                    startBot(chatId, memberName);
                    break;
                default:
                    // TODO обработка отрицательного сценария
                    break;
            }
        }
    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        super.onUpdatesReceived(updates);
    }

    @Override
    public String getBotUsername() {
        return name;
    }

    /**
     * TODO Нормальную обработку ответов и пользовательский сценарий
     * @param chatId
     * @param memberName
     */
    private void startBot(long chatId, String memberName) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Hello, " + memberName + "! I'm a Telegram bot.");
        try {
            execute(message);
            log.info("Message was successfully sended! \nMessage: {}\nChatId: {}", message, chatId);
        } catch (TelegramApiException e){
            log.error(e.getMessage());
        }
    }
}
