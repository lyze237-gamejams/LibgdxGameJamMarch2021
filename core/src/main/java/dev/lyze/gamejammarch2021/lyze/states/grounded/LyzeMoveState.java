package dev.lyze.gamejammarch2021.lyze.states.grounded;

import dev.lyze.gamejammarch2021.lyze.Lyze;
import dev.lyze.gamejammarch2021.lyze.animations.LyzeAnimation;
import dev.lyze.gamejammarch2021.lyze.states.LyzeStateMachine;
import dev.lyze.gamejammarch2021.lyze.states.data.LyzeData;

public class LyzeMoveState extends LyzeGroundedState
{
    public LyzeMoveState(Lyze lyze, LyzeStateMachine stateMachine, LyzeData lyzeData, LyzeAnimation animation)
    {
        super(lyze, stateMachine, lyzeData, animation);
    }

    @Override
    public void logicUpdate(float delta)
    {
        super.logicUpdate(delta);

        if (input.x == 0)
            stateMachine.changeState(lyze.getIdleState());

        lyze.setVelocityX(input.x /* * ...*/);
    }
}
