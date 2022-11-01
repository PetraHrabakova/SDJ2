package TreeSetStrategy;

import java.util.Set;
import java.util.TreeSet;

public class TestTreeSet
{
  public static void main(String[] args)
  {
    Person person1 = new Person("Petra", "Hrabakova", 24);
    Person person2 = new Person("Devlin", "Onichuk", 23);
    Person person3 = new Person("Veronica", "Tverdohleb", 20);

    Comparator<Person> ageComparator = new AgeComparator();
    Comparator<Person> lastNameComparator = new LastnameComparator();

    //Set<Person> treeSetAge = new TreeSet<>(ageComparator.compare(person1, person2));
    // Set<Person> treeSetAge = new TreeSet<>(new AgeComparator());
    //treeSetAge.add(person1);
    //treeSetAge.add(person2);
    //treeSetAge.add(person3);








  }
}
