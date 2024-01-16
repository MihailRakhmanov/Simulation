package main.java;

import main.java.entities.Entity;
import main.java.entities.creatures.Herbivore;
import main.java.entities.creatures.Predator;
import main.java.entities.stationary.Grass;
import main.java.entities.stationary.Rock;
import main.java.entities.stationary.Tree;
import main.java.map.Cell;
import main.java.map.WorldMap;

public class Render {
    public static final String PREDATOR = "\uD83D\uDE3C";
    public static final String HERBIVORE = "\uD83D\uDC2D";
    public static final String TREE = "\uD83C\uDF33";
    public static final String ROCK = "\uD83E\uDEA8";
    public static final String GRASS = "\uD83C\uDF3D";

    public void drawMap(WorldMap map){
        //System.out.println("\033[H\033[2J");
        System.out.flush();
        System.out.println("=======================================");

        for (int i = 0; i<map.getMapHeight(); i++){
            for (int j = 0; j< map.getMapWidth(); j++){
                Class<? extends Entity> typeCell = map.getTypeCell(new Cell(j, i));

                if (typeCell == null) {
                    System.out.print(". " + "  ");
                } else if (typeCell.equals(Predator.class)) {
                    System.out.print(PREDATOR + "  ");
                } else if (typeCell.equals(Herbivore.class)) {
                    System.out.print(HERBIVORE + "  ");
                } else if (typeCell.equals(Grass.class)) {
                    System.out.print(GRASS + "  ");
                } else if (typeCell.equals(Tree.class)) {
                    System.out.print(TREE + "  ");
                } else if (typeCell.equals(Rock.class)) {
                    System.out.print(ROCK + "  ");
                }

            }
            System.out.print("\n");
        }
        System.out.println("=======================================");
    }
}
