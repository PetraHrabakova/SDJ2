package PublicToilet;

public class Person implements Runnable {

    private String name;
    private PublicToilet toilet;

    public Person(String name, PublicToilet toilet) {
        this.name = name;
        this.toilet = toilet;
    }

    @Override
    public void run() {
        while (true) {
            toilet.stepIntoCabin();
            try {
                System.out.println(name + " is taking a dump");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            toilet.leaveCabin();
            try {
                System.out.println(name + " is eating again");
                Thread.sleep(System.currentTimeMillis()%1200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
