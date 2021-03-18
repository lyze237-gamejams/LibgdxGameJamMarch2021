package dev.lyze.gamejammarch2021.lyze.states.grounded;

import dev.lyze.gamejammarch2021.lyze.Lyze;
import dev.lyze.gamejammarch2021.lyze.animations.LyzeAnimation;
import dev.lyze.gamejammarch2021.lyze.states.LyzeStateMachine;
import dev.lyze.gamejammarch2021.lyze.states.data.LyzeData;

public class LyzeIdleState extends LyzeGroundedState
{
    public LyzeIdleState(Lyze lyze, LyzeStateMachine stateMachine, LyzeData lyzeData, LyzeAnimation animation)
    {
        super(lyze, stateMachine, lyzeData, animation);
    }
}
