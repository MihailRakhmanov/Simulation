package main.java.map;

import main.java.entities.Entity;

import java.util.HashMap;
import java.util.Map;

public class WorldMap {
    private final int mapWidth = 15;
    private final int mapHeight = 10;

    private final Map<Cell, Entity> cells = new HashMap<>();

    public int getMapSize() {
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

    public <T extends Entity> T getEntityFromCell(Cell cell){
        return (T) cells.get(cell);
    }

    public Class<? extends Entity> getTypeCell(Cell cell){
        return cells.get(cell) !=null ? cells.get(cell).getClass() : null;
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

    public boolean isInsideMapBorder(Cell cell) {
        return cell.getY() < this.mapHeight && cell.getX() < this.mapWidth;
    }

    public void clearCell(Cell cell){
        cells.remove(cell);
    }

    public void changeCell(Cell start, Cell move){
        setEntityInCell(move, getEntityFromCell(start));
        clearCell(start);
    }
}
