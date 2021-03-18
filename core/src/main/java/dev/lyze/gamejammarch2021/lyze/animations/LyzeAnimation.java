package dev.lyze.gamejammarch2021.lyze.animations;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import dev.lyze.gamejammarch2021.lyze.setup.LyzeBodyParts;
import lombok.var;
import space.earlygrey.shapedrawer.ShapeDrawer;

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


    public void render(SpriteBatch batch, float totalDeltaTime, float facingRight)
    {
        var walkBob = parts.humanoid.walkBob[bodyAnimation.getKeyFrameIndex(totalDeltaTime)];

        render(batch, backArmAnimation.getKeyFrame(totalDeltaTime), 0, 0, facingRight);

        // body
        render(batch, bodyAnimation.getKeyFrame(totalDeltaTime), 0, 0, facingRight);

        // clothes
        render(batch, pantsAnimation.getKeyFrame(totalDeltaTime), 0, 0, facingRight);
        render(batch, jacketAnimation.getKeyFrame(totalDeltaTime), 0, walkBob, facingRight);

        // front arm
        render(batch, frontArmAnimation.getKeyFrame(totalDeltaTime), 0, 0, facingRight);

        //head
        render(batch, headAnimation.getKeyFrame(totalDeltaTime), 0, walkBob, facingRight);
        render(batch, hairAnimation.getKeyFrame(totalDeltaTime), 0, walkBob, facingRight);
        render(batch, fluffAnimation.getKeyFrame(totalDeltaTime), 0, walkBob, facingRight);
        render(batch, beakAnimation.getKeyFrame(totalDeltaTime), 0, walkBob, facingRight);

        // goggles
        render(batch, gogglesAnimation.getKeyFrame(totalDeltaTime), 0, walkBob, facingRight);
    }

    private void render(SpriteBatch batch, TextureRegion texture, int x, int y, float facingRight)
    {
        if (facingRight > 0)
            batch.draw(texture, x, y);
        else
            batch.draw(texture, x + texture.getRegionWidth(), y, -texture.getRegionWidth(), texture.getRegionHeight());
    }

    public void debugRender(ShapeDrawer drawer, float totalDeltaTime)
    {
        var keyFrame = bodyAnimation.getKeyFrame(totalDeltaTime);

        drawer.setColor(Color.TEAL);
        drawer.rectangle(0, 0, keyFrame.getRegionWidth(), keyFrame.getRegionHeight());
    }
}
