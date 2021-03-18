package dev.lyze.gamejammarch2021.lyze;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import dev.lyze.gamejammarch2021.lyze.animations.LyzeAnimation;
import dev.lyze.gamejammarch2021.lyze.animations.LyzeWalkAnimation;
import dev.lyze.gamejammarch2021.lyze.setup.LyzeBodyParts;
import space.earlygrey.shapedrawer.ShapeDrawer;

public class Lyze
{
    private final LyzeBodyParts bodyParts;

    private float totalDeltaTime;

    private LyzeAnimation currentAnimation;

    public Lyze()
    {
        bodyParts = new LyzeBodyParts();

        currentAnimation = new LyzeWalkAnimation(bodyParts);
    }

    public void update(float delta)
    {
        totalDeltaTime += delta;
    }

    public void render(SpriteBatch batch)
    {
        currentAnimation.render(batch, totalDeltaTime);
    }

    public void debugRender(ShapeDrawer drawer)
    {

    }
}
