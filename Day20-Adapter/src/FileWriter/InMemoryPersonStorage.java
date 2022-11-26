package FileWriter;

import java.util.ArrayList;

public class InMemoryPersonStorage implements PersonStorage
{
  private ArrayList<Person> persons;
  private int capacity;

  public InMemoryPersonStorage(int capacity) {
    this.capacity = capacity;
    persons = new ArrayList<>(capacity);
  }

  @Override public void addPerson(Person person) {
    if (persons.size() == capacity) {
      throw new IllegalStateException();
    }
    else {
      persons.add(person);
      System.out.println("Added: " + person);
    }
  }

  @Override public Person getPerson(int ssn)
  {
    if (persons.size() == 0) {
      throw new IllegalStateException();
    }
    else
      for (Person person: persons) {
        if (person.getSocialSecurityNumber() == ssn) {
          return person;
        }
      }
      return null;
  }
}
