package PublicToilet;

public class ToiletBuilding implements PublicToilet {
    private int NOCabins;
    private int numberOfPersons;
    private boolean cleaning;

    public ToiletBuilding(int NOCabins) {
        this.NOCabins = NOCabins;
        numberOfPersons = 0;
    }

    private boolean personAllowed() {
        return !cleaning && numberOfPersons < 5;
    }

    private boolean cleaningAllowed() {
        return !cleaning && numberOfPersons <= 0;
    }

    @Override
    public synchronized void stepIntoCabin() {
        while (!personAllowed()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        numberOfPersons++;
    }

    @Override
    public synchronized void leaveCabin() {
        numberOfPersons--;
        notifyAll();
    }

    @Override
    public synchronized void startCleaning() {
        while (!cleaningAllowed()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        cleaning = true;
    }

    @Override
    public synchronized void endCleaning() {
        cleaning = false;
        notifyAll();
    }
}
