package PublicToilet;

public class Start {
    public static void main(String[] args) {
        PublicToilet toilet = new ToiletBuilding(5);
        for (int i = 1; i <= 5; i++) {
            new Thread(new Person("Kim " + i, toilet)).start();
        }
        new Thread(new CleaningPerson(toilet)).start();
    }
}
