package TreeSetStrategy;

public class AgeComparator implements Comparator<Person>
{
  public int compare(Person person1, Person person2) {
    int ageDiff = 0;
    if (person1.getAge() < person2.getAge()) {
      ageDiff = person2.getAge() - person1.getAge();
    }
    else if (person2.getAge() < person1.getAge()) {
      ageDiff = person2.getAge() - person1.getAge();
    }
    return ageDiff;
  }
}
