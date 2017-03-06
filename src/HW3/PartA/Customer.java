package HW3.PartA;

/**
 * Created by Raphael on 3/3/2017.
 */
public class Customer implements Runnable {
    private BarberShop barberShop;
    private int id;
    private int numberOfCustomers;

    public Customer(int id, BarberShop barberShop, int numberOfCustomers) {
        this.id = id;
        this.barberShop = barberShop;
        this.numberOfCustomers = numberOfCustomers;

        new Thread(this).start();
    }

    @Override
    public void run() {
        takeASeat();
        waitForAvailableBarber();
        chooseBarber();
    }

    private void takeASeat() {
        boolean isLookingForSeat = true;

        while (isLookingForSeat) {
            barberShop.choosingSeatTicket[id] = true;
            barberShop.seatTicket[id] = barberShop.getMaxSeatTicketNumber();
            System.out.printf("Thread %d choosing ticket #%d\n", id, barberShop.seatTicket[id]);
            barberShop.choosingSeatTicket[id] = false;

            for (int i = 0; i < numberOfCustomers; i++) {

                if (i == id) {
                    continue;
                }

                System.out.printf("Thread #%d waiting for %d to choose ticket, %b \n", id, i, barberShop.choosingSeatTicket[i]);
                while (barberShop.choosingSeatTicket[i]) {

                    busyWait();
                }

                System.out.printf("Thread #%d comparing ticket %d to thread #%d with ticket %d\n", id, barberShop.seatTicket[id], i, barberShop.seatTicket[i]);
                while (barberShop.seatTicket[i] != 0 && barberShop.seatTicket[i] < barberShop.seatTicket[id]) {
                    busyWait();
                }

                if (barberShop.seatTicket[i] == barberShop.seatTicket[id] && i < id) {

                    while (barberShop.seatTicket[i] != 0) {
                        busyWait();
                    }
                }
            }

            // critical section
            System.out.printf("Thread %d with ticket #%d checking for a seat %d\n", id, barberShop.seatTicket[id], barberShop.seatsTaken);
            if (barberShop.seatsTaken < 5) {
                barberShop.seatsTaken++;
                System.out.printf("Thread %d, with ticket #%d taking seat %d\n", id, barberShop.seatTicket[id], barberShop.seatsTaken);
                isLookingForSeat = false;
            }

            barberShop.seatTicket[id] = 0;
            // end critical section

            waitALittle();

        }
    }

    private void waitForAvailableBarber() {
        boolean isLookingForBarber = true;

        while (isLookingForBarber) {
            barberShop.choosingBarberTicket[id] = true;
            barberShop.barberTicket[id] = barberShop.getMaxBarberTicketNumber();
            barberShop.choosingBarberTicket[id] = false;

            for (int i = 0; i < numberOfCustomers; i++) {
                if (i == id) {
                    continue;
                }

                while (barberShop.choosingBarberTicket[i]) {
                    busyWait();
                }

                while (barberShop.barberTicket[i] != 0 && barberShop.barberTicket[i] < barberShop.barberTicket[id]) {
                    busyWait();
                }

                if (barberShop.barberTicket[i] == barberShop.barberTicket[id] && i < id) {

                    while (barberShop.barberTicket[i] != 0) {
                        busyWait();
                    }
                }
            }

            // critical section
            System.out.printf("Thread %d with ticket #%d checking for a barber %d\n", id, barberShop.barberTicket[id], barberShop.barbersTaken);
            if (barberShop.barbersTaken < 2) {
                barberShop.barbersTaken++;
                barberShop.seatsTaken--;
                System.out.printf("Thread %d, with ticket #%d taking barber %d\n", id, barberShop.barberTicket[id], barberShop.barbersTaken);
                isLookingForBarber = false;
            }

            barberShop.barberTicket[id] = 0;
            // end critical section
        }

        waitALittle();
        barberShop.barbersTaken--;
        System.out.printf("Thread %d leaving barber shop with a spiffy haircut\n", id);
    }

    private void chooseBarber() {

    }

    private void waitALittle() {
        int i = 0;
        while (i < 10000) {

            i++;
        }
    }

    private void busyWait() {
////        try {
//            Thread.yield();
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
    }
}
