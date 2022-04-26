package ru.rgordeev.telegrambot.services;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import ru.rgordeev.telegrambot.model.Person;
import ru.rgordeev.telegrambot.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

  private final PersonRepository personRepository;

  public PersonServiceImpl(PersonRepository repository) {
    this.personRepository = repository;
  }

  @Override
  public void addPerson(Person person) {
    personRepository.save(person);
  }

  @Override
  public List<Person> listAllPersons() {
    return personRepository.findAll();
  }

  @Override
  public Optional<Person> findPerson(Long id) {
    return personRepository.findById(id);
  }
}
