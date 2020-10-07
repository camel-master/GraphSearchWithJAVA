package me.dave;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph<T> {
    public static class Node<T> {
        private final T data;
        private boolean marked; //순회한 node인지 표시할 flag
        private final LinkedList<Node<T>> adjacent;  //인접한 Node를 나열할 linkedlist
        public Node(T data) {   //node 생성 시 초기화 합니다.
            this.data = data;
            this.marked = false;
            adjacent = new LinkedList<>();
        }
    }

    private final ArrayList<Node<T>> nodes = new ArrayList<>(); //Graph의 Node들을 저장할 배열리스트를 선언합니다.
    public Graph(T[] arr) {
        for(T data : arr) {
            Node<T> newNode = new Node<>(data);
            nodes.add(newNode);
        }
    }
    public void addEdge(int i1, int i2) {  //Node 간의 관계를 설정하는 함수입니다.
        Node<T> n1 = nodes.get(i1);
        Node<T> n2 = nodes.get(i2);
        if(!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }
        if(!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }
    public void dfs(int index) {
        Node<T> root = nodes.get(index);
        Stack<Node<T>> stack = new Stack<>();
        stack.push(root);
        root.marked = true;
        while(!stack.isEmpty()) {
            Node<T> popNode = stack.pop();
            for(Node<T> n : popNode.adjacent) {
                if(!n.marked) {
                    n.marked = true;
                    stack.push(n);
                }
            }
            visit(popNode);
        }
        System.out.println();
    }

    public void dfsR(int index) {
        dfsR(nodes.get(index));
        System.out.println();
    }

    public void dfsR(Node<T> node) {
        if(node == null) return;
        node.marked = true;
        visit(node);
        for(Node<T> n : node.adjacent) {
            if(!n.marked) {
                dfsR(n);
            }
        }
    }

    public void bfs(int index) {
        Node<T> root = nodes.get(index);
        Queue<Node<T>> queue = new Queue<>();
        queue.add(root);
        root.marked = true;
        while(!queue.isEmpty()) {
            Node<T> removedNode = queue.remove();
            for(Node<T> n : removedNode.adjacent) {
                if(!n.marked) {
                    n.marked = true;
                    queue.add(n);
                }
            }
            visit(removedNode);
        }
        System.out.println();
    }

    public void visit(Node<T> n) {
        System.out.print(n.data + " ");
    }
}
