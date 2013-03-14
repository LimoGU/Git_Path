package com.gyl.snake.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
/**
 * 游戏界面
 * @author 顾玉龙
 *
 */
public class GameScreen implements Screen,GestureListener{
	private BitmapFont bitmapFont;
	private SpriteBatch spriteBatch;
	private  float x,y,dx,dy;
	private Direction direction;
	/**
	 * 方向的枚举
	 * @author 顾玉龙
	 *
	 */
	public enum Direction{ 
		UP,
		DOWN,
		LEFT,
		RIGHT
	}
	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(1, 1, 1, 1);
		spriteBatch.begin();
		bitmapFont.draw(spriteBatch, "x:"+x, 100, 200);
		bitmapFont.draw(spriteBatch, "y:"+y, 150, 200);
		bitmapFont.draw(spriteBatch, "dx:"+dx, 100, 150);
		bitmapFont.draw(spriteBatch, "dy:"+dy, 150, 150);
		bitmapFont.draw(spriteBatch, "direction:"+(Direction)direction, 100, 100);
		spriteBatch.end();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		bitmapFont=new BitmapFont();
		spriteBatch=new SpriteBatch();
		direction=Direction.UP;
		Gdx.input.setInputProcessor(new GestureDetector(this));
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean longPress(float x, float y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		dx=velocityX;
		dy=velocityY;
		direction=control(velocityX, velocityY);
		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2,
			Vector2 pointer1, Vector2 pointer2) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 控制方向的方法
	 * @param deltaX	x轴的变化量
	 * @param deltaY	y轴的变化量
	 */
	public Direction control(float velocityX, float velocityY){
		if(Math.abs(velocityX)>Math.abs(velocityY)){
			if(velocityX>0){
				return Direction.RIGHT;
			}else{
				return Direction.LEFT;
			}
			
			
		}else if (Math.abs(velocityX)<Math.abs(velocityY)){
			if(velocityY>0){
				return Direction.DOWN;
			}else{
				return Direction.UP;
			}
		}
		return direction;
	}
	
}
