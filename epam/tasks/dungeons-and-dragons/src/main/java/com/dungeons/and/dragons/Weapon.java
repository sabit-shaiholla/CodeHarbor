package com.dungeons.and.dragons;

public class Weapon extends Item{
    private int damagePoints;
    private String weaponName;
    private String description;
    private double weight;

    public Weapon(String weaponName, String description, double weight, int damagePoints) {
        this.weaponName = weaponName;
        this.description = description;
        this.weight = weight;
        this.damagePoints = damagePoints;
    }

    @Override
    public void use() {
        // Implementation for using the weapon
    }
}
