package com.dungeons.and.dragons;

import java.util.List;

public class Creature implements Fightable {
    private String creatureName;
    private int healthPoints;
    private int attackPoints;
    private int defensePoints;
    private List<Item> inventory;

    public Creature(String creatureName, int healthPoints, int attackPoints, int defensePoints) {
        this.creatureName = creatureName;
        this.healthPoints = healthPoints;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
    }

    public void attack() {
        // Implementation
        // This method could modify the target's (player or character)
        // attributes based on the creature's attack
    }

    public void defend() {
        // Implementation
        // This method could modify the creature's
        // attributes based on its defense
    }

    public boolean isAlive() {
        // Implementation
        return true;
    }

    public int getHealth() {
        // Implementation
        return 1;
    }

    public int getAttack() {
        // Implementation
        return 1;
    }

    public int getDefense() {
        // Implementation
        return 1;
    }
}
