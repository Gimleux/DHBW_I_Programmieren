package de.dhbwka.java.exercise.exam.SpeedyQuiz;

import javax.swing.*;

public class QuestionNumberLabel extends JLabel {

    GameClient.STATUS status= GameClient.STATUS.PENDING;

    public QuestionNumberLabel(String text, GameClient.STATUS status) {
        super(text);
        this.status=status;
        this.setOpaque(true);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setBackground(status.color);

    }
}