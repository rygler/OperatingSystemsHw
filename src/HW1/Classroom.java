package HW1;

class Classroom {
    static int timesKnocked;
    static boolean isOpen;

    static void knockClassroomDoor() {
        timesKnocked++;
    }

    static void openClassroom() {
        isOpen = true;
    }
}
