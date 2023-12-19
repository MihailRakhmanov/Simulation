package main.java.searchAlgorithm;

import main.java.map.Cell;

public class PathFinder {
    private static final int PATH_COST_DIAGONAL = 14;
    private static final int PATH_COST_DIRECT = 10;

    private int heuristicDistance(Cell start, Cell finish){
        return (Math.abs(finish.getX() - start.getX()) + Math.abs(finish.getY()-start.getY())) * PATH_COST_DIRECT;
    }


}
