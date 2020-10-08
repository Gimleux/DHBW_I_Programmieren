package de.dhbwka.java.utilities.random;

public class Random {
    ///////////////////////////////////////////////////////////////////////////
    // DOUBLE
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Returns double value between min (inc) and max (exc)
     * @param min min value
     * @param max max value
     * @return random value
     */
    public static double RandomDoubleIncMinExcMax(double min, double max) {
        return Math.random() * (max - min) + min;
    }

    /**
     * Returns double value between 0 (inc) and max (exc)
     * @param max max value
     * @return random value
     */
    public static double RandomDoubleInc0ExcMax(double max){
        return RandomDoubleIncMinExcMax(0, max);
    }
    ///////////////////////////////////////////////////////////////////////////
    // INT
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Returns integer value between min (exc) and max (exc)
     * @param min min value
     * @param max max value
     * @return random value
     */
    public static int RandomIntExcMinExcMax(int min, int max) {
        return RandomIntIncMinExcMax(min, max - 1) + 1;
    }

    /**
     * Returns integer value between min (inc) and max (exc)
     * @param min min value
     * @param max max value
     * @return random value
     */
    public static int RandomIntIncMinExcMax(int min, int max) {
        return (int) (Math.random() * (max-min) + min);
    }

    /**
     * Returns integer value between min (exc) and max (inc)
     * @param min min value
     * @param max max value
     * @return random value
     */
    public static int RandomIntExcMinIncMax(int min, int max) {
        return RandomIntIncMinExcMax(min, max) + 1;
    }

    /**
     * Returns integer value between min (inc) and max (inc)
     * @param min min value
     * @param max max value
     * @return random value
     */
    public static int RandomIntIncMinIncMax(int min, int max) {
        return RandomIntIncMinExcMax(min, max + 1);
    }

    /**
     * Returns integer value between 0 (exc) and max (exc)
     * @param max max value
     * @return random value
     */
    public static int RandomIntExc0ExcMax(int max){
        return RandomIntExcMinExcMax(0,max);
    }

    /**
     * Returns integer value between 0 (inc) and max (exc)
     * @param max max value
     * @return random value
     */
    public static int RandomIntInc0ExcMax(int max){
        return RandomIntIncMinExcMax(0, max);
    }

    /**
     * Returns integer value between 0 (exc) and max (inc)
     * @param max max value
     * @return random value
     */
    public static int RandomIntExc0IncMax(int max){
        return RandomIntExcMinIncMax(0,max);
    }

    /**
     * Returns integer value between 0 (inc) and max (inc)
     * @param max max value
     * @return random value
     */
    public static int RandomIntInc0IncMax(int max){
        return RandomIntIncMinIncMax(0,max);
    }
}