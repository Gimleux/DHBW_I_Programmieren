package de.dhbwka.java.exercise.classes;

public class Radio {
    private boolean on;
    private short volume;
    private float frequency;

    public Radio() {
    }

    /**
     * @param on        turns the radio on
     * @param volume    specifys the volume and applies it
     * @param frequency specifies the frequenzy and applies it
     */
    public Radio(boolean on, short volume, float frequency) {
        this.on = on;
        this.volume = volume;
        this.frequency = frequency;
    }

    public void incVolume(){
        this.volume = (volume<10) ? ++volume : 10;
    }

    public void decVolume(){
        this.volume = (volume>0) ? --volume : 0;
    }

    public void turnOn(){
        this.on = true;
    }

    public void turnOff(){
        this.on = false;
    }

    /**
     * @param frequency specifies the frequency and applies it if the frequency is in the range [85.0;110.0]
     *                  if the given double is too big the value is set to 99.9
     */
    public void setFrequency(float frequency) {
        this.frequency = (frequency<=110 && frequency>=85) ? frequency : 99.9f;
    }

    @Override
    public String toString() {
        return "Radio " +
                ((on) ? "an" : "aus") +
                ": Freq. = " + frequency +
                ", Laut. = " + volume;
    }

    public static void main(String[] args) {
        Radio radio = new Radio(false, (short) 7, 93.5f);
        System.out.println(radio);
        radio.turnOn();
        System.out.println(radio);
        radio.incVolume(); radio.incVolume();
        System.out.println(radio);
        radio.incVolume();
        radio.incVolume();
        System.out.println(radio);
        radio.decVolume();
        System.out.println(radio);
        radio.setFrequency(97.8f);
        System.out.println(radio);
        radio.setFrequency(112.7f);
        System.out.println(radio);
        radio.turnOff();
        System.out.println(radio);
    }
}
