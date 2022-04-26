package ru.rgordeev.telegrambot.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.rgordeev.telegrambot.TelegramBot;
import ru.rgordeev.telegrambot.services.PersonService;

/**
 * Инициализируем бота, передавая ему значения имени и токена
 */

@Component
public class TelegramBotInit {

    private final ApplicationProperties applicationProperties;

    public TelegramBotInit(ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

    @Bean
    @Autowired
    public TelegramBot telegramPollingBot(PersonService personService) {
        TelegramBot telegramPollingBot = new TelegramBot(
            personService,
            applicationProperties.getBot().getBotUsername(),
            applicationProperties.getBot().getBotToken()
        );
        return telegramPollingBot;
    }
}
