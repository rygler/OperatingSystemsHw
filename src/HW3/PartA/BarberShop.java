package HW3.PartA;


/**
 * Created by Raphael on 3/3/2017.
 */
public class BarberShop {
    public boolean[] choosingSeatTicket;
    public int[] seatTicket;
    private int maxSeatTicketNumber;
    public int seatsTaken;
    public int barbersTaken;

    public boolean[] choosingBarberTicket;
    public int[] barberTicket;
    private int maxBarberTicketNumber;

    public BarberShop (int size) {
        choosingSeatTicket = new boolean[size];
        seatTicket = new int[size];
        maxSeatTicketNumber = 0;

        choosingBarberTicket = new boolean[size];
        barberTicket = new int[size];
        maxBarberTicketNumber = 0;

        seatsTaken = 0;
        barbersTaken = 0;
    }


    public int getMaxSeatTicketNumber() {
        return maxSeatTicketNumber++;
    }

    public int getMaxBarberTicketNumber() {
        return maxBarberTicketNumber++;
    }
}
