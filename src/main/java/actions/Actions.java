package main.java.actions;

import main.java.map.Cell;
import main.java.map.WorldMap;

public abstract class Actions {
    protected WorldMap map;
    int sizeOfMap;

    public Actions(WorldMap map){
        this.map = map;
        sizeOfMap = map.getMapSize();
    }

    public Cell getEmptyRandomCoordinates(WorldMap map){
        while (true) {
            int x = (int) (Math.random() * map.getMapWidth());
            int y = (int) (Math.random() * map.getMapHeight());
            Cell cell = new Cell(x,y);
            if (map.isEmptyCell(cell) && map.isInsideMapBorder(cell)) {
                return cell;
            }
        }
    }
}
