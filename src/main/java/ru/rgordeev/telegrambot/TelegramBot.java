package ru.rgordeev.telegrambot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.rgordeev.telegrambot.model.Person;
import ru.rgordeev.telegrambot.services.PersonService;

@Slf4j
@Component
public class TelegramBot extends TelegramLongPollingBot {

  private final PersonService personService;

  public TelegramBot(PersonService personService) {
    this.personService = personService;
  }

  @Override
  public String getBotUsername() {
    return "PMK3x_bot";
  }

  @Override
  public String getBotToken() {
    return "5259733331:AAGxR0Lk0u9Uc3JfcdEs5XtyBd4E5ChJmpg";
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
      personService.addPerson(person);
      sendApiMethod(
          new SendMessage(update.getMessage().getChatId().toString(),
              "Hello from bot!")
      );
    } catch (TelegramApiException e) {
      log.error(e.getMessage(), e);
    }
  }
}
