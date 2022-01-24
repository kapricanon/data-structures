package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Vertex<T> {
    private final T data;
    private boolean visited;
    private List<Vertex<T>> neighbours = new ArrayList<>();

    public Vertex (T value) {
        this.data = value;
        this.visited = false;
    }

    public void setNeighbours(List<Vertex<T>> neighbours) {
        this.neighbours = neighbours;
    }

    public List<Vertex<T>> getNeighbours() {
        return this.neighbours;
    }

    public boolean isVisited() {
        return this.visited;
    }

    public void setVisited() {
        this.visited = true;
    }

    public T getData() {
        return this.data;
    }
}

class GraphDepthFirstSearch<T> {

    public void traverse(Vertex<T> vertex) {
        vertex.setVisited();
        System.out.print(vertex.getData());
        vertex.getNeighbours().forEach(neighbour -> {
            if(!neighbour.isVisited())
                traverse(neighbour);
        });
    }
}

public class App {
    public static void main(String[] args) {
        Vertex<Integer> v0 = new Vertex<>(0);
        Vertex<Integer> v1 = new Vertex<>(1);
        Vertex<Integer> v2 = new Vertex<>(2);
        Vertex<Integer> v3 = new Vertex<>(3);
        Vertex<Integer> v4 = new Vertex<>(4);
        Vertex<Integer> v5 = new Vertex<>(5);
        Vertex<Integer> v6 = new Vertex<>(6);

        v0.setNeighbours(Arrays.asList(v1, v5, v6));
        v1.setNeighbours(Arrays.asList(v3, v4, v5));
        v4.setNeighbours(Arrays.asList(v2, v6));
        v6.setNeighbours(Arrays.asList(v0));

        GraphDepthFirstSearch<Integer> dfs = new GraphDepthFirstSearch<>();
        dfs.traverse(v0);

    }
}
