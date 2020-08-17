package de.dhbwka.java.utilities.random;

public class Random {
    ///////////////////////////////////////////////////////////////////////////
    // DOUBLE
    ///////////////////////////////////////////////////////////////////////////
    public static double RandomDoubleIncMinExcMax(double min, double max) {
        return Math.random() * (max - min + 1) + min;
    }
//    public static double RandomDoubleInc0ExcMax(double max){
//        return RandomDoubleIncMinExcMax(0, max);
//    }
    ///////////////////////////////////////////////////////////////////////////
    // INT
    ///////////////////////////////////////////////////////////////////////////

    public static int RandomIntExcMinExcMax(int min, int max) {
        return RandomIntIncMinExcMax(min, max - 1) + 1;
    }

    public static int RandomIntIncMinExcMax(int min, int max) {
        return (int) (Math.random() * (max-min) + min);
    }

    public static int RandomIntExcMinIncMax(int min, int max) {
        return RandomIntIncMinExcMax(min, max) + 1;
    }

    public static int RandomIntIncMinIncMax(int min, int max) {
        return RandomIntIncMinExcMax(min, max + 1);
    }

//    public static int RandomIntExc0ExcMax(int max){
//        return RandomIntExcMinExcMax(0,max);
//    }
//    public static int RandomIntInc0ExcMax(int max){
//        return RandomIntIncMinExcMax(0, max);
//    }
//    public static int RandomIntExc0IncMax(int max){
//        return RandomIntExcMinIncMax(0,max);
//    }
//    public static int RandomIntInc0IncMax(int max){
//        return RandomIntIncMinIncMax(0,max);
//    }
}