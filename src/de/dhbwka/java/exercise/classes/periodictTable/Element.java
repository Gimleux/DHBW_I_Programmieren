package de.dhbwka.java.exercise.classes.periodictTable;

public class Element {
    public static final int SOLID = 1;
    public static final int LIQUID = 2;
    public static final int GAS = 3;
    public static final String[] phases =
            { "Plasma", "fest", "flüssig", "gasförmig" };
    public static final boolean MAIN = true;
    public static final boolean SIDE = false;

    private String name;
    private String symbol;
    private int ordinal;
    private char shell;
    private int phase;
    private boolean isInMainGroup;

    public Element(){
        this("Default","Default",0,'-','0',false);
    }

    public Element(String name, String symbol, int ordinal, char shell, int phase, boolean isInMainGroup) {
        this.name = name;
        this.symbol = symbol;
        this.ordinal = ordinal;
        this.shell = shell;
        this.phase = phase;
        this.isInMainGroup = isInMainGroup;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Element)){
            return false;
        } else {
            return ((Element) obj).getOrdinal()==ordinal;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(int ordinal) {
        this.ordinal = ordinal;
    }

    public char getShell() {
        return shell;
    }

    public void setShell(char shell) {
        this.shell = shell;
    }

    public int getPhase() {
        return phase;
    }

    public void setPhase(int phase) {
        this.phase = phase;
    }

    public boolean isInMainGroup() {
        return isInMainGroup;
    }

    public void setInMainGroup(boolean inMainGroup) {
        isInMainGroup = inMainGroup;
    }

    @Override
    public String toString() {
        return "Element:\n" +
                "name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", ordinal=" + ordinal +
                ", shell=" + shell +
                ", phase=" + phases[phase] +
                ", group=" + (isInMainGroup?"main":"side");
    }
}
