package dev.lyze.gamejammarch2021.lyze;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import dev.lyze.gamejammarch2021.lyze.animations.LyzeIdleAnimation;
import dev.lyze.gamejammarch2021.lyze.animations.LyzeWalkAnimation;
import dev.lyze.gamejammarch2021.lyze.states.LyzeStateMachine;
import dev.lyze.gamejammarch2021.lyze.states.data.LyzeData;
import dev.lyze.gamejammarch2021.lyze.states.grounded.LyzeIdleState;
import dev.lyze.gamejammarch2021.lyze.states.grounded.LyzeMoveState;
import lombok.Getter;

public class Lyze
{
    private final LyzeData data;

    @Getter
    private final LyzeStateMachine stateMachine = new LyzeStateMachine();
    @Getter
    private final LyzeIdleState idleState;
    @Getter
    private final LyzeMoveState moveState;

    @Getter
    private final LyzeInputHandler inputHandler = new LyzeInputHandler();


    public Lyze()
    {
        data = new LyzeData();

        idleState = new LyzeIdleState(this, stateMachine, data, new LyzeIdleAnimation(data.getBodyParts()));
        moveState = new LyzeMoveState(this, stateMachine, data, new LyzeWalkAnimation(data.getBodyParts()));

        stateMachine.initialize(idleState);
    }

    public void update(float delta)
    {
        inputHandler.update(delta);

        stateMachine.getCurrentState().logicUpdate(delta);
        stateMachine.getCurrentState().physicsUpdate(delta);
    }

    public void render(SpriteBatch batch)
    {
        stateMachine.getCurrentState().render(batch);
    }

    public void setVelocityX(float velocity)
    {

    }
}
