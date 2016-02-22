package com.first.rpggame;

import java.util.Random;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.first.rpggame.MainActivity.GameView;

public class Sprite {
	
	public static int drawX, drawY, x, y, previousX, previousY, height, width;
	public static int currentFrame = 1;
	public static int direction = 0;
	public static int count = 0;
	boolean right, left, up, down, newAnimation = false;
	
	Bitmap b;
	GameView game;
	BattleMenu battle;
	Random r = new Random();

	public Sprite(Bitmap character) {
		// TODO Auto-generated constructor stub
		b = character;
		
		drawX = ((int) MainActivity.displayValueX / 2) - ((character.getWidth() / 3) / 2);
		drawY = ((int) MainActivity.displayValueY / 2) - ((character.getHeight() / 4) / 2);
		
		x = (int) MainActivity.x;
		y = (int) MainActivity.y;
		previousX = MainActivity.previousX;
		previousY = MainActivity.previousY;
		
		
		// Four Rows for spritesheet
		height = b.getHeight() / 4;
		
		// Three Columns for spritesheet
		width = b.getWidth() / 3;
		
		if (x != previousX || y != previousY) {
			newAnimation = true;
			
			if (x > previousX && y == previousY) {
				right = true;
			}
			
			else if (x < previousX && y == previousY) {
				left = true;
			}
			
			else if (x == previousX && y > previousY) {
				down = true;
			}
			
			else if (x == previousX && y < previousY) {
				up = true;
			}
			
		}
	}
	
	private void Update() {
		// TODO Auto-generated method stub
		
		battle = new BattleMenu();
		
		GetDirection();
		TheSleeper(100);
		
		NewFramesOnSpriteSheet : {
		
			if (newAnimation == true) {
				
				// 3 Columns on spritesheet
				currentFrame = ++currentFrame % 3;
				
				// THIS IS HERE BECAUSE I DON'T WANT TO RUN INTO ANOTHER MOB RIGHT AFTER THE OTHER
				if (count == 15) {
					
					// THIS IS HERE BECAUSE I ONLY WANT TO RUN INTO A MOB WHEN I AM RUNNING AROUND
					if (!BattleMenu.fight)
						battle.RandomBattle(r.nextInt(200));
					
				}
				
				else {
					count++;
				}
				
				newAnimation = false;
			}
		
			else {
				currentFrame = 1;
			}
		
		}
		
	}
	
	public void Draw(Canvas canvas) {
		
		Update();
		
		int sourceX = currentFrame * width;
		int sourceY = direction * height;
		
		Rect src = new Rect(sourceX, sourceY, sourceX + width, sourceY + height); 
		Rect dst = new Rect(drawX, drawY, drawX + width - 20, drawY + height - 20);
			
		canvas.drawBitmap(b, src, dst, null);
		
	}
	
	public void GetDirection() {
		
		// Facing down
		if (down) {
			direction = 0;
			down = false;
		}
		
		// Facing left
		if (left) {
			direction = 1;
			left = false;
		}
		
		// Facing up
		if (up) {
			direction = 3;
			up = false;
		}
		
		// Facing right
		if (right) {
			direction = 2;
			right = false;
		}
		
	}
	
	public void TheSleeper(int time)  {
		
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
