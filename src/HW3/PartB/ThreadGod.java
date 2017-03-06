package HW3.PartB;

/**
 * Created by Raphael on 3/5/2017.
 */
public class ThreadGod {
    public int addCounter;
    public int product = 1;
    public int[] addTicket;
    public int[] multiplicationTicket;
    public boolean[] isAddTicketChosen;
    public boolean[] isMultiplicationTicketChosen;


    public ThreadGod(int size) {
        addTicket = new int[size];
        multiplicationTicket = new int [size];
        isAddTicketChosen = new boolean[size];
        isMultiplicationTicketChosen = new boolean[size];
    }

}
