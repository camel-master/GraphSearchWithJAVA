package me.dave;

import java.util.NoSuchElementException;

public class Queue<T> {
    public static class Node<T> {
        private final T data;
        private Node<T> next;

        public Node(T item) {
            this.data = item;
        }
    }

    Node<T> firstNode;
    Node<T> lastNode;

    public void add(T item) {
        Node<T> newNode = new Node<>(item);
        if(firstNode == null) {
            firstNode = newNode;
            lastNode = firstNode;
        } else {
            lastNode.next = newNode;
            lastNode = newNode;
        }
    }

    public T remove() {
        if(firstNode == null) {
            throw new NoSuchElementException();
        }
        T data = firstNode.data;
        firstNode = firstNode.next;
        return data;
    }

    public T element() {
        if(firstNode == null) {
            throw new NoSuchElementException();
        }
        return firstNode.data;
    }

    public T peek() {
        if(firstNode == null) {
            return null;
        }
        return firstNode.data;
    }

    public boolean isEmpty() {
        return firstNode == null;
    }
}
