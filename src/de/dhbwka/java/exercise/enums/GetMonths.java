package de.dhbwka.java.exercise.enums;

import java.util.Calendar;

public class GetMonths {

    public static void main(String[] args) {
        int monthNumber = Calendar.getInstance().get(Calendar.MONTH);

        Months month = Months.values()[monthNumber];

        StringBuilder stringBuilder = new StringBuilder();
        for (String element : month.getOldNames()){
            stringBuilder.append(element).append(", ");
        }
        int pos = stringBuilder.lastIndexOf(", ");
        stringBuilder.delete(pos, pos+2);

        System.out.println("Der " +  month + " hat " + month.getDays() + " Tage und hieß früher '" + stringBuilder + "'");
    }
    //Der Juni hat 30 Tage und hieß früher 'Brachet, Brachmond'
}
