package de.dhbwka.java.exercise.collections.library;

import de.dhbwka.java.utilities.files.read.wholeTextFiles.FileToStringArray;
import de.dhbwka.java.utilities.files.write.append.AppendStringToFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library extends JFrame {
    private JTextField tfTitle = new JTextField();
    private JTextField tfAuthor = new JTextField();
    private JTextField tfYear = new JTextField();
    private JTextField tfPublisher = new JTextField();

    private List<Book> books = new ArrayList<>();

    private final String PATH = "library.txt";

    public Library() throws HeadlessException {
        this.setTitle("Library");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(getMainContent());
        this.add(getFooter(), BorderLayout.SOUTH);

        books.clear();
        readLibraryInBooks();

        this.setSize(480, 200);
        this.setVisible(true);
    }

    //-------------Frame Content------------------
    private JPanel getMainContent() {
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        JPanel getInputs = new JPanel(new GridLayout(4, 2));
        getInputs.add(new JLabel("Title"));
        getInputs.add(tfTitle);
        getInputs.add(new JLabel("Author"));
        getInputs.add(tfAuthor);
        getInputs.add(new JLabel("Year"));
        getInputs.add(tfYear);
        getInputs.add(new JLabel("Publisher"));
        getInputs.add(tfPublisher);

        contentPanel.add(getInputs);
        JButton button = new JButton("Save entry");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String saveEntryError = saveEntry();
                if (saveEntryError != null) {
                    JOptionPane.showMessageDialog(null, saveEntryError);
                }
            }
        });
        contentPanel.add(button, BorderLayout.SOUTH);

        return contentPanel;
    }

    private JPanel getFooter() {
        String[] categories = new String[]{"Title", "Author", "Year", "Publisher"};
        JPanel footerPanel = new JPanel();
        footerPanel.add(new JLabel("Ordered output:"));
        for (int i = 0; i<categories.length; i++) {
            JButton button = new JButton(categories[i]);
            int finalI = i;
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    printOrderedOutput(finalI);
                }
            });
            footerPanel.add(button);
        }

        return footerPanel;
    }
    //---------End-Frame Content------------------

    /**
     * Saves new book (attributes come from this.attributes) to library-file and adds is to books array, both only if book is not already included in library file
     * @return short error description or null if everything worked fine
     */
    private String saveEntry() {
        if (tfAuthor.getText().equals("") || tfTitle.getText().equals("") || tfYear.getText().equals("") || tfPublisher.getText().equals("")) {
            return "Error: Please fill all fields";
        }
        try {
            Book newBook = new Book(tfTitle.getText(), tfAuthor.getText(), Integer.parseInt(tfYear.getText()), tfPublisher.getText());

            boolean alreadyIncluded = false;
            for (Book savedBook : books) {
                if (savedBook.equals(newBook)) {
                    alreadyIncluded = true;
                    break;
                }
            }
            if (alreadyIncluded) {
                clearInputs();
                return "Error: Book already included";
            } else {
                books.add(newBook);
                try {
                    AppendStringToFile.appendStringToFile_WithErrorDescription(PATH, newBook.toString());
                    clearInputs();
                } catch (Exception e) {
                    return "Error writing file " + PATH + ": " + e.getMessage();
                }
            }
            return null;
        } catch (NumberFormatException e) {
            return "Error: Year must be a valid number!";
        }
    }

    /**
     * reads library file in books array and shows messageDialog with all books listed
     * order depending on param
     * @param category category by witch books shall be sorted -> 0: Title; 1: Author; 2: Year; 3: Publisher
     */
    private void printOrderedOutput(int category) {
        books.clear();
        readLibraryInBooks();
        if(books.isEmpty()){
            JOptionPane.showMessageDialog( this, "No books saved",
                    "Books ordered by category " + category, JOptionPane.INFORMATION_MESSAGE);
        } else {
            Collections.sort(books, new BookComparator(category));
            JOptionPane.showMessageDialog(this, getAllBooks(category),
                    "Books ordered by category " + category, JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * refills books array with books stored in library file
     */
    private void readLibraryInBooks() {
        books.clear();
        String[] booksArray = FileToStringArray.getFileToString_NullIfError(PATH);
        if (booksArray != null) {
            for (String bookString : booksArray) {
                String[] bookDetails = bookString.split(";");
                try {
                    Book book = new Book(bookDetails[0], bookDetails[1], Integer.parseInt(bookDetails[2]), bookDetails[3]);
                    books.add(book);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error: Database corrupted!");
                    return;
                }
            }
        }
    }

    /**
     * Creates and returns string with all books from books array, one line = one book
     * @param category category which shall be in front of each books information -> 0: Title; 1: Author; 2: Year; 3: Publisher
     * @return string including all books with their information, separated by lineSeparator and every line beginning with selected category
     */
    private String getAllBooks(int category){
        StringBuilder stringBuilder = new StringBuilder();
        for (Book book : books){
            //Sort BookProperties that chosen category comes first
            String[] bookProperties= book.toString().split(";");
            stringBuilder.append(bookProperties[category]).append("; ");
            for (int i = 0; i<bookProperties.length; i++){
                if (i!=category){
                    stringBuilder.append(bookProperties[i]).append("; ");
                }
            }
            //delete last ";"
            stringBuilder.lastIndexOf(";");
            stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(";"));

            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    /**
     * clears the form's input fields
     */
    private void clearInputs(){
        tfPublisher.setText("");
        tfYear.setText("");
        tfTitle.setText("");
        tfAuthor.setText("");
    }

    public static void main(String[] args) {
        new Library();
    }
}