package dev.lyze.gamejammarch2021.lyze.states.data;

import dev.lyze.gamejammarch2021.lyze.setup.LyzeBodyParts;
import lombok.Getter;

public class LyzeData
{
    @Getter
    private final LyzeBodyParts bodyParts;

    public LyzeData() {
        bodyParts = new LyzeBodyParts();
    }
}
