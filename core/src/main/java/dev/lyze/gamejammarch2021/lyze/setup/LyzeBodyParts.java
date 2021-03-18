package dev.lyze.gamejammarch2021.lyze.setup;

import com.badlogic.gdx.Gdx;

public class LyzeBodyParts
{
    public final Humanoid.HumanoidJson humanoid;
    public final BodyPart body, frontArm, backArm, head;

    public final BodyPart beak, fluff, hair;

    public final BodyPart pants, jacket, goggles;

    public LyzeBodyParts() {
        humanoid = new Humanoid(Gdx.files.internal("lyze/humanoid.config")).get();

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
    }
}
