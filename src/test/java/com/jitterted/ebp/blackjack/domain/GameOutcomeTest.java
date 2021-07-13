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

    @Test
    public void playerDealtBlackjackThenOutcomeIsWinsBlackjackAndPlayerIsDone() throws Exception {
        Deck playerDealtBlackjack = new StubDeck(Rank.ACE, Rank.QUEEN,
                                                 Rank.JACK, Rank.NINE);
        Game game = new Game(playerDealtBlackjack);

        game.initialDeal();

        assertThat(game.determineOutcome())
                .isEqualTo(GameOutcome.PLAYER_WINS_BLACKJACK);
        assertThat(game.isPlayerDone())
                .isTrue();
    }

}