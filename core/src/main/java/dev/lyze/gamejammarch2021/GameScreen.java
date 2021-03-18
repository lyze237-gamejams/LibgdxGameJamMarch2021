package dev.lyze.gamejammarch2021;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import de.eskalon.commons.screen.ManagedScreen;
import dev.lyze.gamejammarch2021.lyze.Lyze;
import dev.lyze.gamejammarch2021.utils.PixelGenerator;
import space.earlygrey.shapedrawer.ShapeDrawer;

public class GameScreen extends ManagedScreen
{
    private final Viewport viewport = new ExtendViewport(120, 120);
    private final SpriteBatch batch = new SpriteBatch();
    private final ShapeDrawer drawer = new ShapeDrawer(batch, PixelGenerator.createPixel());
    private final Main main = (Main) Gdx.app.getApplicationListener();

    private Lyze lyze = new Lyze();

    @Override
    protected void create() { }

    @Override
    public void render(float delta)
    {
        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);

        lyze.update(delta);

        batch.begin();

        lyze.render(batch);
        lyze.debugRender(drawer);

        batch.end();
    }

    @Override
    public void hide()
    {

    }

    @Override
    public void resize(int width, int height)
    {
        viewport.update(width, height);
    }

    @Override
    public void dispose() { }

    @Override
    public Color getClearColor()
    {
        return Color.DARK_GRAY;
    }
}