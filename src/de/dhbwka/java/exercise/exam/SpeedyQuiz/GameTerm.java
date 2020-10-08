package de.dhbwka.java.exercise.exam.SpeedyQuiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameTerm implements GameClient {

    String name;
    Game game;
    int points=0;
    Question question;
    int questionIndex;
    STATUS status;
    int remainingSeconds;
    ArrayList<STATUS> questionStatuses=new ArrayList<>();
    boolean finished=false;


    JFrame frame;
    final JPanel panel=new JPanel(new BorderLayout(16,8));
    JPanel nordpanel=new JPanel();
    JPanel centerpanel=new JPanel(new BorderLayout());
    JPanel buttompanel=new JPanel(new GridLayout(2,2));
    JLabel secondsLabel;


    public GameTerm(String name, Game game) {
        this.name=name;
        this.game=game;



        frame=new JFrame(name);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //  frame.pack();
        frame.setVisible(true);

        frame.add(nordpanel,BorderLayout.NORTH);
        frame.add(centerpanel,BorderLayout.CENTER);
        frame.add(buttompanel,BorderLayout.SOUTH);


        for (int i = 0; i < game.getQuestionsCount(); i++) {
            questionStatuses.add(STATUS.PENDING);
        }

        redraw();


    }

    void redraw(){

        nordpanel.removeAll();
        for (int i = 0; i < game.getQuestionsCount(); i++) {
            nordpanel.add(new QuestionNumberLabel(String.valueOf(i+1),questionStatuses.get(i)),i);
        }
        centerpanel.removeAll();

        buttompanel.removeAll();

        if (question!=null && !finished){

            centerpanel.add(new JLabel(question.questionText));

            secondsLabel=new JLabel(String.valueOf(remainingSeconds));
            centerpanel.add(secondsLabel,BorderLayout.SOUTH);

            JButton button;
            for (int i = 0; i < 4; i++) {

                button = new JButton(question.answers[i]);
                int finalI = i;
                GameClient gameClientTemp = this;
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        game.answerSelected(gameClientTemp, finalI);
                    }
                });
                buttompanel.add(button);
            }

        }


        frame.pack();



    }


    @Override
    public String getPlayerName() {
        return name;
    }

    @Override
    public int getPoints() {
        return Math.max(points, 0);
    }

    @Override
    public void setQuestion(int questionIndex, Question q) {
        this.question= q;
        this.questionIndex= questionIndex;
        status=STATUS.ACTIVE;
        remainingSeconds=10;
        redraw();
    }

    @Override
    public void setRemainingSeconds(int seconds) {
        remainingSeconds=seconds;
        secondsLabel.setText(String.valueOf(seconds));
    }

    @Override
    public void gameIsOver() {
        System.out.println("ende");
        finished=true;
        redraw();

    }

    @Override
    public void setAnswerState(int questionIndex, STATUS status) {
        if (status.equals(STATUS.CORRECT)){
            points++;
        }
        else if (status.equals(STATUS.WRONG)){
            points--;
        }

        questionStatuses.add(questionIndex,status);
        redraw();
    }
}