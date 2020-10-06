package de.dhbwka.java.exercise.threads.Threads_wait_notify;

public class Threads_ProducerThread extends Thread {
    Threads_MyBuffer buf;

    public Threads_ProducerThread(Threads_MyBuffer buf) {
        this.buf = buf;
    }
    public void run() {
        this.buf.put(5);
        this.buf.put(6);
    }
}
