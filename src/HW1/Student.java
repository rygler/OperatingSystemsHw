package HW1;

public class Student implements Runnable {
    private int id;
    private long speed;

    public Student(int id, long speed) {
        this.id = id;
        this.speed = speed;
        new Thread(this).start();
    }

    public void run() {
        goToSchool();
        goToClassroom();
        takeExam();
    }

    private void goToSchool() {
        System.out.printf("Thread %d going to school\n", id);

        try {
            Thread.sleep(speed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Thread %d knocking school door. The door is knocked %d times\n", id, Building.timesKnocked);
        Building.knockDoor();

        while (!Building.isDoorOpen) {
            doSomething();
        }
    }

    private void goToClassroom() {
        System.out.printf("Thread %d going to classroom\n", id);

        try {
            Thread.sleep(speed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Thread %d knocking classroom door. The class door is knocked %d times\n", id, Classroom.timesKnocked);
        Classroom.knockClassroomDoor();

        while (!Classroom.isOpen) {
            doSomething();
        }
    }

    private void takeExam() {
        System.out.printf("Thread %d taking exam\n", id);

        try {
            Thread.sleep(speed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Thread %d finishing exam. The thread is the finisher # %d\n", id, Exam.numberFinished);
        Exam.finishExam();

        while (!Exam.isExamOver) {
            doSomething();
        }

        System.out.printf("Thread %d is going home. Hooray\n", id);
    }

    private void doSomething() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
