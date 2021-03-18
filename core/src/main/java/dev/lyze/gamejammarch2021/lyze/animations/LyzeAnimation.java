package dev.lyze.gamejammarch2021.lyze.animations;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import dev.lyze.gamejammarch2021.lyze.setup.LyzeBodyParts;
import lombok.var;

public abstract class LyzeAnimation
{
    protected final LyzeBodyParts parts;

    protected Animation<TextureRegion> bodyAnimation, frontArmAnimation, backArmAnimation, headAnimation;

    protected Animation<TextureRegion> beakAnimation, fluffAnimation, hairAnimation;

    protected Animation<TextureRegion> pantsAnimation, jacketAnimation, gogglesAnimation;


    protected LyzeAnimation(LyzeBodyParts parts)
    {
        this.parts = parts;
    }


    public void render(SpriteBatch batch, float totalDeltaTime)
    {
        var walkBob = parts.humanoid.walkBob[bodyAnimation.getKeyFrameIndex(totalDeltaTime)];

        batch.draw(backArmAnimation.getKeyFrame(totalDeltaTime), 0, 0);

        // body
        batch.draw(bodyAnimation.getKeyFrame(totalDeltaTime), 0, 0);

        // clothes
        batch.draw(pantsAnimation.getKeyFrame(totalDeltaTime), 0, 0);
        batch.draw(jacketAnimation.getKeyFrame(totalDeltaTime), 0, walkBob);

        // front arm
        batch.draw(frontArmAnimation.getKeyFrame(totalDeltaTime), 0, 0);

        //head
        batch.draw(headAnimation.getKeyFrame(totalDeltaTime), 0, walkBob);
        batch.draw(hairAnimation.getKeyFrame(totalDeltaTime), 0, walkBob);
        batch.draw(fluffAnimation.getKeyFrame(totalDeltaTime), 0, walkBob);
        batch.draw(beakAnimation.getKeyFrame(totalDeltaTime), 0, walkBob);

        // goggles
        batch.draw(gogglesAnimation.getKeyFrame(totalDeltaTime), 0, walkBob);
    }
}
