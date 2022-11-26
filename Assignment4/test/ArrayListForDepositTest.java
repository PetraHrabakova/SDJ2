import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utility.collection.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListForDepositTest
{
  private ArrayList<Integer> list;

  @BeforeEach
  public void createQueue() {
    list = new ArrayList<>();
  }


  @Test
  public void constructor() {
    // arrange
    ArrayList<Integer> testList = new ArrayList<>();
    // act
    // assert
    assertNotNull(testList);
  }

  @Test
  public void addElementToList() {
    // arrange
    // act
    // assert
    assertDoesNotThrow(() -> list.add(0, 1));
  }

  @Test
  public void addNullElementToList() {
    // arrange
    // act
    // assert
    assertDoesNotThrow(() -> list.add(0, null));
  }

  @Test
  public void addMultipleElementsToList() {
    // arrange
    // act
    list.add(0, 0);
    list.add(1, null);
    list.add(2, 2);
    // assert
    assertEquals(3, list.size());
  }

  @Test
  public void addElementToIndex3OfAnEmptyArray_ThrowsIndexOutOfBoundException() {
    // arrange
    // act
    // assert
    assertThrows(IndexOutOfBoundsException.class, () -> list.add(3, 3));
  }

  @Test
  public void addElementToMinus1_ThrowsIndexOutOfBoundsException() {
    // arrange
    // act
    // assert
    assertThrows(IndexOutOfBoundsException.class, () ->list.add(-1, -1));
  }

  @Test
  public void addElementToSizeMinus1() {
    // arrange
    int index;
    // act
    list.add(0, 0);
    list.add(1, null);
    list.add(2, 2);
    index = list.size()-1;
    // assert
    assertDoesNotThrow(() -> list.add(index, 3));
  }

  @Test
  public void listContainsAddedElement() {
    // arrange
    // act
    list.add(0,1);
    // assert
    assertTrue(list.contains(1));
  }

  @Test
  public void listContainsAddedElements() {
    // arrange
    list.add(0,0);
    list.add(1,1);
    list.add(2,2);
    // act
    // assert
    assertTrue(list.contains(0));
    assertTrue(list.contains(1));
    assertTrue(list.contains(2));
  }

  @Test
  public void listDoesNotContainNotAddedElement() {
    // arrange
    // act
    // assert
    assertFalse(list.contains(0));
  }

  @Test
  public void getElement() {
    // arrange
    // act
    list.add(5);
    // assert
    assertDoesNotThrow(() -> list.get(0));
  }

  @Test
  public void getElementFromMinusIndex_ThrowsIllegalStateException() {
    // arrange
    // act
    // assert
    assertThrows(IllegalStateException.class, () -> list.get(1));
  }
  @Test
  public void getElementFromSizeMinus1() {
    // arrange
    list.add(0,0);
    list.add(1,1);
    list.add(2,2);
    // act
    int index = list.size() - 1;
    // assert
    assertDoesNotThrow(() -> list.get(index));
  }

  @Test
  public void isEmptyIsTrue() {
    // arrange
    // act
    // assert
    assertTrue(list.isEmpty());
  }

  @Test
  public void isEmptyIsFalse() {
    // arrange
    // act
    list.add(1);
    // assert
    assertFalse(list.isEmpty());
  }

  @Test
  public void isFull() {
    // arrange
    // act
    // assert
    assertFalse(list.isFull());
    // Returns True but should return False as empty list cannot be full
  }

  @Test
  public void removeElementThatDoesNotExistInList_ThrowsIndexOutOfBounds() {
    // arrange
    // act
    // assert
    assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
  }

  @Test
  public void removeElement() {
    // arrange
    list.add(0);
    // act
    // assert
    assertDoesNotThrow(() -> list.remove(0));
  }

  @Test
  public void removeMultipleElements() {
    // arrange
    // act
    list.add(0);
    list.add(1);
    list.add(2);
    list.add(3);
    // assert
    assertDoesNotThrow(() -> list.remove(3));
    assertDoesNotThrow(() -> list.remove(2));
  }

  @Test
  public void setElement() {
    // arrange
    // act
    list.add(0, 1);
    // assert
    assertDoesNotThrow(() -> list.set(0, 2));
  }

  @Test
  public void setMultipleElements() {
    // arrange
    // act
    list.add(0, 0);
    list.add(1, 1);
    list.add(2,2);
    // assert
    assertDoesNotThrow(() -> list.set(0, 3));
    assertDoesNotThrow(() -> list.set(1, 4));
    assertDoesNotThrow(() -> list.set(2, 5));
    assertEquals(3, list.get(0));
    assertEquals(4, list.get(1));
    assertEquals(5, list.get(2));
  }

  @Test
  public void size() {
    // arrange
    list.add(0, 0);
    list.add(1, 1);
    list.add(2,2);
    // act
    // assert
    assertEquals(3, list.size());
  }

  @Test
  public void sizeOfListAfterRemovingElement() {
    // arrange
    list.add(0, 0);
    list.add(1, 1);
    list.add(2,2);
    // act
    list.remove(0);
    // assert
    assertEquals(2, list.size());
  }

  @Test
  public void listToString() {
    assertEquals("{}", list.toString());
  }

  @Test
  public void listWithMultipleElementsToString() {
    list.add(1);
    list.add(2);
    assertEquals("{1, 2}", list.toString());
  }




















}