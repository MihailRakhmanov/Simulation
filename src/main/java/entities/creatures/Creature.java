package main.java.entities.creatures;

import main.java.entities.Entity;
import main.java.map.Cell;
import main.java.map.WorldMap;
import main.java.searchAlgorithm.PathFinder;
import main.java.searchAlgorithm.PathFinderList;
import main.java.searchAlgorithm.PathNode;

public abstract class Creature extends Entity {
    protected int speed;
    protected int hp;
    protected int satiety;
    protected static final int maxSatiety = 6;
    protected Class<? extends Entity> victim;

    public void makeMove(Cell start, WorldMap map){
        if (satiety <= 0) hp--;
        if (hp <= 0) {
            map.clearCell(start);
            return;
        }
        PathFinder pathFinder = new PathFinder(victim);
        PathNode goal = pathFinder.smellVictim(map, start);

        if (goal != null) {
            PathFinderList<PathNode> path = pathFinder.getPathToTarget(new PathNode(start), goal, map);
            if (path != null && !path.isEmpty()){
                int maxStepsPerMove = Math.min(speed, path.size());
                Cell move = new Cell(path.get(maxStepsPerMove));
                if (move.equals(goal)){
                    move = new Cell(path.get(maxStepsPerMove-1));
                }
                //Cell cellMove = new Cell(move);
                map.changeCell(start, move);
            }
        }
    }

}
