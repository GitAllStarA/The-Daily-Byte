package Test;

import java.util.LinkedList;
import java.util.Queue;

public class Test3 {
    public static void main(String[] args) {

        int[][] graph = {
                {0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}
        };
        int[][] graph2 = {
                {0, 0, 1, 0, 0},
                {1, 0, 0, 1, 0},
                {0, 1, 0, 0, 1},
                {0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0}
        };
        System.out.println(isBipartite2(graph));
    }

/*
    public static boolean isBipartite(int[][] graph) {
        if (graph.length == 0) {
            return false;
        }

        int rows = graph.length;
        int cols = graph[0].length;

        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                queue.add(new int[]{i, j});
            }
        }
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] currentNode = queue.poll();
                int currentNodeRow = currentNode[0];
                int currentNodeCols = currentNode[1];
                for (int[] direction : directions) {
                    int newNodeRow = direction[0] + currentNodeRow;
                    int newNodeCol = direction[1] + currentNodeCols;
                    if (newNodeRow > -1 && newNodeCol > -1 && newNodeRow < rows && newNodeCol < cols && visited[newNodeRow][newNodeCol] == false) {
                        if (graph[currentNodeRow][currentNodeCols] == graph[newNodeRow][newNodeCol]) {
                            return false;
                        }
                        queue.add(new int[]{newNodeRow, newNodeCol});
                        visited[newNodeRow][newNodeCol] = true;
                    }

                }
            }
        }
        return true;
    }*/

    public static boolean isBipartite2(int[][] graph) {
        if (graph.length == 0) {
            return false;
        }

        int rows = graph.length;
        int cols = graph[0].length;


        int[] color = new int[graph.length * graph[0].length];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                queue.add(i * cols + j);
            }
        }
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int currentNode = queue.poll();
                int currentNodeRow = currentNode / cols;
                int currentNodeCols = currentNode % cols;
                for (int[] direction : directions) {
                    int newNodeRow = direction[0] + currentNodeRow;
                    int newNodeCol = direction[1] + currentNodeCols;
                    int newNextNode = newNodeRow * cols + newNodeCol;
                    if (newNodeRow > -1 && newNodeCol > -1 && newNodeRow < rows && newNodeCol < cols && color[newNextNode] == 0) {
                        color[newNextNode] = -color[currentNode];
                        queue.add(newNextNode);
                    }
                }
            }
        }
        return true;
    }
}
