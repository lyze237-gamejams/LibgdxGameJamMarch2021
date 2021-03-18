package dev.lyze.gamejammarch2021;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import de.eskalon.commons.core.ManagedGame;
import de.eskalon.commons.screen.ManagedScreen;
import de.eskalon.commons.screen.transition.ScreenTransition;
import de.eskalon.commons.screen.transition.impl.BlendingTransition;

public class Main extends ManagedGame<ManagedScreen, ScreenTransition>
{
    @Override
    public void create()
    {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        super.create();

        SpriteBatch batch = new SpriteBatch();

        this.screenManager.addScreen(GameScreen.class.getName(), new GameScreen());

        this.screenManager.addScreenTransition(BlendingTransition.class.getName(), new BlendingTransition(batch, 1f));

        this.screenManager.pushScreen(GameScreen.class.getName(), BlendingTransition.class.getName());
    }
}