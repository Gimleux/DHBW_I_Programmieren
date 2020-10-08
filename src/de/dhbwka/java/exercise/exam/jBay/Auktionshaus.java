package de.dhbwka.java.exercise.exam.jBay;

import java.util.ArrayList;
import java.util.List;

public class Auktionshaus {
    List<Auktion> auktionen;
    List<BieterTerminal> bts;

    void addAuktion(Auktion a){
        auktionen.add(a);
    }

    void removeAuktion(Auktion a){
        auktionen.remove(a);
    }

    public Auktionshaus() {
        this.auktionen = new ArrayList<Auktion>();
        bts = new ArrayList<BieterTerminal>();
    }

    public List<Auktion> getAuktionen() {
        return auktionen;
    }

    void register(BieterTerminal bt){
        bts.add(bt);
    }


    void unregister(BieterTerminal bt){
        bts.remove(bt);
    }
    void updateTerminals(){

        for (BieterTerminal b:
                bts) {
            System.out.println("u");
            b.updateBT();
        }
    }

}