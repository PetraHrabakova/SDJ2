package Drinks;

abstract class Drink
{
  private String name;
  private String description;

  public Drink(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public String getName()
  {
    return name;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public String toString() {
    return "Drink: " + name + ", Description: " + description;
  }
}
