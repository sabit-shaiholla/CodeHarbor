package com.dungeons.and.dragons;

public interface Fightable {
    public void attack();
    public void defend();
    public boolean isAlive();
    public int getHealth();
    public int getAttack();
    public int getDefense();
}
