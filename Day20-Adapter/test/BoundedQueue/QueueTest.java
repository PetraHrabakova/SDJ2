package BoundedQueue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
  private Queue queue;

  @BeforeEach
  public void createQueue() {
    queue = new Queue(5);
  }

  @Test
  public void addedElementIsInQueue() {
    // arrange
    // act
    queue.enqueue("A");
    // assert
    assertTrue(queue.contains("A"));
  }

  @Test
  public void addMultipleElementsToQueue() {
    // arrange
    // act
    queue.enqueue("A");
    queue.enqueue("B");
    queue.enqueue("C");
    // assert
    assertTrue(queue.contains("A"));
    assertTrue(queue.contains("B"));
    assertTrue(queue.contains("C"));
  }

  @Test
  public void sizeIs4AfterAddingElements() {
    // arrange
    // act
    queue.enqueue("A");
    queue.enqueue("B");
    queue.enqueue("C");
    queue.enqueue("D");
    // assert
    assertEquals(4, queue.size());
  }

  @Test
  public void fullQueueResultsInIllegalStateException() {
    queue.enqueue("A");
    queue.enqueue("B");
    queue.enqueue("C");
    queue.enqueue("D");
    queue.enqueue("E");
    assertThrows(IllegalStateException.class, () -> queue.enqueue("F"));
  }

  @Test
  public void emptyQueueDoesNotContainElementA() {
    assertFalse(queue.contains("A"));
  }








}