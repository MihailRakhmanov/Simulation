package main.java.entities.stationary;

import main.java.entities.Entity;

public class Rock extends Entity {

    public Rock() {
        super.chanceSpawn = 0.1f;
        super.enrichmentPoint = 0.1f;
    }

    @Override
    public Entity spawnEntity() {
        return new Rock();
    }
}
