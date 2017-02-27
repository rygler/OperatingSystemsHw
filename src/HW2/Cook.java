package HW2;

/**
 * Created by Raphael Gal on 2/22/2017.
 */
public class Cook implements Runnable {

    public Cook() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (true) {
            Constants.cookWantsToEnter = true;
            Constants.favoredThread = 1;

            while (Constants.savageWantsToEnter && Constants.favoredThread == 1) {
                doBusyWork();
            }

            if (Constants.foodInPot == 0) {
                Constants.foodInPot += 10;
                System.out.println("Cook filling pot. Pot is now at " + Constants.foodInPot);
            }

            Constants.cookWantsToEnter = false;
        }
    }

    private void doBusyWork() {
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
