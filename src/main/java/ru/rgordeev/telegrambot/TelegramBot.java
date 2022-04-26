package ru.rgordeev.telegrambot;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.rgordeev.telegrambot.model.Person;
import ru.rgordeev.telegrambot.services.PersonService;

@Slf4j
public class TelegramBot extends TelegramLongPollingBot {

  private final PersonService personService;
  private final String botUserName;
  private final String botToken;

  public TelegramBot(PersonService personService, String botUserName, String botToken) {
    this.personService = personService;
    this.botUserName = botUserName;
    this.botToken = botToken;
  }

  @Override
  public String getBotUsername() {
    return botUserName;
  }

  @Override
  public String getBotToken() {
    return botToken;
  }

  @Override
  public void onUpdateReceived(Update update) {
    log.info("BOT DATA: " + update.getMessage().getText());
    try {
      User from = update.getMessage().getFrom();
      Person person = Person.builder()
          .id(from.getId())
          .name(from.getFirstName())
          .lastName(from.getLastName()).build();
      if (!personService.findPerson(from.getId()).isPresent()) {
        personService.addPerson(person);
      }
      sendApiMethod(
          new SendMessage(update.getMessage().getChatId().toString(),
              "Hello from bot!")
      );
    } catch (TelegramApiException e) {
      log.error(e.getMessage(), e);
    }
  }
}
