package de.dhbwka.java.exercise.exam.SpeedyQuiz;

import java.awt.*;

public interface GameClient {




    public String getPlayerName();

    public int getPoints();


    public void setQuestion(int questionIndex, Question q);

    public void setRemainingSeconds(int seconds);
    public void gameIsOver();
    public void setAnswerState(int questionIndex, STATUS status);

    enum STATUS{


        ACTIVE(Color.ORANGE,0),
        CORRECT(Color.GREEN,1),
        WRONG(Color.RED,-1),
        PENDING(Color.WHITE,0),
        NO_ANSWER(Color.GRAY,0);

        Color color;
        int i;

        STATUS(Color c, int i){
            color=c;
            this.i = i;
        }
    }
}