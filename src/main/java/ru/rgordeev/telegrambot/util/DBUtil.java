package ru.rgordeev.telegrambot.util;

import java.util.HashMap;
import java.util.Map;
import ru.rgordeev.telegrambot.model.Person;

public class DBUtil {
  public static final Map<Long, Person> db = new HashMap<>();
}
