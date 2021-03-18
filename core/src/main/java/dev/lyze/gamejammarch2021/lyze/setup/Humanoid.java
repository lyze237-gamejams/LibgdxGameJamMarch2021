package dev.lyze.gamejammarch2021.lyze.setup;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;

public class Humanoid
{
    private final HumanoidJson json;

    public Humanoid(FileHandle humanoidConfig)
    {
        this.json = new Json().fromJson(HumanoidJson.class, humanoidConfig);
    }

    public HumanoidJson get()
    {
        return json;
    }

    public static class HumanoidJson
    {
        public float[] globalOffset;
        public int[] headRunOffset;
        public int[] headSwimOffset;
        public int runFallOffset;
        public int duckOffset;
        public int[] headDuckOffset;
        public int sitOffset;
        public int layOffset;
        public int[] headSitOffset;
        public int[] headLayOffset;
        public int[] recoilOffset;
        public int[] armWalkSeq;
        public int[] armRunSeq;
        public int[] walkBob;
        public int[] runBob;
        public int jumpBob;
        public int[] swimBob;
        public int[] frontArmRotationCenter;
        public int[] backArmRotationCenter;
        public int[] frontHandPosition;
        public int[] backArmOffset;
        public int[] mouthOffset;
        public int[] feetOffset;
        public int[] headArmorOffset;
        public int[] chestArmorOffset;
        public int[] backArmorOffset;
        public int[] legsArmorOffset;
        public int vaporTrailFrames;
        public float vaporTrailCycle;
        public HumanoidTiming humanoidTiming;
        public String[][] personalities;
    }

    public static class HumanoidTiming
    {
        public float[] stateCycle;
        public int[] stateFrames;
        public float[] emoteCycle;
        public int[] emoteFrames;
    }
}
