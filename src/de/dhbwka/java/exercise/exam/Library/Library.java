package de.dhbwka.java.exercise.exam.Library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Library {
    Set<Book> books = new TreeSet<>(new BookComperator());
    Set<Book> aBooks = new TreeSet<>(new BookAutherCompare());
    Set<Book> yBooks = new TreeSet<>(new BookYearCompare());
    Set<Book> pBooks = new TreeSet<>(new BookPublisherCompare());

    TextFileVal file = new TextFileVal("Library.txt");

    JTextField ttf;
    JTextField atf;
    JTextField ytf;
    JTextField ptf;
    JButton saveB;
    public Library() {

        initFile();
        creatGUI();

    }

    void initFile(){
        String[] lines  =file.getLines();
        String[] e;
        Book b;
        for (String l:
                lines) {
            e = l.split(",");

            try {
                b = new Book(e[0],e[1],Integer.parseInt(e[2]),e[3]);
                books.add(b);
                aBooks.add(b);
                yBooks.add(b);
                pBooks.add(b);
            }
            catch (Exception ex){
                System.out.println("bad entry");
            }
        }
    }

    void creatGUI() {

        JFrame jf = new JFrame("Book Management");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new BorderLayout(5, 5));
        JPanel top = new JPanel();
        top.setLayout(new GridLayout(4, 2, 2, 2));
        top.add(new JLabel("Author"));
        ttf = new JTextField("");
        top.add(ttf);
        top.add(new JLabel("Title"));
        atf = new JTextField("");
        top.add(atf);
        top.add(new JLabel("Year"));
        ytf = new JTextField("");
        top.add(ytf);

        top.add(new JLabel("Publisher"));
        ptf = new JTextField("");
        top.add(ptf);
        jf.add(top, BorderLayout.NORTH);
        JPanel mid = new JPanel();
        saveB = new JButton("Save Entry");
        saveB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                readEnty();
            }
        });
        mid.add(saveB);
        jf.add(mid, BorderLayout.CENTER);
        JPanel bot = new JPanel();
        bot.setLayout(new FlowLayout());
        bot.add(new JLabel("Output sorted by:"));
        JButton outA  =new JButton("Author");
        outA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null,concatBooks(aBooks) );
            }
        });
        bot.add(outA);
        JButton outT = new JButton("Title");
        outT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null,concatBooks(books) );
            }
        });
        bot.add(outT);
        JButton outY = new JButton("Year");

        outY.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null,concatBooks(yBooks) );
            }
        });
        bot.add(outY);
        jf.add(bot, BorderLayout.SOUTH);
        jf.pack();
        jf.setVisible(true);
    }

    private void readEnty() {
        try {
            Book b =new Book(ttf.getText(),atf.getText(),Integer.parseInt(ytf.getText()), ptf.getText());
            books.add(b);
            aBooks.add(b);
            yBooks.add(b);
            pBooks.add(b);

            ArrayList<String> strings = new ArrayList<>();
            for (Book bo:
                    books) {
                System.out.println(bo);
                strings.add(String.join(",",bo.getTitle(),bo.getAuthor(), String.valueOf(bo.getYear()),bo.getPublisher()));
            }
            System.out.println(strings);
            file.setLines(strings);
            file.write();
        }
        catch (Exception e){
            System.out.println("bad entry");
        }
    }

    String concatBooks(Set<Book> localbooks){
        ArrayList<String> strings = new ArrayList<>();
        for (Book b:
                localbooks) {
            strings.add(b.getTitle() +" "+b.getAuthor()+" "+b.getYear()+" "+ b.getPublisher()+"\n");
        }
        return strings.toString();
    }

    public static void main(String[] args) {
        new Library();
    }
}