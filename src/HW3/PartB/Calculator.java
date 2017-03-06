package HW3.PartB;

/**
 * Created by Raphael on 3/5/2017.
 */
public class Calculator implements Runnable {
    private int id;
    private int numberOfCalculators;
    private ThreadGod threadGod;

    public Calculator(int id, int numberOfCalculators, ThreadGod threadGod) {
        this.id = id;
        this.numberOfCalculators = numberOfCalculators;
        this.threadGod = threadGod;

        new Thread(this).start();
    }

    @Override
    public void run() {
        addCounter();

        while (threadGod.addCounter != numberOfCalculators) {
            doBusyWork();
        }

        calculateProduct();
    }

    private void addCounter() {
        threadGod.addTicket[id] = id + 1;
        threadGod.isAddTicketChosen[id] = true;

        for (int i = 0; i < numberOfCalculators; i++) {
            if (i == id) {
                continue;
            }

            System.out.printf("Add: Thread #%d checking if thread #%d chose ticket, %b\n", id, i, threadGod.isAddTicketChosen[i]);
            while (!threadGod.isAddTicketChosen[i]) {
                doBusyWork();
            }

            System.out.printf("Add: Thread #%d with ticket %d comparing thread #%d with ticket %d\n", id, threadGod.addTicket[id], i, threadGod.addTicket[i]);
            while (threadGod.addTicket[i] != 0 && threadGod.addTicket[i] < threadGod.addTicket[id]) {
                doBusyWork();
            }
        }

        // critical section
        threadGod.addCounter++;
        System.out.printf("Add: Thread #%d incremented counter. Counter is now %d\n", id, threadGod.addCounter);
        threadGod.addTicket[id] = 0;
        // end critical section

    }

    private void calculateProduct() {
        threadGod.multiplicationTicket[id] = id + 1;
        threadGod.isMultiplicationTicketChosen[id] = true;

        for (int i = 0; i < numberOfCalculators; i++) {
            if (i == id) {
                continue;
            }

            System.out.printf("Multiplication: Thread #%d checking if thread #%d chose ticket, %b\n", id, i, threadGod.isMultiplicationTicketChosen[i]);
            while (!threadGod.isMultiplicationTicketChosen[i]) {
                doBusyWork();
            }

            System.out.printf("Multiplication: Thread #%d with ticket %d comparing thread #%d with ticket %d\n", id, threadGod.multiplicationTicket[id], i, threadGod.multiplicationTicket[i]);
            while (threadGod.multiplicationTicket[i] != 0 && threadGod.multiplicationTicket[i] < threadGod.multiplicationTicket[id]) {
                doBusyWork();
            }
        }

        // critical section
        threadGod.product *= 2;
        System.out.printf("Multiplication: Thread #%d multiplied product. Product is now %d\n", id, threadGod.product);
        threadGod.multiplicationTicket[id] = 0;
        // end critical section
    }

    private void doBusyWork() {
        Thread.yield();
    }
}
