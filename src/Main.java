import HW1.Guard;
import HW1.Professor;
import HW1.Student;

import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        new Guard();
        new Professor();

        for (int i = 0; i < 10; i++) {
            new Student(i, ThreadLocalRandom.current().nextLong(2000, 6000));
        }
    }
}
