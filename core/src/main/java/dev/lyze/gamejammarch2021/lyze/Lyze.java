package dev.lyze.gamejammarch2021.lyze;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import lombok.var;
import space.earlygrey.shapedrawer.ShapeDrawer;

public class Lyze
{
    private final Humanoid humanoid;
    private final BodyPart body, frontArm, backArm, head;

    private final BodyPart beak, fluff, hair;

    private final BodyPart pants, jacket, goggles;

    private final Animation<TextureRegion> walkBodyAnimation, walkFrontArmAnimation, walkBackArmAnimation, walkHeadAnimation;

    private final Animation<TextureRegion> walkBeakAnimation, walkFluffAnimation, walkHairAnimation;

    private final Animation<TextureRegion> walkPantsAnimation, walkJacketAnimation, walkGogglesAnimation;

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

        pants = new BodyPart(Gdx.files.internal("steampunk/pants.frames"));
        jacket = new BodyPart(Gdx.files.internal("steampunk/chest.frames"));
        goggles = new BodyPart(Gdx.files.internal("steampunk/head.frames"));

        float frameDuration = humanoid.get().humanoidTiming.stateCycle[1] / 8f; // cycle / amount of frames ?
        walkBodyAnimation = new Animation<>(frameDuration, body.generateAnimation("walk", 1, 2, 3, 4, 5, 6, 7, 8), Animation.PlayMode.LOOP);
        walkFrontArmAnimation = new Animation<>(frameDuration, frontArm.generateAnimation("walk", humanoid.get().armWalkSeq), Animation.PlayMode.LOOP);
        walkBackArmAnimation = new Animation<>(frameDuration, backArm.generateAnimation("walk", humanoid.get().armWalkSeq), Animation.PlayMode.LOOP);
        walkHeadAnimation = new Animation<>(frameDuration, head.generateAnimation("normal", 1), Animation.PlayMode.LOOP);

        walkBeakAnimation = new Animation<>(frameDuration, beak.generateAnimation("normal", 1), Animation.PlayMode.LOOP);
        walkFluffAnimation = new Animation<>(frameDuration, fluff.generateAnimation("normal", 1), Animation.PlayMode.LOOP);
        walkHairAnimation = new Animation<>(frameDuration, hair.generateAnimation("normal", 1), Animation.PlayMode.LOOP);

        walkPantsAnimation = new Animation<>(frameDuration, pants.generateAnimation("walk", 1, 2, 3, 4, 5, 6, 7, 8), Animation.PlayMode.LOOP);
        walkJacketAnimation = new Animation<>(frameDuration, jacket.generateAnimation("chest", 1), Animation.PlayMode.LOOP);
        walkGogglesAnimation = new Animation<>(frameDuration, goggles.generateAnimation("normal", 1), Animation.PlayMode.LOOP);
    }

    public void update(float delta)
    {
        totalDeltaTime += delta;
    }

    public void render(SpriteBatch batch)
    {
        var walkBob = humanoid.get().walkBob[walkBodyAnimation.getKeyFrameIndex(totalDeltaTime)];

        batch.draw(walkBackArmAnimation.getKeyFrame(totalDeltaTime), 0, 0);

        // body
        batch.draw(walkBodyAnimation.getKeyFrame(totalDeltaTime), 0, 0);

        // clothes
        batch.draw(walkPantsAnimation.getKeyFrame(totalDeltaTime), 0, 0);
        batch.draw(walkJacketAnimation.getKeyFrame(totalDeltaTime), 0, walkBob);

        // front arm
        batch.draw(walkFrontArmAnimation.getKeyFrame(totalDeltaTime), 0, 0);

        //head
        batch.draw(walkHeadAnimation.getKeyFrame(totalDeltaTime), 0, walkBob);
        batch.draw(walkHairAnimation.getKeyFrame(totalDeltaTime), 0, walkBob);
        batch.draw(walkFluffAnimation.getKeyFrame(totalDeltaTime), 0, walkBob);
        batch.draw(walkBeakAnimation.getKeyFrame(totalDeltaTime), 0, walkBob);

        // goggles
        batch.draw(walkGogglesAnimation.getKeyFrame(totalDeltaTime), 0, walkBob);
    }

    public void debugRender(ShapeDrawer drawer)
    {

    }
}
