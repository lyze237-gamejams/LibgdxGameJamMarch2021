package dev.lyze.gamejammarch2021.utils;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import lombok.var;

public class PixelGenerator
{
    public static TextureRegion createPixel()
    {
        var pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.WHITE);
        pixmap.fill();

        return new TextureRegion(new Texture(pixmap));
    }
}
