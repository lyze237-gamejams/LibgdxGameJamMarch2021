package dev.lyze.gamejammarch2021;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import space.earlygrey.shapedrawer.ShapeDrawer;

public class Lyze
{
    private final BodyPart body, frontArm, backArm;

    private final Animation<TextureRegion> walkBodyAnimation, walkFrontArmAnimation, walkBackArmAnimation;
    private float totalDeltaTime;

    public Lyze()
    {
        body = new BodyPart(Gdx.files.internal("lyze/body.frames"));
        frontArm = new BodyPart(Gdx.files.internal("lyze/frontarm.frames"));
        backArm = new BodyPart(Gdx.files.internal("lyze/backarm.frames"));

        walkBodyAnimation = new Animation<>(0.2f, body.generateAnimation("walk", 1, 2, 3, 4, 5, 6, 7, 8), Animation.PlayMode.LOOP);
        walkFrontArmAnimation = new Animation<>(0.2f, frontArm.generateAnimation("walk", 2, 1, 2, 3, 4, 5, 4, 3), Animation.PlayMode.LOOP);
        walkBackArmAnimation = new Animation<>(0.2f, backArm.generateAnimation("walk", 2, 1, 2, 3, 4, 5, 4, 3), Animation.PlayMode.LOOP);
    }

    public void update(float delta)
    {
        totalDeltaTime += delta;
    }

    public void render(SpriteBatch batch)
    {
        batch.draw(walkBackArmAnimation.getKeyFrame(totalDeltaTime), 0, 0);
        batch.draw(walkBodyAnimation.getKeyFrame(totalDeltaTime), 0, 0);
        batch.draw(walkFrontArmAnimation.getKeyFrame(totalDeltaTime), 0, 0);
    }

    public void debugRender(ShapeDrawer drawer)
    {

    }
}
