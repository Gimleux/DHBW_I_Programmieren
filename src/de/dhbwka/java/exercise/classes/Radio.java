package de.dhbwka.java.exercise.classes;

/**
 * @author Gimleux
 * @version 1.0
 */


public class Radio {
    private boolean on;
    private short volume;
    private float frequency;

    public Radio() {
        this.on = false;
        this.volume = 6;
        this.frequency = 99.9f;
    }

    /**
     * @param on        turns the radio on
     * @param volume    specifies the volume and applies it
     * @param frequency specifies the frequency and applies it
     */
    public Radio(boolean on, short volume, float frequency) {
        this.on = on;
        this.volume = volume;
        this.frequency = frequency;
    }

    /**
     *increase volume by 1 to a maximum of 10
     */
    public void incVolume(){
        this.volume = (volume<10) ? ++volume : 10;
    }

    /**
     *decrease volume by 1 to a minimum of 0
     */
    public void decVolume(){
        this.volume = (volume>0) ? --volume : 0;
    }

    /**
     * switch the radio on
     */
    public void turnOn(){
        this.on = true;
    }

    /**
     *switch the radio off
     */
    public void turnOff(){
        this.on = false;
    }

    /**
     * set a new frequency for the radio
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
