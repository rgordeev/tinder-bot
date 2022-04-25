package ru.rgordeev.telegrambot.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Person {
  private Long id;
  private String name;
  private String lastName;
  private Integer age;
  private String sex;
}
