package dev.lyze.gamejammarch2021.lyze;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import dev.lyze.gamejammarch2021.lyze.animations.LyzeIdleAnimation;
import dev.lyze.gamejammarch2021.lyze.animations.LyzeWalkAnimation;
import dev.lyze.gamejammarch2021.lyze.states.LyzeStateMachine;
import dev.lyze.gamejammarch2021.lyze.states.data.LyzeData;
import dev.lyze.gamejammarch2021.lyze.states.grounded.LyzeIdleState;
import dev.lyze.gamejammarch2021.lyze.states.grounded.LyzeMoveState;
import dev.lyze.gamejammarch2021.utils.Logger;
import lombok.Getter;
import space.earlygrey.shapedrawer.ShapeDrawer;

public class Lyze
{
    private static final Logger<Lyze> logger = new Logger<>(Lyze.class);

    private final LyzeData data;

    @Getter
    private final LyzeStateMachine stateMachine = new LyzeStateMachine();
    @Getter
    private final LyzeIdleState idleState;
    @Getter
    private final LyzeMoveState moveState;

    @Getter
    private final LyzeInputHandler inputHandler = new LyzeInputHandler();

    @Getter
    private int facingDirection = 1;

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

    public void debugRender(ShapeDrawer drawer)
    {
        stateMachine.getCurrentState().debugRender(drawer);
    }

    public void setVelocityX(float velocity)
    {

    }

    public void checkIfShouldFlip(float xInput)
    {
        if (xInput > 0 && facingDirection != 1f)
            flip();
        else if (xInput < 0 && facingDirection != -1f)
            flip();
    }

    private void flip()
    {
        logger.logDebug("flip character");
        facingDirection *= -1;
    }
}
