package de.dhbwka.java.exercise.classes.periodictTable;

public class Metal extends Element {

    private boolean isMetalloid;
    private double conductivity;

    public Metal() {
    }

    public Metal(String name, String symbol, int ordinal, char shell, int phase, boolean isInMainGroup, boolean isMetalloid, double conductivity) {
        super(name, symbol, ordinal, shell, phase, isInMainGroup);
        this.isMetalloid = isMetalloid;
        this.conductivity = conductivity;
    }

    public boolean isMetalloid() {
        return isMetalloid;
    }

    public void setMetalloid(boolean metalloid) {
        isMetalloid = metalloid;
    }

    public double getConductivity() {
        return conductivity;
    }

    public void setConductivity(double conductivity) {
        this.conductivity = conductivity;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", isMetalloid=" + isMetalloid +
                ", conductivity=" + conductivity;
    }
}
