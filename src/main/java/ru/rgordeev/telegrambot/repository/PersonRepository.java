package ru.rgordeev.telegrambot.repository;

import java.util.List;
import ru.rgordeev.telegrambot.model.Person;
import org.springframework.stereotype.Component;
import ru.rgordeev.telegrambot.util.DBUtil;

@Component
public class PersonRepository {
  public List<Person> listAll() {
    return DBUtil.db.values().stream().toList();
  }

  public Person findById(Long id) {
    return DBUtil.db.get(id);
  }

  public void save(Person person) {
    DBUtil.db.put(person.getId(), person);
  }
}
