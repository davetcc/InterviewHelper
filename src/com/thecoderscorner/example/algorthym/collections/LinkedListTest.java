package com.thecoderscorner.example.algorthym.collections;

/**
 * Created by dave_000 on 11/12/2016.
 */
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        for (int i=0;i<10;++i) {
            linkedList.insertAtBeginning("Node" + i);
        }

        linkedList.toString();
    }
}
