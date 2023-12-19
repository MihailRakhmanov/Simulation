package main.java.entities.creatures;

import main.java.entities.stationary.Grass;

// Травоядное. Стремится найти ресурс (траву), может потратить свой ход на движение в сторону травы, либо на её поглощение.
public class Herbivore extends Creature{
    private Grass victim;

    public Herbivore() {
        super.chanceSpawn = 0.07f;
        super.enrichmentPoint = 0.04f;
        super.setSpeed(1);
        super.setHp(5);
        super.setSatiety(5);
    }

    @Override
    public void makeMove() {

    }
}
