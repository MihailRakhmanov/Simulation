package main.java.searchAlgorithm;

import main.java.entities.Entity;
import main.java.map.Cell;
import main.java.map.WorldMap;

import java.util.*;

public class PathFinder {
    private static final int PATH_WEIGHT_DIAGONAL = 14;
    private static final int PATH_WEIGHT_DIRECT = 10;
    private final Class<? extends Entity> victim;

    public PathFinder(Class<? extends Entity> victim) {
        this.victim = victim;
    }

    public PathFinderList<PathNode> getPathToTarget(PathNode start, PathNode target, WorldMap map){
        PriorityQueue<PathFinderList<PathNode>> openPathNodeLists = new PriorityQueue<>();
        Map<PathNode, Integer> openList = new HashMap<>();
        openList.put(start, 0);

        PathFinderList<PathNode> firstWay = new PathFinderList<>();
        firstWay.add(start);
        openPathNodeLists.add(firstWay);

        while(!openPathNodeLists.isEmpty()){
            PathFinderList<PathNode> currentPath = openPathNodeLists.poll();
            if(currentPath == null || currentPath.isEmpty()) {
                return null;
            }
            PathNode currentNode = currentPath.get(currentPath.size()-1);
            if(currentNode.equals(target)) {
                return currentPath;
            }

            for (Cell nextCell: findNeighbors(currentNode)){
                PathNode nextNode = new PathNode(nextCell);

                int newWeight = openList.get(currentNode) + weightOfMovingToNeighborPathNode(currentNode, nextNode);
                // Ходить только по пустым клеткам
                if((map.isEmptyCell(nextCell) || map.getTypeCell(nextCell)==victim) && map.isInsideMapBorder(nextCell)){
                    if(!openList.containsKey(nextNode) || newWeight < openList.get(nextNode)){
                        openList.put(nextNode, newWeight);
                        nextNode.setPathWeight(newWeight + heuristicDistance(nextNode, target));

                        PathFinderList<PathNode> newPath = new PathFinderList<>(currentPath);
                        newPath.add(nextNode);
                        openPathNodeLists.add(newPath);
                    }
                }
            }
        }
        return null;
    }

    private int heuristicDistance(Cell start, Cell finish){
        return (Math.abs(finish.getX() - start.getX()) + Math.abs(finish.getY()-start.getY())) * PATH_WEIGHT_DIRECT;
    }

    private int weightOfMovingToNeighborPathNode(PathNode current, PathNode neighbor){
        //int modifier = 1;

        // Прохождение через Камни, лес и траву
        /*        int modifier;
        if (map.getTypeCell(new Cell(neighbor)) == Rock.class){
            modifier = 5;
        } else if (map.getTypeCell(new Cell(neighbor)) == Tree.class || map.getTypeCell(new Cell(neighbor)) == Grass.class) {
            modifier = 2;
        } else {
            modifier = 1;
        }*/

        return neighbor.getY() != current.getY() && neighbor.getX() != current.getX()
                ? PATH_WEIGHT_DIAGONAL : PATH_WEIGHT_DIRECT;
               //? PATH_WEIGHT_DIAGONAL*modifier : PATH_WEIGHT_DIRECT*modifier;
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
        return new PathNode(closestVictimCell.getX(), closestVictimCell.getY());
        //return new PathNode(closestVictimCell);
    }

    public static List<Cell> findNeighbors(Cell current){
        List<Cell> neighbors = new ArrayList<>();
        int row = current.getY();
        int col = current.getX();
        for (int i = col-1; i<col+2; i++){
            for (int j = row - 1; j<row+2; j++){
                if ((i != col || j != row) && (i >= 0) && (j >= 0)){
                    neighbors.add(new Cell(i, j));
                }
            }
        }
        return neighbors;
    }


}
