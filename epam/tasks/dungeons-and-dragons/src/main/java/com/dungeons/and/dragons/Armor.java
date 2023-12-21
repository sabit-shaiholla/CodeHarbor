package com.dungeons.and.dragons;

public class Armor extends Item{
    private int defensePoints;
    private String armorName;
    private String description;
    private double weight;

    public Armor(String armorName, String description, double weight, int defensePoints) {
        this.armorName = armorName;
        this.description = description;
        this.weight = weight;
        this.defensePoints = defensePoints;
    }

    @Override
    public void use() {
        // Implementation for wearing the armor
        // This method could modify the character's attributes based on the armor
    }
}
