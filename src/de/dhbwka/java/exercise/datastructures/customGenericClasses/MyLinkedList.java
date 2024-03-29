package de.dhbwka.java.exercise.datastructures.customGenericClasses;

public class MyLinkedList<T> {
    private T value;
    private MyLinkedList<T> next;

    public MyLinkedList(){

    }

    public boolean isEmpty(){
        return this.value == null;
    }

    public void add(T value){
        if (this.isEmpty()){ //letztes Element?
            this.value = value; //neues, leeres Element anhängen
            this.next = new MyLinkedList<T>();
        } else {
            this.next.add(value);
        }
    }

    public T get(int index){
        if (index < 0 || this.isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        return index == 0 ? this.value : this.next.get(index-1);
    }

    public int size(){
        return this.isEmpty() ? 0 : (this.next.size()+1);
    }
}

class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> intList = new MyLinkedList<>();
        intList.add(17);
        intList.add(25);
        intList.add(36);
        System.out.println(intList.size());
        Integer i = intList.get(1);
        System.out.println("i = " + i);
    }
}