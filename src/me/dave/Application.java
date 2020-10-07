package me.dave;

public class Application {
    public static void main(String[] args) {
        /*
         *   0
         *  /
         * 1 -- 3     7
         * |  /   \  /
         * | /     5
         * 2 -- 4   \
         *           6 -- 8
         */
        testDFS();
        testDFS_Recursive();
        testBFS();
    }

    public static void testDFS() {

        Integer[] arr = {0,1,2,3,4,5,6,7,8};
        Graph<Integer> g = new Graph<>(arr);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(5, 6);
        g.addEdge(5, 7);
        g.addEdge(6, 8);

        System.out.print("DFS: ");
        g.dfs(0);
    }

    public static void testDFS_Recursive() {

        Integer[] arr = {0,1,2,3,4,5,6,7,8};
        Graph<Integer> g = new Graph<>(arr);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(5, 6);
        g.addEdge(5, 7);
        g.addEdge(6, 8);

        System.out.print("DFS Recursive: ");
        g.dfsR(0);
    }

    public static void testBFS() {

        Integer[] arr = {0,1,2,3,4,5,6,7,8};
        Graph<Integer> g = new Graph<>(arr);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(5, 6);
        g.addEdge(5, 7);
        g.addEdge(6, 8);

        System.out.print("BFS: ");
        g.bfs(0);
    }
}
