package de.dhbwka.java.exercise.threads.Threads_wait_notify;

public class Threads_BufferTest {
    public static void main(String[] args) {
        Threads_MyBuffer buf = new Threads_MyBuffer();

        Threads_ProducerThread thread1 = new Threads_ProducerThread(buf);
        thread1.start();

        Threads_ConsumerThread thread2 = new Threads_ConsumerThread(buf);
        thread2.start();
    }
}
