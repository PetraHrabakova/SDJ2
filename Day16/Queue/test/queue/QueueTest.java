package queue;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
  private QueueADT<String> q;

  @BeforeEach
  public void createQueue() {
    q = new BoundedArrayQueue<>(5);
  }


  @Test
  public void addedElementIsInQueue() {
    // arrange
    // act
    q.enqueue("A");
    // assert
    assertTrue(q.contains("A"));
  }

  @Test
  public void addMultipleElementsToQueue() {
    // arrange
    // act
    q.enqueue("A");
    q.enqueue("B");
    q.enqueue("C");
    // assert
    assertTrue(q.contains("A"));
    assertTrue(q.contains("B"));
    assertTrue(q.contains("C"));
  }

  @Test
  public void sizeIs4AfterAddingElements() {
    // arrange
    // act
    q.enqueue("A");
    q.enqueue("B");
    q.enqueue("C");
    q.enqueue("D");
    // assert
    assertEquals(4, q.size());
  }

  @Test
  public void fullQueueResultsInIllegalStateException() {
    q.enqueue("A");
    q.enqueue("B");
    q.enqueue("C");
    q.enqueue("D");
    q.enqueue("E");
    assertThrows(IllegalStateException.class, () -> q.enqueue("F"));
  }

  @Test
  public void emptyQueueDoesNotContainElementA() {
    assertFalse(q.contains("A"));
  }

  @Test
  public void fullQueueResultsInIllegalStateExceptionV2() {
    q.enqueue("A");
    q.enqueue("B");
    q.enqueue("C");
    q.enqueue("D");
    q.enqueue("E");
    try {
      q.enqueue("F");
      fail("Should not be able to insert 6th element");
    } catch(Exception e) {
    }
  }


}