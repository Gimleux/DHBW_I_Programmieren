package de.dhbwka.java.exercise.classes.periodictTable;

import de.dhbwka.java.utilities.console.Console;

import java.util.ArrayList;

public class PeriodicTable {
    Element[] periodicTable = new Element[118];

    public PeriodicTable(){

    }

    public void addElement(Element element) {
        if (!hasElement(element.getOrdinal())) {
            periodicTable[element.getOrdinal() - 1] = element;
        }
    }

    public boolean hasElement(int ordinal) {
        return periodicTable[ordinal - 1] != null;
    }

    public Element getElement(int ordinal) {
        if (hasElement(ordinal)) {
            return periodicTable[ordinal - 1];
        } else {
            System.out.println("Fehler: Element nicht vorhanden;");
            return new Element();
        }
    }

    public Element[] getMetals() {
        ArrayList<Element> allMetals = new ArrayList<>();
        for (Element element : periodicTable) {
            if (element instanceof Metal) {
                allMetals.add(element);
            }
        }
        return allMetals.toArray(new Element[0]);
    }

    public static void main(String[] args) {
        PeriodicTable pt = new PeriodicTable();
        pt.addElement(new Element("Wasserstoff", "H", 1, 'K', Element.GAS,
                Element.MAIN));
        pt.addElement(new Element("Helium", "He", 2, 'K', Element.GAS,
                Element.MAIN));
        pt.addElement(new Metal("Natrium", "Na", 11, 'M', Element.SOLID,
                Element.MAIN,false,21E6));
        pt.addElement(new Metal("Eisen", "Fe", 26, 'N', Element.SOLID,
                Element.SIDE,false,10.02E6));
        pt.addElement(new Metal("Germanium", "Ge", 32, 'N', Element.SOLID,
                Element.SIDE,true,1.45));
        pt.addElement(new Element("Brom", "Br", 35, 'N', Element.LIQUID,
                Element.MAIN));
        pt.addElement(new Metal("Tellur", "Te", 52, 'O', Element.SOLID,
                Element.MAIN,true,0.005));
        pt.addElement(new Metal("Gold", "Au", 79, 'P', Element.SOLID,
                Element.SIDE,false,44E6));
        //Print PeriodicTable
        Console.printlnColoredText("Elemente:", "red");
        for(Element e : pt.periodicTable)
            if (e != null)
                System.out.println(e);
        //Print only Metals
        Console.printlnColoredText("\nMetalle:", "gray");
        for(Element e : pt.getMetals())
            System.out.println(e);
        //Print Gold
        Console.printlnColoredText("\nGold:", "orange");
        System.out.println(pt.getElement(79));
    }
}
