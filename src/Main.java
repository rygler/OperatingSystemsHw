import HW3.PartA.BarberShop;
import HW3.PartA.Customer;
import HW3.PartB.Calculator;
import HW3.PartB.ThreadGod;

/**
 * Edited by Raphael Gal on 2/22/2017.
 */
public class Main {

    public static void main(String[] args) {
//        int numberOfCustomers = 50;
//        BarberShop barberShop = new BarberShop(numberOfCustomers);
//
//        for (int i = 0; i < numberOfCustomers; i++) {
//            new Customer(i, barberShop, numberOfCustomers);
//        }

        int numberOfCalculators = 10;
        ThreadGod threadGod = new ThreadGod(numberOfCalculators);

        for (int i = 0; i < numberOfCalculators; i++) {
            new Calculator(i, numberOfCalculators, threadGod);
        }
    }
}
