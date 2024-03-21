package com.epam.rd.autocode.factory.plot;

public class ContemporaryDisneyPlot implements Plot{
    private final Character hero;
    private final EpicCrisis epicCrisis;
    private final Character funnyFriend;

    public ContemporaryDisneyPlot(Character hero, EpicCrisis epicCrisis, Character funnyFriend) {
        this.hero = hero;
        this.epicCrisis = epicCrisis;
        this.funnyFriend = funnyFriend;
    }

    @Override
    public String toString() {
        return String.format(
                "%s feels a bit awkward and uncomfortable. But personal issues fades, when a big trouble comes - %s. %s stands up against it, but with no success at first.But putting self together and help of friends, including spectacular funny %s restore the spirit and %s overcomes the crisis and gains gratitude and respect",
                hero.name(), epicCrisis.name(), hero.name(), funnyFriend.name(), hero.name()
        );
    }
}
