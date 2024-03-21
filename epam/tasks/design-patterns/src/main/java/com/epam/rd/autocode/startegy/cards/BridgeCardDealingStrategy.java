package com.epam.rd.autocode.startegy.cards;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BridgeCardDealingStrategy implements CardDealingStrategy{
    private static final String PLAYER = "Player ";
    private static final int NUMBER_OF_CARDS_PLAYER_HAS = 13;
    private Map<String, List<Card>> stack;

    @Override
    public Map<String, List<Card>> dealStacks(Deck deck, int players) {
        stack = new TreeMap<>();
        putPlayersWithCards(deck, players);
        return stack;
    }

    private void putPlayersWithCards(Deck deck, int players) {
        List<Card> cards = dealCardsForPlayers(deck, players);
        IntStream.range(0, players)
                .forEach(player -> stack.put(PLAYER + (player + 1), getPlayerCards(cards, player, players)));
    }

    private List<Card> getPlayerCards(List<Card> cards, int playerIndex, int players) {
        List<Card> playerCards = new LinkedList<>();

        int cardIndex = playerIndex;
        int step = 0;
        while (cardIndex < cards.size()) {
            playerCards.add(cards.get(playerIndex + players * step));
            cardIndex += players;
            step++;
        }

        return playerCards;
    }

    private List<Card> dealCardsForPlayers(Deck deck, int players) {
        int totalCardsToDeal = players * NUMBER_OF_CARDS_PLAYER_HAS;

        return IntStream.range(0, totalCardsToDeal)
                .mapToObj(index -> deck.dealCard())
                .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}
