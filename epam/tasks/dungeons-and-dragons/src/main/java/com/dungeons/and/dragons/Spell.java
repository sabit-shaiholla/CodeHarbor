package com.dungeons.and.dragons;

public class Spell {
    private String spellName;
    private String description;
    private int damagePoints;

    public Spell(String spellName, String description, int damagePoints) {
        this.spellName = spellName;
        this.description = description;
        this.damagePoints = damagePoints;
    }

    public void cast(Creature target) {
        // Implementation for casting the spell
    }
}
