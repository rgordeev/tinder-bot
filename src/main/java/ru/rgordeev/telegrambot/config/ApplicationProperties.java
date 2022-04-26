package ru.rgordeev.telegrambot.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Component
@ConfigurationProperties(prefix = "application.telegram")
public class ApplicationProperties {

    private TelegramBotConfig bot;

    @Getter
    @Setter
    @NoArgsConstructor
    public static class TelegramBotConfig {
        private String botUsername;
        private String botToken;
    }
}
