package de.dhbwka.java.exercise.exam.SpeedyQuiz;

public class GameException extends Throwable {
    String message;

    public GameException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return message;
    }
}