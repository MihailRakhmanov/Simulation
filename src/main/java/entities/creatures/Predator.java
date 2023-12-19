package main.java.entities.creatures;

public class Predator extends Creature{
    private static final int damage = 2;
    private Herbivore victim;


    public Predator() {
        super.chanceSpawn = 0.03f;
        super.enrichmentPoint = 0.01f;
        super.setSpeed(2);
        super.setHp(3);
        super.setSatiety(5);
    }

    @Override
    public void makeMove() {

    }

}
