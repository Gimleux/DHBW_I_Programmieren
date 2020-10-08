package de.dhbwka.java.exercise.exam.jBay;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class Auktion {
    private Ware ware;
    private Gebot gebot =null;
    private double price=0.0;
    private Calendar end;
    static double increment=1.0;


    boolean  gebotAbgeben(Gebot g,Auktion a)  {

        try (FileWriter fileWriter = new FileWriter("log.log",true
        )) {

            fileWriter.append("["+java.util.Calendar.getInstance().getTime().toString()+"]"+" Gebot von "+g.getMaxBieter().getFullName()+" für "+
                    a.getWare().getBeschreibung()+" :" + " " +g.getMaxGebot()+"\n");
        }
        catch (Exception e){}

        if (g.getMaxGebot() < (price + increment)) return  false;

        if (gebot ==null){
            price = increment;
            gebot = g;
            return  true;
        }
        if (g.getMaxBieter() == gebot.getMaxBieter()){
            if (g.getMaxGebot() > gebot.getMaxGebot()){
                gebot = g;
                return  true;
            }
            else return false;
        }
        if (g.getMaxGebot() >=(price + increment)){
            System.out.println("neus ge");
            if (g.getMaxGebot() <= gebot.getMaxGebot()){
                price = Math.min(g.getMaxGebot() + increment, gebot.getMaxGebot());
                return  false;
            }
            else {
                gebot = g;
                price = Math.min(gebot.getMaxGebot() + increment, g.getMaxGebot());
                return true;
            }
        }
        return  false;
    }

    public Auktion(Ware ware,int dauer)  {



        java.util.Calendar zeit = java.util.Calendar.getInstance();
        zeit.setTimeInMillis(System.currentTimeMillis() + 60000 * dauer);
        end = zeit;
        this.ware = ware;
    }

    public Ware getWare() {
        return ware;
    }

    public Gebot getGebot() {
        return gebot;
    }

    public double getPrice() {
        return price;
    }

    public Calendar getEnd() {
        return end;
    }

    public static double getIncrement() {
        return increment;
    }
}