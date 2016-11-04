package Graph;

import java.util.Arrays;

public class MatrixGraph  implements Graph {
    boolean[][] graph;
    int vNum;

    MatrixGraph(int num) {
        vNum = num;
        graph = new boolean[vNum][vNum];
    }

    MatrixGraph() {
        this(1);
    }

    @Override
    public void addEdge(int v, int w) {
        graph[v-1][w-1] = true;
        graph[w-1][v-1] = true;
    }

    @Override
    public void addVertex() {
        vNum++;
        graph = Arrays.copyOf(graph, vNum);
        graph[vNum] = new boolean[vNum];
        for (int i = 0; i < vNum - 1; i++) {
            graph[i] = Arrays.copyOf(graph[i], vNum);
        }
    }

    @Override
    public void printGraph() {
        for (int i = 0; i < vNum; i++) {
            for (int j = 0; j < vNum; j++) {
                if (graph[i][j]){
                    System.out.println((i + 1) + " " + (j + 1));
                }
            }
        }
    }

    @Override
    public void removeEdge(int v, int w) {
        graph[v-1][w-1] = false;
        graph[w-1][v-1] = false;

    }
}