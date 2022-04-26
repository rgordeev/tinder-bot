package ru.rgordeev.telegrambot.model;

import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Person {
  @Id
  private Long id;

  @Basic
  @Column(name = "name")
  private String name;

  @Basic
  @Column(name = "last_name")
  private String lastName;

  @Basic
  @Column(name = "age")
  private Integer age;

  @Basic
  @Column(name = "sex")
  private String sex;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Person person = (Person) o;
    return Objects.equals(id, person.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
