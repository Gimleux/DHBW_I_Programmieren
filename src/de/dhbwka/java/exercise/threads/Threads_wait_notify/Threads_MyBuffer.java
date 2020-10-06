package de.dhbwka.java.exercise.threads.Threads_wait_notify;

public class Threads_MyBuffer {
    private int value;
    private boolean empty = true;

    // the producer routine
    //---------------------
    public synchronized void put(int v) {
        if (!this.empty) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
    // buffer is empty, fill it!
        this.value = v;
        this.empty = false;
    // notify waiting consumer
        this.notify();
        System.out.println("Put: " + v);
    }

    // the consumer routine
    //---------------------
    public synchronized int get() {
        int v;
        if (this.empty) {
            // consumer must wait until buffer is full
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        // buffer is full, empty it!
        v = this.value;
        this.empty = true;
        // notify waiting producer
        this.notify();
        System.out.println("Get:" + v);
        return v;
    }
}
