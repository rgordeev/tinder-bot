package ru.rgordeev.telegrambot.services;

import java.util.List;
import java.util.Optional;
import ru.rgordeev.telegrambot.model.Person;

public interface PersonService {
  void addPerson(Person person);

  List<Person> listAllPersons();

  Optional<Person> findPerson(Long id);
}
