package me.dave;

import java.util.EmptyStackException;

public class Stack<T> {
    public static class Node<T> {
        private final T data;

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        private Node<T> next;

        public Node(T item) {
            this.data = item;
        }
    }

    Node<T> top;

    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.setNext(top);   //top으로 부터 아래 쌓인 데이터 순으로 next를 이어간다.
        top = newNode;  //top을 새로 생성한 node로 교체한다.
    }
    public T peek() {
        if(top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }
    public T pop() {
        if(top == null) {
            throw new EmptyStackException();
        }
        T data = top.data;  //pop하기 전에 data 백업함
        top = top.getNext();    //top을 현재 top과 이어져 있는 다음 node로 교체한다.
        return data;    //pop한 Node의 data를 반환한다.
    }
    public Boolean isEmpty() {
        return top == null; //top이 null 즉 없으면 stack은 비어있는 것이다.
    }
}
