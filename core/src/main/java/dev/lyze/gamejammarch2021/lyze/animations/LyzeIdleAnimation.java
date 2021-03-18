package dev.lyze.gamejammarch2021.lyze.animations;

import com.badlogic.gdx.graphics.g2d.Animation;
import dev.lyze.gamejammarch2021.lyze.setup.LyzeBodyParts;

public class LyzeIdleAnimation extends LyzeAnimation
{
    public LyzeIdleAnimation(LyzeBodyParts bodyParts)
    {
        super(bodyParts);

        float frameDuration = parts.humanoid.humanoidTiming.stateCycle[1] / 8f; // cycle / amount of frames ?

        bodyAnimation = new Animation<>(frameDuration, parts.body.generateAnimation("idle", 1), Animation.PlayMode.LOOP);
        frontArmAnimation = new Animation<>(frameDuration, parts.frontArm.generateAnimation("idle", 1), Animation.PlayMode.LOOP);
        backArmAnimation = new Animation<>(frameDuration, parts.backArm.generateAnimation("idle", 1), Animation.PlayMode.LOOP);
        headAnimation = new Animation<>(frameDuration, parts.head.generateAnimation("normal", 1), Animation.PlayMode.LOOP);

        beakAnimation = new Animation<>(frameDuration, parts.beak.generateAnimation("normal", 1), Animation.PlayMode.LOOP);
        fluffAnimation = new Animation<>(frameDuration, parts.fluff.generateAnimation("normal", 1), Animation.PlayMode.LOOP);
        hairAnimation = new Animation<>(frameDuration, parts.hair.generateAnimation("normal", 1), Animation.PlayMode.LOOP);

        pantsAnimation = new Animation<>(frameDuration, parts.pants.generateAnimation("idle", 1), Animation.PlayMode.LOOP);
        jacketAnimation = new Animation<>(frameDuration, parts.jacket.generateAnimation("chest", 1), Animation.PlayMode.LOOP);
        gogglesAnimation = new Animation<>(frameDuration, parts.goggles.generateAnimation("normal", 1), Animation.PlayMode.LOOP);
    }
}
