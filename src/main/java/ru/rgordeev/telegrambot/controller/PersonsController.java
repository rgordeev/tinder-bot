package ru.rgordeev.telegrambot.controller;

import java.util.List;
import ru.rgordeev.telegrambot.model.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.rgordeev.telegrambot.services.PersonService;

@RestController("/")
public class PersonsController {

  private final PersonService personService;

  public PersonsController(PersonService personService) {
    this.personService = personService;
  }

  @RequestMapping(value = "/person", method = RequestMethod.GET)
  public ResponseEntity<List<Person>> listPersons() {
    return ResponseEntity.ok(personService.listAllPersons());
  }
}
