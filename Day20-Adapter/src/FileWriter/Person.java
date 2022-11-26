package FileWriter;

public class Person
{
  private String name;
  private String dateOfBirth;
  private int socialSecurityNumber;

  public Person(String name, String dateOfBirth, int socialSecurityNumber) {
    this.name = name;
    this.dateOfBirth = dateOfBirth;
    this.socialSecurityNumber = socialSecurityNumber;
  }

  public int getSocialSecurityNumber()
  {
    return socialSecurityNumber;
  }
}
