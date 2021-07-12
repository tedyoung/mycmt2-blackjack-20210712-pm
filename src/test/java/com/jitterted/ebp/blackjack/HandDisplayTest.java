package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class HandDisplayTest {

    @Test
    public void displayFirstCard() throws Exception {
        Hand hand = new Hand(List.of(new Card(Suit.HEARTS, Rank.ACE)));

        assertThat(ConsoleHand.displayFirstCard(hand))
                .isEqualTo("[31m┌─────────┐[1B[11D│A        │[1B[11D│         │[1B[11D│    ♥    │[1B[11D│         │[1B[11D│        A│[1B[11D└─────────┘");
    }

    @Test
    public void displayCardsAsString() throws Exception {
        Hand hand = new Hand(List.of(new Card(Suit.CLUBS, Rank.FIVE),
                                     new Card(Suit.SPADES, Rank.QUEEN)));

        String display = ConsoleHand.cardsAsString(hand);

        assertThat(display)
                .isEqualTo("[30m┌─────────┐[1B[11D│5        │[1B[11D│         │[1B[11D│    ♣    │[1B[11D│         │[1B[11D│        5│[1B[11D└─────────┘[6A[1C[30m┌─────────┐[1B[11D│Q        │[1B[11D│         │[1B[11D│    ♠    │[1B[11D│         │[1B[11D│        Q│[1B[11D└─────────┘");
    }
}
