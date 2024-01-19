package main.java.entities.stationary;

import main.java.entities.Entity;

public class Grass extends Entity {
    public Grass() {
        this.chanceSpawn = 0.15f;
        this.enrichmentPoint = 0.12f;
    }

    @Override
    public Entity spawnEntity() {
        return new Grass();
    }
}
