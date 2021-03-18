package dev.lyze.gamejammarch2021.lyze.states;

import lombok.Getter;

public class LyzeStateMachine
{
    @Getter
    private LyzeState currentState;

    public void initialize(LyzeState startingState)
    {
        currentState = startingState;

        currentState.enter();
    }

    public void changeState(LyzeState newState)
    {
        currentState.exit();

        currentState = newState;

        currentState.enter();
    }
}
