package com.epam.rd.autocode.factory.plot;

public class MarvelPlot implements Plot{
    private final Character[] heroes;
    private final EpicCrisis epicCrisis;
    private final Character villain;

    public MarvelPlot(Character[] heroes, EpicCrisis epicCrisis, Character villain) {
        this.heroes = heroes;
        this.epicCrisis = epicCrisis;
        this.villain = villain;
    }

    @Override
    public String toString() {
        String heroNames = String.join(", ", getHeroNames(heroes));
        return String.format(
                "%s threatens the world. But %s on guard. So, no way that intrigues of %s overcome the willpower of inflexible heroes",
                epicCrisis.name(), heroNames, villain.name()
        );
    }

    private String[] getHeroNames(Character[] heroes) {
        String[] heroNames = new String[heroes.length];
        for (int i = 0; i < heroes.length; i++) {
            heroNames[i] = "brave " + heroes[i].name();
        }
        return heroNames;
    }
}
