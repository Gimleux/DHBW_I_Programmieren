package de.dhbwka.java.exercise.exam.Birthdays;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

public class Geburtstagsverwaltung {
    Set<Birthday> birthdays;
    final String file="birthdays.txt";


    JFrame frame;
    JPanel top;
    JPanel center;


    JComboBox monthChooser;
    JComboBox dayChooser;
    JComboBox sortChooser;

    JTextField nameField;
    JTextField yearField;

    JButton saveButton;
    JButton outputButton;


    public Geburtstagsverwaltung(){
        readFile();
        drawUI();

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    public void readFile(){
        try(BufferedReader bufferedReader=new BufferedReader(new FileReader(file))){
            birthdays=new HashSet<>();
            String[] line;
            while (bufferedReader.ready()){
                line=bufferedReader.readLine().split(";");
                birthdays.add(new Birthday(line[0],Integer.valueOf(line[1]),Integer.valueOf(line[2]),Integer.valueOf(line[3])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (NumberFormatException e){
            e.printStackTrace();
        }

    }
    public void drawUI(){
        frame=new JFrame("Geburtstagsverwaltung");
        top=new JPanel(new GridLayout(4,2));
        center=new JPanel(new BorderLayout());

        frame.add(top,BorderLayout.NORTH);
        frame.add(center,BorderLayout.CENTER);

        top.add(new JLabel("name"));
        nameField=new JTextField();
        top.add(nameField);
        top.add(new JLabel("Jahr"));
        yearField=new JTextField();
        top.add(yearField);
        top.add(new JLabel("Monat"));

        monthChooser=new JComboBox();

        for (int i = 1; i < 13; i++) {
            monthChooser.addItem(i);
        }

        top.add(monthChooser);


        top.add(new JLabel("Tag"));

        dayChooser=new JComboBox();

        for (int i = 1; i < 32; i++) {
            dayChooser.addItem(i);
        }

        top.add(dayChooser);


        saveButton=new JButton("Eintrag speichern");

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveEntry();
            }
        });

        center.add(saveButton,BorderLayout.NORTH);

        sortChooser=new JComboBox();

        sortChooser.addItem("Name");
        sortChooser.addItem("Jahr");
        sortChooser.addItem("Monat");

        JPanel cencenter=new JPanel();
        cencenter.add(new JLabel("Ausgabe sortiert nach:"));
        cencenter.add(sortChooser);

        sortChooser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output();
            }
        });

        center.add(cencenter,BorderLayout.CENTER);

        outputButton=new JButton("Alle Geburtstage des aktuellen Monats");

        outputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentMonth();
            }
        });

        center.add(outputButton,BorderLayout.SOUTH);


    }

    private void saveEntry() {
        try {
            birthdays.add(new Birthday(
                    nameField.getText(),
                    Integer.valueOf(yearField.getText()),
                    Integer.valueOf(monthChooser.getSelectedItem().toString()),
                    Integer.valueOf(dayChooser.getSelectedItem().toString())));
        }
        catch (Exception e){
            System.out.printf("bad entry");
        }

        writeEntry();
    }

    private void output() {
        System.out.println("output");

        StringBuilder stringBuilder=new StringBuilder();

        ArrayList<Birthday> sorted=new ArrayList();
        sorted.addAll(birthdays);


        String selected= (String) sortChooser.getSelectedItem();

        System.out.println(selected);
        switch (selected){
            case "Monat": sorted.sort(new Comparator<Birthday>() {
                @Override
                public int compare(Birthday o1, Birthday o2) {
                    return Integer.compare(o1.getMonth(),o2.getMonth());
                }
            });
                break;
            case "Jahr": sorted.sort(new Comparator<Birthday>() {
                @Override
                public int compare(Birthday o1, Birthday o2) {
                    return Integer.compare(o1.getYear(),o2.getYear());
                }
            });
                break;
            case "Name": sorted.sort(new Comparator<Birthday>() {
                @Override
                public int compare(Birthday o1, Birthday o2) {
                    return String.CASE_INSENSITIVE_ORDER.compare(o1.getName(), o2.getName());
                }
            });
        }


        for (Birthday b:
                sorted) {

            stringBuilder.append(b.getName()+" Jahr:"+b.getYear()+" Monat:"+b.getMonth()+" Tag:"+b.getDay()+"\n");


        }

        if (stringBuilder.toString().equals("")){stringBuilder.append("nichts gefunden :(");}
        JOptionPane.showMessageDialog(null,stringBuilder);

    }

    private void currentMonth() {
        StringBuilder stringBuilder=new StringBuilder();

        Calendar calendar= Calendar.getInstance();
        int month=calendar.get(Calendar.MONTH)+1;
        System.out.println(month);

        for (Birthday b:
                birthdays) {
            if (b.getMonth()==month){
                stringBuilder.append(b.getName()+" Jahr:"+b.getYear()+" Monat:"+b.getMonth()+" Tag:"+b.getDay()+"\n");
            }

        }

        if (stringBuilder.toString().equals("")){stringBuilder.append("nichts gefunden :(");}
        JOptionPane.showMessageDialog(null,stringBuilder);

    }



    private void writeEntry() {
        try(BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(file))){
            for (Birthday b:
                    birthdays) {
                bufferedWriter.write(b.getName()+";"+b.getYear()+";"+b.getMonth()+";"+b.getDay()+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new Geburtstagsverwaltung();
    }
}