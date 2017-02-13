package HW1;

class Building {
    static int timesKnocked;
    static boolean isDoorOpen;

    static void knockDoor() {
        timesKnocked++;
    }

    static void openDoor() {
        isDoorOpen = true;
    }
}
