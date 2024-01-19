package main.java.entities;

public abstract class Entity <T extends Entity>{
    protected float chanceSpawn;
    protected float enrichmentPoint;
    protected static int test;

    public float getChanceSpawn() {
        return chanceSpawn;
    }

    public float getEnrichmentPoint() {
        return enrichmentPoint;
    }

    public abstract T spawnEntity();
}
