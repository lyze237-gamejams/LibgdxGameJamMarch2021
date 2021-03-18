package dev.lyze.gamejammarch2021.lyze;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import lombok.Getter;

public class LyzeInputHandler
{
    @Getter
    private Vector2 movementInput = new Vector2();

    public void update(float delta)
    {
        movementInput.set(0, 0);

        if (Gdx.input.isKeyPressed(Input.Keys.A))
            movementInput.x = -1f;
        if (Gdx.input.isKeyPressed(Input.Keys.D))
            movementInput.x = 1f;

        if (Gdx.input.isKeyPressed(Input.Keys.W))
            movementInput.y = -1f;
        if (Gdx.input.isKeyPressed(Input.Keys.S))
            movementInput.y = 1f;
    }
}
