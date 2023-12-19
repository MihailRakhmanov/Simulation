package main.java.map;

import main.java.entities.Entity;

import java.util.HashMap;
import java.util.Map;

public class WorldMap {
    private final int mapWidth = 15;
    private final int mapHeight = 10;

    private final Map<Cell, Entity> cells = new HashMap<>();

    public int getSizeMap() {
        return mapHeight*mapWidth;
    }

    public int getMapWidth() {
        return mapWidth;
    }

    public int getMapHeight() {
        return mapHeight;
    }

    public boolean isEmptyCell(Cell cell){
        return !cells.containsKey(cell);
    }

    public Map<Cell, Entity> getCells() {
        return cells;
    }

    public void setEntityInCell(Cell cell, Entity entity) {
        cells.put(cell, entity);
    }

    public <T> HashMap<Cell, T> getEntitiesOfType(Class<T> typeOfEntity){
        HashMap<Cell, T> result = new HashMap<>();
        for(Map.Entry<Cell, Entity> entry: cells.entrySet()){
            if(typeOfEntity.isInstance(entry.getValue())) {
                result.put(entry.getKey(), (T) entry.getValue());
            }
        }
        return result;
    }
}
