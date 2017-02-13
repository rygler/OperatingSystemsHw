package HW1;

public class Professor implements Runnable{

    public Professor() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (Classroom.timesKnocked != 10) {
            doSomething();
        }

        Classroom.openClassroom();

        while (Exam.numberFinished < 8) {
            doSomething();
        }

        Exam.ExamIsOver();
    }

    private void doSomething() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
