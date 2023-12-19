package main.java.searchAlgorithm;

import main.java.entities.Entity;
import main.java.map.Cell;
import main.java.map.WorldMap;

import java.util.ArrayList;
import java.util.List;

public class PathFinder {
    private static final int PATH_COST_DIAGONAL = 14;
    private static final int PATH_COST_DIRECT = 10;
    private final Class<? extends Entity> victim;

    public PathFinder(Class<? extends Entity> victim) {
        this.victim = victim;
    }

    private int heuristicDistance(Cell start, Cell finish){
        return (Math.abs(finish.getX() - start.getX()) + Math.abs(finish.getY()-start.getY())) * PATH_COST_DIRECT;
    }

    public PathNode smellVictim(WorldMap map, Cell start){
        List<Cell> listVictimCells = new ArrayList<>(map.getEntitiesOfType(victim).keySet());
        if (listVictimCells.isEmpty()) return null;

        Cell closestVictimCell = listVictimCells.get(0);
        int minHeuristicWay = heuristicDistance(start, closestVictimCell);
        for (Cell cell : listVictimCells){
            int currentHeuristicWay = heuristicDistance(start, cell);
            if (currentHeuristicWay<minHeuristicWay){
                minHeuristicWay = currentHeuristicWay;
                closestVictimCell = cell;
            }
        }
        return new PathNode(closestVictimCell);
    }


}
