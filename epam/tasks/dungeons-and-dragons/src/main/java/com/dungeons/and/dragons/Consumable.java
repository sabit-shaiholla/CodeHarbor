package com.dungeons.and.dragons;

public class Consumable extends Item{
    private String effect;
    private String consumableName;
    private String description;
    private double weight;

    public Consumable(String consumableName, String description, double weight, String effect) {
        this.consumableName = consumableName;
        this.description = description;
        this.weight = weight;
        this.effect = effect;
    }

    @Override
    public void use() {
        // Implementation for using the consumable item (like potions)
    }
}
