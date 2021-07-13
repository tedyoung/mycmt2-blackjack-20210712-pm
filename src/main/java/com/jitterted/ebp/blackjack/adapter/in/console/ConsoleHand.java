package com.jitterted.ebp.blackjack.adapter.in.console;

import com.jitterted.ebp.blackjack.domain.Hand;

import java.util.stream.Collectors;

import static org.fusesource.jansi.Ansi.ansi;

public class ConsoleHand {

    public static String displayFirstCard(Hand hand) {
        return ConsoleCard.display(hand.faceUpCard());
    }

    // GOAL: String cardsAsString(Hand hand) <-- TRANSFORMATION of Hand (DOMAIN) to String (CONSOLE ADAPTER)
    public static String cardsAsString(Hand hand) {
        return hand.cards().stream()
                   .map(ConsoleCard::display)
                   .collect(Collectors.joining(
                           ansi().cursorUp(6).cursorRight(1).toString()));
    }
}
