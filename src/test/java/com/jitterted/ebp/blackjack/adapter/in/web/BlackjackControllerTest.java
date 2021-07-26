package com.jitterted.ebp.blackjack.adapter.in.web;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BlackjackControllerTest {

    @Test
    public void startGameRedirectsToGameEndpoint() throws Exception {
        BlackjackController blackjackController = new BlackjackController();

        String redirectPage = blackjackController.startGame();

        assertThat(redirectPage)
                .isEqualTo("redirect:/game");
    }

}