package com.thecoderscorner.example.algorthym.collections;

/**
 * This is a simple single sided linked list that can act like a queue. It is not
 * fully implemented, but should give the basic idea of how to proceed with the
 * rest of methods needed.
 */
public class LinkedList {
    private ListNode head;
    private ListNode tail;

    public void insertAtBeginning(String nodeName) {
        if(head==null) {
            head = new ListNode(nodeName);
            tail = head;
        }
        else {
            ListNode node = new ListNode(nodeName);
            head.setPrev(node);
            node.setNext(head);
            head = node;
        }
    }

    public String removeFromEnd() {
        if(tail == null) {
            throw new UnsupportedOperationException("remove on empty list");
        }
        ListNode node = tail;
        tail = node.getPrev();
        if(tail == null) {
            head = null;
        }
        return node.getNodeName();
    }

    @Override
    public String toString() {
        if(head == null) {
            return "Empty";
        }

        StringBuilder sb = new StringBuilder(1024);
        ListNode node;
        sb.append("LinkedList: [");
        while(( node = head.getNext()) != null) {
            sb.append(node.getNodeName());
            if(node.getNext() != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private class ListNode {
        private ListNode next;
        private ListNode prev;
        private String nodeName;

        public ListNode(String nodeName) {
            this.nodeName = nodeName;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        public ListNode getPrev() {
            return prev;
        }

        public void setPrev(ListNode prev) {
            this.prev = prev;
        }

        public String getNodeName() {
            return nodeName;
        }
    }
}
