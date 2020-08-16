package de.dhbwka.java.exercise.ui.event;

import de.dhbwka.java.utilities.files.read.dataFiles.DataFileToArray;
import de.dhbwka.java.utilities.files.write.append.AppendStringToFile;
import de.dhbwka.java.utilities.print.PrintArray;
import de.dhbwka.java.utilities.print.PrintMatrix;
import de.dhbwka.java.utilities.random.Random;
import de.dhbwka.java.utilities.search.Biggest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGuess extends JFrame implements ActionListener {
    private int guess;
    private String name;
    private NumberGuessGame gameInstance;
    private JTextField tfName = new JTextField(20);
    private JTextField tfGuess = new JTextField(10);
    private JTextField tfMessage = new JTextField(29);

    private final String[] BUTTON_LABELS = new String[]{"New Game", "OK", "Best Player", "Exit"};
    private final int MIN = 1;
    private final int MAX = 1000;

    /**
     * Creates a NumberGuess Frame
     */
    public NumberGuess() throws HeadlessException {
        super("NumberGuessingGame");
        this.setLayout(new BorderLayout(5, 5));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(getHeaderComponents(), BorderLayout.NORTH);
        this.add(getCenterComponents());
        this.add(getFooterComponents(), BorderLayout.SOUTH);

        this.pack();
        this.setVisible(true);
    }

    /**
     * Depending on the clicked Button:
     * New Game: Starts a new Game through new instance of NumberGuessGame
     * OK: Takes given guess and verifies it. Deletes instance of NumberGuessGame if correct.
     * Best Player: Searches for Best Player in scores.txt and prints them in MessegeField
     * Exit: Closes Program
     * @param e ActionEvent which triggered the method
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String text = ((JButton) e.getSource()).getText();
        if (text.equalsIgnoreCase(BUTTON_LABELS[0])) {
            startNewGame();
        } else if (text.equalsIgnoreCase(BUTTON_LABELS[1])) {
            giveAGuess();
        } else if (text.equalsIgnoreCase(BUTTON_LABELS[2])) {
            printBestPlayer();
        } else if (text.equalsIgnoreCase(BUTTON_LABELS[3])) {
            System.exit(0);
        }
    }

    /**
     * Starts new game through creating new instance of NumberGuessGame class
     */
    private void startNewGame() {
        String name = tfName.getText();
        if (name == null || name.equals("")) {
            tfMessage.setText("Please enter your name.");
        } else {
            this.name = name;
            gameInstance = new NumberGuessGame(name, MIN, MAX);
            tfMessage.setText("Hello " + name + ". Your game is ready for your input.");
        }
    }

    /**
     * Takes the guess from the guess TextField, verifies it and prints feedback in the message TextField
     * If the guess was correct it calls the endGame method to end the game
     */
    private void giveAGuess() {
        if (gameInstance == null) {
            tfMessage.setText("Please start a new game first.");
            return;
        }
        try {
            guess = Integer.parseInt(tfGuess.getText());
        } catch (Exception exc) {
            tfMessage.setText("Please enter a number.");
            return;
        }

        tfGuess.setText("");

        String guessMessage = gameInstance.oneGuessGetMessage(guess);
        String guessMessageField = this.name + "; Attempt #" + gameInstance.getNumberOfAttempts() + ": " + guess + " => " + guessMessage;
        tfMessage.setText(guessMessageField);

        //if won end game
        if (gameInstance.isWon()) {
            endGame();
        }
    }

    /**
     * Writes Data of the active game in scores.txt and ends the active game through deleting the  current instance of it
     */
    private void endGame() {
        String fileWritingErrorMessage = AppendStringToFile.appendStringToFile_WithErrorDescription("scores.txt", this.name + ";" + gameInstance.getNumberOfAttempts() + ";" + gameInstance.getNumber());
        System.out.println(fileWritingErrorMessage);
        gameInstance = null;
    }

    /**
     * Gets Data from scores.txt, searches for data with lowest number of attempts and prints it in the Message TextField
     */
    private void printBestPlayer() {
        //Get Data
        String[][] array = DataFileToArray.getStringArrayOfDataFileWithDelimiter("scores.txt", ';');
        if (array == null) {
            tfMessage.setText("Error: Corrupted or missing file");
        } else {
            //Get best run with lowest number of attempts (Name|Attempts|SearchedNumber)
            String[] bestScore = Biggest.getBiggestEntryInStringMatrix(array, 2);
            if (bestScore == null) {
                tfMessage.setText("Error: Corrupted dataset");
            } else {
                //prints best run in message TextField
                tfMessage.setText(bestScore[0] + " found number " + bestScore[2] + " with only " + bestScore[1] + " tries.");
            }
        }
    }

    private JPanel getHeaderComponents() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Player Name"));
        tfName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startNewGame();
            }
        });
        panel.add(tfName);
        return panel;
    }

    private JPanel getCenterComponents() {
        JPanel panel = new JPanel(new GridLayout(2, 1));

        JPanel enterNumberPanel = new JPanel();
        enterNumberPanel.add(new JLabel("Enter number between " + MIN + " and " + MAX));
        tfGuess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                giveAGuess();
            }
        });
        enterNumberPanel.add(tfGuess);

        JPanel buttonsPanel = new JPanel();
        for (int i = 0; i <= 3; i++) {
            JButton button = new JButton(BUTTON_LABELS[i]);
            button.addActionListener(this);
            buttonsPanel.add(button);
        }

        panel.add(enterNumberPanel);
        panel.add(buttonsPanel);

        return panel;
    }

    private JPanel getFooterComponents() {
        JPanel panel = new JPanel();
        tfMessage.setEnabled(false);
        tfMessage.setDisabledTextColor(Color.decode("#000000"));
        panel.add(tfMessage);
        return panel;
    }

    /**
     * Instantiate a new Game Frame
     */
    public static void main(String[] args) {
        new NumberGuess();
    }
}

///////////////////////////////////////////////////////////////////////////
// Class GameInstance
///////////////////////////////////////////////////////////////////////////

class NumberGuessGame {
    private String name;
    private int numberOfAttempts;
    private int number;
    private boolean won;

    /**
     * Constructor for new Game
     * @param name name of current player
     * @param min lowest possible number
     * @param max highest possible number
     */
    public NumberGuessGame(String name, int min, int max) {
        this.name = name;
        this.numberOfAttempts = 0;
        this.number = Random.RandomIntIncMinIncMax(min, max);
        this.won = false;
    }

    /**
     * Takes one guess, compares it to right number and returns lower/right/greater
     *
     * @param guess guess given by player
     * @return int: -1:guess &lt number 0:guess=number 1:guess &gt number
     */
    public int oneGuess(int guess) {
        numberOfAttempts++;
        if (guess < number) {
            return -1;
        } else if (guess == number) {
            won = true;
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * Takes one guess, compares it to right number and returns lower/right/greater
     * @param guess guess given by player
     * @return returns short descriptive comparison between guess and the right number
     */
    public String oneGuessGetMessage(int guess) {
        switch (oneGuess(guess)) {
            case -1:
                return "too small";
            case 0:
                return "right";
            default:
                return "too big";
        }
    }

    public String getName() {
        return name;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

    public int getNumber() {
        return number;
    }

    public boolean isWon() {
        return won;
    }
}