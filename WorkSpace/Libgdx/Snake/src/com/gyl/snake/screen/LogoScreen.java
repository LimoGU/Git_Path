package com.gyl.snake.screen;

import java.io.IOException;
import java.nio.CharBuffer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.gyl.snake.app.GameApp;
import com.gyl.snake.config.GameComfig;

/**
 * 游戏欢迎界面
 * @author 顾玉龙
 *
 */
public class LogoScreen implements Screen{
	private GameApp gameApp;		//游戏主类对象
	private TextureAtlas welAtlas;
	private TextureRegion logo;
	private Stage welStage;
	private Image image;
	public LogoScreen(GameApp gameApp) {
		super();
		this.gameApp = gameApp;
		
		welAtlas=gameApp.textureAtlas;
		logo=welAtlas.findRegion("logo");
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(1, 1, 1, 1);
		welStage.act();
		welStage.draw();
	}

	@Override
	public void resize(int width, int height) {
		Gdx.app.log("debug", "resize");
		
	}

	@Override
	public void show() {
		Gdx.app.log("debug", "show");
		welStage=new Stage(GameComfig.SCREEN_WIDTH,GameComfig.SCREEN_HIGHT,false);
		image=new Image(logo);
		image.setPosition(((Gdx.graphics.getWidth()-image.getWidth())/2), ((Gdx.graphics.getHeight()-image.getHeight())/2));
		welStage.addActor(image);
		image.addAction(sequence(fadeOut(1),run(new my(1)),fadeIn(2),run(new my(2)),fadeOut(3),run(new my(3))));
	}
	@Override
	public void hide() {
		Gdx.app.log("debug", "hide");
		
	}

	@Override
	public void pause() {
		Gdx.app.log("debug", "pause");
		
	}

	@Override
	public void resume() {
		Gdx.app.log("debug", "resume");
		
	}

	@Override
	public void dispose() {
		Gdx.app.log("debug", "dispose");
		
	}

	class my implements Runnable{
		private int state;
		public my(int state) {
			this.state=state;
		}

		@Override
		public void run() {
			switch (state) {
			case 1:
				Gdx.app.log("debug", "显示主界面1");
				break;
			case 2:
				Gdx.app.log("debug", "显示主界面2");
				break;
			case 3:
				Gdx.app.log("debug", "显示主界面3");
				break;
			case 4:
				Gdx.app.log("debug", "显示主界面4");
				break;

			default:
				break;
			}
			

			
		}

	}
}
