package Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class LinkedGraph implements Graph {
    private ArrayList<Integer>[] graph;
    private int vNum;

    LinkedGraph(int num) {
        vNum = num;
        graph = new ArrayList[vNum];
        for (int i = 0; i < vNum; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    LinkedGraph() {
        this(1);
    }

    @Override
    public void addEdge(int v, int w) {
        graph[v-1].add(w-1);
        graph[w-1].add(v-1);
    }

    @Override
    public void addVertex() {
        graph = Arrays.copyOf(graph, vNum + 1);
        graph[vNum] = new ArrayList<>();
        ++vNum;
    }

    @Override
    public void printGraph() {
        for (int i = 0; i < vNum; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                System.out.println((i + 1) + " " + (graph[i].get(j) + 1));
            }
        }
    }

    @Override
    public void removeEdge(int v, int w) {
        graph[v-1].remove(w-1);
        graph[w-1].remove(v-1);
    }
}