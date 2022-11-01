package TreeSetStrategy;

public class LastnameComparator implements Comparator<Person>
{
  public int compare(Person person1, Person person2) {
    return person1.getLastname().compareTo(person2.getLastname());
  }
}
