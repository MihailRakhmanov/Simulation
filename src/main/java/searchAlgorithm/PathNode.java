package main.java.searchAlgorithm;

import main.java.map.Cell;

public class PathNode extends Cell {
    private int pathWeight = 0;

    public PathNode(int x, int y) {
        super(x, y);
    }

    public PathNode(Cell cell){
        super(cell.getX(), cell.getY());
    }

    public int getPathWeight() {
        return pathWeight;
    }

    public void setPathWeight(int pathWeight) {
        this.pathWeight = pathWeight;
    }

    @Override
    public String toString() {
        return "PathNode{" +
                "x=" + getX() +
                ", y=" + getY() +
                ", pathWeight=" + pathWeight +
                '}';
    }
}
