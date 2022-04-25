package ru.rgordeev.telegrambot.services;

import java.util.List;
import ru.rgordeev.telegrambot.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.rgordeev.telegrambot.repository.PersonRepository;

@Component
public class PersonService {
  private final PersonRepository repository;

  @Autowired
  public PersonService(PersonRepository repository) {
    this.repository = repository;
  }

  public void addPerson(Person person) {
    repository.save(person);
  }

  public List<Person> listAllPersons() {
    return repository.listAll();
  }

  public Person findPerson(Long id) {
    return repository.findById(id);
  }
}
