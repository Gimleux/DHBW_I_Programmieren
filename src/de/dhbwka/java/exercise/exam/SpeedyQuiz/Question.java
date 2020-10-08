package de.dhbwka.java.exercise.exam.SpeedyQuiz;

public class Question {
    String questionText;
    String[] answers;
    int correctIndex;

    public Question(String questionText, String[] answers, int correctIndex) {
        this.questionText = questionText;
        this.answers = answers;
        this.correctIndex = correctIndex;
    }
}