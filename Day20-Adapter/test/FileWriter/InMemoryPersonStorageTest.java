package FileWriter;

import BoundedQueue.Queue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryPersonStorageTest {
  private InMemoryPersonStorage storage;

  @BeforeEach
  public void createInMemoryPersonStorage() {
    storage = new InMemoryPersonStorage(1);
  }

  @Test
  public void addedPersonInStorage() {
    // arrange
    Person person = new Person("Petra", "29/06/1998", 12345);
    // act
    storage.addPerson(person);
    // assert
    assertEquals(person, storage.getPerson(12345));
  }

  @Test
  public void fullMemoryResultsInIllegalStateException() {
    // arrange
    Person person1 = new Person("Petra", "29/06/1998", 12345);
    Person person2 = new Person("Veronica", "09/03/2002", 98765);
    // act
    storage.addPerson(person1);
    // assert
    assertThrows(IllegalStateException.class, () -> storage.addPerson(person2));
  }

  @Test
  public void getPersonFromEmptyStorageResultsInIllegalStateException() {
    assertThrows(IllegalStateException.class, () -> storage.getPerson(12345));
  }






}