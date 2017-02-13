package HW1;

public class Guard implements Runnable{

    public Guard() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (Building.timesKnocked != 10) {
            doSomething();
        }

        openDoor();
    }

    private void openDoor() {
        Building.openDoor();
    }

    private void doSomething() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
