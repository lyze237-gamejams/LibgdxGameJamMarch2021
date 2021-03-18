package dev.lyze.gamejammarch2021.lyze.states.grounded;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import dev.lyze.gamejammarch2021.lyze.Lyze;
import dev.lyze.gamejammarch2021.lyze.animations.LyzeAnimation;
import dev.lyze.gamejammarch2021.lyze.states.LyzeState;
import dev.lyze.gamejammarch2021.lyze.states.LyzeStateMachine;
import dev.lyze.gamejammarch2021.lyze.states.data.LyzeData;

public class LyzeGroundedState extends LyzeState
{
    protected Vector2 input;

    public LyzeGroundedState(Lyze lyze, LyzeStateMachine stateMachine, LyzeData lyzeData, LyzeAnimation animation)
    {
        super(lyze, stateMachine, lyzeData, animation);
    }

    @Override
    public void logicUpdate(float delta)
    {
        super.logicUpdate(delta);

        input = lyze.getInputHandler().getMovementInput();
    }
}
