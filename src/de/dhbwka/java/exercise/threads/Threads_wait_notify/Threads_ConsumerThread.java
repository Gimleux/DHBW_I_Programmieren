package de.dhbwka.java.exercise.threads.Threads_wait_notify;

public class Threads_ConsumerThread extends Thread {
    Threads_MyBuffer buffer;

    public Threads_ConsumerThread(Threads_MyBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        this.buffer.get();
    }
}
