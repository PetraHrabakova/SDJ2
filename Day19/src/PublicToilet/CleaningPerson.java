package PublicToilet;

public class CleaningPerson implements Runnable {

    private PublicToilet toilet;

    public CleaningPerson(PublicToilet toilet) {
        this.toilet = toilet;
    }

    @Override
    public void run() {
        while (true) {
            toilet.startCleaning();
            try {
                System.out.println("Cleaning...");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            toilet.endCleaning();
            System.out.println("Cleaning person taking a break");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
