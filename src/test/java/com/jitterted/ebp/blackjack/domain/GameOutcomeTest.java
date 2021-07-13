package com.jitterted.ebp.blackjack.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GameOutcomeTest {

    @Test
    public void whenPlayerHasBetterHandThenPlayerBeatsDealer() throws Exception {
        Deck playerHasBetterHandThanDealerDeck = new StubDeck(Rank.QUEEN, Rank.EIGHT,
                                                              Rank.TEN, Rank.JACK);
        Game game = new Game(playerHasBetterHandThanDealerDeck);
        game.initialDeal();

        game.playerStands();
        game.dealerTurn();

        assertThat(game.determineOutcome())
                .isEqualTo(GameOutcome.PLAYER_BEATS_DEALER);
    }

    @Test
    public void whenPlayerHitsAndGoesBustThenOutcomeIsPlayerBusted() throws Exception {
        Deck playerHitsAndGoesBustDeck = StubDeck.playerHitsAndGoesBustDeck();
        Game game = new Game(playerHitsAndGoesBustDeck);
        game.initialDeal();

        game.playerHits();

        assertThat(game.determineOutcome())
                .isEqualTo(GameOutcome.PLAYER_BUSTED);
    }

}