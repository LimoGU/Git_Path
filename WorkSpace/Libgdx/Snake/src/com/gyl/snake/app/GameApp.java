package com.gyl.snake.app;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.gyl.snake.config.GameComfig;
import com.gyl.snake.screen.GameScreen;
import com.gyl.snake.screen.LogoScreen;

public class GameApp extends Game {
	private LogoScreen welcomeScreen;
	private GameScreen gameScreen;
	public TextureAtlas textureAtlas;
	
	@Override
	public void dispose() {
		welcomeScreen.dispose();
	}

	@Override
	public void create() {		
	GameComfig.SCREEN_WIDTH=Gdx.graphics.getWidth();
	GameComfig.SCREEN_HIGHT=Gdx.graphics.getHeight();
		
//		GameComfig.SCREEN_WIDTH=480;
//		GameComfig.SCREEN_HIGHT=320;
		
		textureAtlas=new TextureAtlas(Gdx.files.internal("data/snake.pack"));
		gameScreen=new GameScreen();
		welcomeScreen=new LogoScreen(this);
		setScreen(gameScreen);
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
		welcomeScreen.pause();
	}

	@Override
	public void resume() {
		welcomeScreen.resume();
	}
}
