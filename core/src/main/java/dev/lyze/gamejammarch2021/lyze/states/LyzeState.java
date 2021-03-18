package dev.lyze.gamejammarch2021.lyze.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import dev.lyze.gamejammarch2021.lyze.Lyze;
import dev.lyze.gamejammarch2021.lyze.animations.LyzeAnimation;
import dev.lyze.gamejammarch2021.lyze.states.data.LyzeData;
import dev.lyze.gamejammarch2021.utils.Logger;

public class LyzeState
{
    protected final Logger<LyzeState> logger;

    protected Lyze lyze;
    protected LyzeStateMachine stateMachine;

    protected LyzeData lyzeData;

    protected float startTime;

    private LyzeAnimation animation;

    public LyzeState(Lyze lyze, LyzeStateMachine stateMachine, LyzeData lyzeData, LyzeAnimation animation)
    {
        logger = new Logger<>(this);

        this.lyze = lyze;
        this.stateMachine = stateMachine;
        this.lyzeData = lyzeData;
        this.animation = animation;
    }

    public void enter()
    {
        logger.logDebug("state enter");
        startTime = System.currentTimeMillis();

        doChecks();
    }

    public void logicUpdate(float delta)
    {

    }

    public void physicsUpdate(float delta)
    {
        doChecks();
    }

    public void render(SpriteBatch batch)
    {
        animation.render(batch, startTime);
    }

    public void doChecks()
    {

    }

    public void exit()
    {
        logger.logDebug("state exit");
    }
}
