package de.dhbwka.java.exercise.enums;

public enum Months {
    Januar(31, new String[]{"Hartung", "Eismond"}),
    Februar(28, new String[]{"Hornung", "Schmelzmond", "Taumond", "Narrenmond", "Rebmond", "Hintester"}),
    Maerz(31, new String[]{"Lenzing", "Lenzmond"}),
    April(30, new String[]{"Laning", "Ostermond"}),
    Mai(31, new String[]{"Winnemond", "Blumenmond"}),
    Juni(30, new String[]{"Brachet", "Brachmond"}),
    Juli(31, new String[]{"Heuert", "Heumond"}),
    August(31, new String[]{"Ernting", "Erntemond", "Bisemond"}),
    September(30, new String[]{"Scheiding", "Herbstmond"}),
    Oktober(31, new String[]{"Gilbhart", "Weinmond"}),
    November(30, new String[]{"Nebelung", "Windmond", "Wintermond"}),
    Dezember(31, new String[]{"Julmond", "Heilmond", "Christmond", "Dustermond"});

    private final int days;
    private final String[] oldNames;

    Months(int days, String[] oldGermanNames) {
        this.days = days;
        this.oldNames = oldGermanNames;
    }

    public int getDays() {
        return days;
    }

    public String[] getOldNames() {
        return oldNames;
    }

    public String getMonth(int number){
        return Months.values()[number].toString();
    }
}

/*
Hinweis:
Den aktuellen Monat bekommen Sie mit
new Date().getMonth()
oder seit JDK 1.1 besser:
Calendar.getInstance().get(Calendar.MONTH)
als int (Zählung beginnt bei 0).
 */