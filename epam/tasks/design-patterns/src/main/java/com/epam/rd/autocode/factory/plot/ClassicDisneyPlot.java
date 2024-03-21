package com.epam.rd.autocode.factory.plot;

public class ClassicDisneyPlot implements Plot{
    private final Character hero;
    private final Character beloved;
    private final Character villain;

    public ClassicDisneyPlot(Character hero, Character beloved, Character villain) {
        this.hero = hero;
        this.beloved = beloved;
        this.villain = villain;
    }

    @Override
    public String toString() {
        return String.format(
                "%s is great. %s and %s love each other. %s interferes with their happiness but loses in the end.",
                hero.name(), hero.name(), beloved.name(), villain.name()
        );
    }
}
