package de.dhbwka.java.exercise.exam.SpeedyQuiz;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.*;

import static java.util.stream.Collectors.toList;

public class Game implements Runnable {
    ArrayList<Question> selectedQuestion= new ArrayList<>();
    ArrayList<GameClient> clients= new ArrayList<>();
    boolean started=false;
    int QuestionsCount;
    int currQuestion=0;
    Date startTime;
    int seconds;
    Thread runner;

    public Game(List<Question> questionPool, int i) throws GameException {

        if (questionPool.size()<i){
            throw new GameException("Too few questions available“");
        }

        QuestionsCount=i;
        Random random = new Random();
        Set<Question> selectedQuestionSet= new HashSet<>();
        do {
            selectedQuestionSet.add(questionPool.get(random.nextInt(i)));

        }
        while (selectedQuestionSet.size()<i);


        selectedQuestion.addAll(selectedQuestionSet.stream().collect(toList()));

    }

    public void registerClient(GameClient client){
        if (!started){
            clients.add(client);
        }

    }

    public boolean isStarted() {
        return started;
    }

    public int getQuestionsCount() {
        return QuestionsCount;
    }


    public void startGame(){
        started=true;
        startTime=new Date();
        seconds=10;

        for (int i = 0; i <clients.size() ; i++) {
            clients.get(i).setQuestion(currQuestion,selectedQuestion.get(currQuestion));
        }


        runner=new Thread(this);
        runner.start();
    }


    public void answerSelected(GameClient client, int index){

        System.out.println(index);
        System.out.println(selectedQuestion.get(currQuestion).correctIndex+"a");

        client.setAnswerState(currQuestion,selectedQuestion.get(currQuestion).correctIndex==index? GameClient.STATUS.CORRECT: GameClient.STATUS.WRONG);

        for (int i = 0; i <clients.size() ; i++) {
            if (clients.get(i)!=client){
                clients.get(i).setAnswerState(currQuestion, GameClient.STATUS.NO_ANSWER);
            }
        }
        nextQuestion();
    }

    public void nextQuestion(){
        System.out.println("nextQuestion called");
        currQuestion++;
        seconds=10;



        if (currQuestion+1>QuestionsCount){
            int seconds =Math.round(new Date().getTime()/1000-startTime.getTime()/1000);
            System.out.println(startTime.getTime());
            StringBuilder stringBuilder=new StringBuilder("Game finished after"+seconds+"seconds,score: ");
            for (int i = 0; i < clients.size(); i++) {
                stringBuilder.append(clients.get(i).getPlayerName()+" ("+clients.get(i).getPoints()+") ");
                clients.get(i).gameIsOver();
            }
            final String filename= "quiz.txt";
            File newFile = new File(filename);
            File parent = newFile.getParentFile();
            try {
                if (parent != null && !parent.exists() && !parent.mkdirs()) {
                    System.out.println("Ordner konnten nicht erstellt werden: " + filename);
                    return;
                }
                if (!newFile.exists() && !newFile.createNewFile()) {
                    System.out.println("Datei existiert schon, oder konnt nicht erstellt werden: " + filename);
                    return;
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            try (BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("quizz.txt",true))){
                bufferedWriter.write(stringBuilder.toString()+"\n");

            } catch (IOException e) {
                e.printStackTrace();
            }

            seconds=0;
            started=false;

            JOptionPane.showMessageDialog(null, stringBuilder.toString(),"Ergebnis" +
                    "", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            for (int i = 0; i < clients.size(); i++) {
                clients.get(i).setQuestion(currQuestion, selectedQuestion.get(currQuestion));
            }
            //currQuestion++;
        }
    }

    @Override
    public void run() {

        while (started){
            while (seconds>0){

                try {
                    Thread.sleep(1000);
                    seconds--;

                    for (int i = 0; i <clients.size() ; i++) {
                        clients.get(i).setRemainingSeconds(seconds);
                    }

                }
                catch (Exception e){}

            }
            if (seconds==0) {
                System.out.println(currQuestion);
                for (int i = 0; i < clients.size(); i++) {
                    clients.get(i).setAnswerState(currQuestion, GameClient.STATUS.NO_ANSWER);



                }
                nextQuestion();
            }

        }
    }
}