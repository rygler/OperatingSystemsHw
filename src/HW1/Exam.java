package HW1;

class Exam {
    static int numberFinished;
    static boolean isExamOver;

    static void finishExam() {
        numberFinished++;
    }

    static void ExamIsOver() {
        isExamOver = true;
    }
}
