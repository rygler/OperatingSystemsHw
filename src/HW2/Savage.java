package HW2;

/**
 * Created by Raphael Gal on 2/22/2017.
 */
public class Savage implements Runnable {

    public Savage(){
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (true){
            Constants.savageWantsToEnter = true;
            Constants.favoredThread = 2;

            while (Constants.cookWantsToEnter && Constants.favoredThread == 2) {
                doBusyWork();
            }

            if (Constants.foodInPot > 0) {
                Constants.foodInPot--;
                System.out.println("Savage eating from pot. Pot is now at " + Constants.foodInPot);
            }

            Constants.savageWantsToEnter = false;

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
