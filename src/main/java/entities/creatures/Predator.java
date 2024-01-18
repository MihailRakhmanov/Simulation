package main.java.entities.creatures;

import main.java.map.Cell;
import main.java.map.WorldMap;
import main.java.searchAlgorithm.PathFinder;

public class Predator extends Creature{
    private static final int damage = 2;


    public Predator() {
        chanceSpawn = 0.03f;
        enrichmentPoint = 0.01f;
        speed = 2;
        hp = 3;
        satiety = 5;
        victim = Herbivore.class;
    }


    @Override
    public void makeMove(Cell start, WorldMap map) {
        for (Cell neighbor : PathFinder.findNeighbors(start)){
            if (map.getTypeCell(neighbor) == Herbivore.class){
                Herbivore herbivore = map.getEntityFromCell(neighbor);

                herbivore.hp -= damage;
                System.out.println("Мышь получила урон: " + neighbor.toString());
                if (herbivore.hp <= 0){
                    map.clearCell(neighbor);
                    System.out.println("Мышь съедена: " + neighbor.toString());
                    hp++;
                    satiety = Math.min(satiety + 3, maxSatiety);
                }
                return;
            }
        }
        satiety--;
        super.makeMove(start, map);
    }
}
