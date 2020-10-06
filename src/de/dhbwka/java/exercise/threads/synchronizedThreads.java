package de.dhbwka.java.exercise.threads;

//Synchronized Syntax:
/*
Komplette Methode:
------------------
    synchronized Type method(...) {
        // der gesammte Rumpf ist
        // synchronisiert mit "this"
        // ...
    }

Code-Block:
-----------
    synchronized ( e ) {
        // synchronized statement:
        // Dieser Block wird
        // synchronisiert
        // mit dem Objekt, das durch
        // "e" referenziert wird ...
    }
 */

public class synchronizedThreads implements Runnable{
    String firstname;
    String surname;
    Thread runner;

    public synchronizedThreads(){
        //thread 1
        this.runner = new Thread(this);
        this.runner.start();
    }

    public synchronized void setName(String firstname, String surname) {
        this.firstname = firstname;
        this.surname = surname;
    }

    public synchronized String getName() {
        return this.firstname + " " + this.surname;
    }

    @Override
    public void run() {
        while(true){
            this.setName("Hillary","Clinton");
            this.setName("Donald","Trump");
        }
    }

    public static void main(String[] args) {
        synchronizedThreads n = new synchronizedThreads();
        //Thread 2
        while(true){
            System.out.println(n.getName());
        }
    }
}
