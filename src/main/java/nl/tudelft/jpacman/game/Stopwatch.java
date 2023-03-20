package nl.tudelft.jpacman.game;

public class Stopwatch {
    private static double startTime = 0;
    private static double stopTime = 0;
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
    public static double getElapsedTimeSecs() {
        double elapsed;
        if (running) {
            elapsed = ((System.currentTimeMillis() - startTime) / 1000.0);
        } else {
            elapsed = ((stopTime - startTime) / 1000.0);
        }
        System.out.println(elapsed);
        return elapsed;
    }
}
