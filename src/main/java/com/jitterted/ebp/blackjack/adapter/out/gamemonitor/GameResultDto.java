package com.jitterted.ebp.blackjack.adapter.out.gamemonitor;

import com.jitterted.ebp.blackjack.domain.Game;

public class GameResultDto {
    private String playerName;
    private String outcome;
    private String playerHandValue;
    private String dealerHandValue;

    public static GameResultDto from(Game game) {
        GameResultDto gameResultDto = new GameResultDto(
                "Ted",
                game.determineOutcome().displayValue(),
                String.valueOf(game.playerHand().value()),
                String.valueOf(game.dealerHand().value()));
        return gameResultDto;
    }

    public GameResultDto(String playerName, String outcome, String playerHandValue, String dealerHandValue) {
        this.playerName = playerName;
        this.outcome = outcome;
        this.playerHandValue = playerHandValue;
        this.dealerHandValue = dealerHandValue;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getOutcome() {
        return outcome;
    }

    public String getPlayerHandValue() {
        return playerHandValue;
    }

    public String getDealerHandValue() {
        return dealerHandValue;
    }
}
