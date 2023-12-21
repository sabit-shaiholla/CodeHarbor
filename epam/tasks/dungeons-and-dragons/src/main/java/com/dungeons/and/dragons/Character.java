package com.dungeons.and.dragons;

import java.util.List;

public class Character implements Fightable, SpellCaster {
    private String name;
    private int healthPoints;
    private int level;
    private int experiencePoints;
    private CharacterClass characterClass;
    private List<Item> inventory;

    public Character(String name, CharacterClass characterClass) {
        this.name = name;
        this.characterClass = characterClass;
        // Initializing other attributes
    }

    public void levelUp() {
        // Implementation
    }

    public void gainExperience() {
        // Implementation
    }

    public void equip(Item item) {
        if (item instanceof Weapon) {
            attack();
        } else if (item instanceof Armor) {
            defend();
        }
        // Other equip logic for different item types
    }

    public void attack() {
        // Implementation
    }

    public void defend() {
        // Implementation
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

    public void castSpell(Creature target) {
        // Implementation
    }

    public void learnSpell(Spell spell) {
        // Implementation
    }
}
