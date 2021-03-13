package dev.lyze.gamejammarch2021.lyze;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import lombok.var;
import space.earlygrey.shapedrawer.ShapeDrawer;

public class Lyze
{
    private final Humanoid humanoid;
    private final BodyPart body, frontArm, backArm, head;

    private final BodyPart beak, fluff, hair;

    private final Animation<TextureRegion> walkBodyAnimation, walkFrontArmAnimation, walkBackArmAnimation, walkHeadAnimation;

    private final Animation<TextureRegion> walkBeakAnimation, walkFluffAnimation, walkHairAnimation;

    private float totalDeltaTime;

    public Lyze()
    {
        humanoid = new Humanoid(Gdx.files.internal("lyze/humanoid.config"));

        body = new BodyPart(Gdx.files.internal("lyze/body.frames"));
        frontArm = new BodyPart(Gdx.files.internal("lyze/frontarm.frames"));
        backArm = new BodyPart(Gdx.files.internal("lyze/backarm.frames"));
        head = new BodyPart(Gdx.files.internal("lyze/head.frames"));

        beak = new BodyPart(Gdx.files.internal("lyze/beak.frames"));
        fluff = new BodyPart(Gdx.files.internal("lyze/fluff.frames"));
        hair = new BodyPart(Gdx.files.internal("lyze/hair.frames"));

        walkBodyAnimation = new Animation<>(0.2f, body.generateAnimation("walk", 1, 2, 3, 4, 5, 6, 7, 8), Animation.PlayMode.LOOP);
        walkFrontArmAnimation = new Animation<>(0.2f, frontArm.generateAnimation("walk", humanoid.get().armWalkSeq), Animation.PlayMode.LOOP);
        walkBackArmAnimation = new Animation<>(0.2f, backArm.generateAnimation("walk", humanoid.get().armWalkSeq), Animation.PlayMode.LOOP);
        walkHeadAnimation = new Animation<>(0.2f, head.generateAnimation("normal", 1), Animation.PlayMode.LOOP);

        walkBeakAnimation = new Animation<>(0.2f, beak.generateAnimation("normal", 1), Animation.PlayMode.LOOP);
        walkFluffAnimation = new Animation<>(0.2f, fluff.generateAnimation("normal", 1), Animation.PlayMode.LOOP);
        walkHairAnimation = new Animation<>(0.2f, hair.generateAnimation("normal", 1), Animation.PlayMode.LOOP);
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

        var headOffset = humanoid.get().walkBob[walkBodyAnimation.getKeyFrameIndex(totalDeltaTime)];
        batch.draw(walkHeadAnimation.getKeyFrame(totalDeltaTime), 0, headOffset);

        batch.draw(walkHairAnimation.getKeyFrame(totalDeltaTime), 0, headOffset);
        batch.draw(walkFluffAnimation.getKeyFrame(totalDeltaTime), 0, headOffset);
        batch.draw(walkBeakAnimation.getKeyFrame(totalDeltaTime), 0, headOffset);
    }

    public void debugRender(ShapeDrawer drawer)
    {

    }
}
