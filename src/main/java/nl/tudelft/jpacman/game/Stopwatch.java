package nl.tudelft.jpacman.game;

public class Stopwatch {
    private static long startTime = 0;
    private static long stopTime = 0;
    private static boolean running = false;


    public static void start() {
        startTime = System.currentTimeMillis();
        running = true;
    }

    public static void stop() {
        stopTime = System.currentTimeMillis();
        running = false;
    }


    //elaspsed time in seconds
    public static long getElapsedTimeSecs() {
        long elapsed;
        if (running) {
            elapsed = ((System.currentTimeMillis() - startTime) / 1000);
        } else {
            elapsed = ((stopTime - startTime) / 1000);
        }
        System.out.println(elapsed);
        return elapsed;
    }
}
