package com.first.rpggame;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.first.rpggame.MainActivity.GameView;

public class Map {
	
	public static int x, y, previousX, previousY, checkX, checkY = 0, charX, charY;
	Bitmap map;
	GameView game;
	boolean right, left, up, down = false;
	
	public Map(Bitmap map) {
		// TODO Auto-generated constructor stub
		
		this.map = map;
		
		
		previousX = MainActivity.previousX;
		previousY = MainActivity.previousY;
		
		if (MainActivity.x != previousX || MainActivity.y != previousY) {
			
			if (MainActivity.x > previousX && MainActivity.y == previousY) {
				right = true;
			}
			
			else if (MainActivity.x < previousX && MainActivity.y == previousY) {
				left = true;
			}
			
			else if (MainActivity.x == previousX && MainActivity.y > previousY) {
				down = true;
			}
			
			else if (MainActivity.x == previousX && MainActivity.y < previousY) {
				up = true;
			}
			
		}
	}
	
	public void Update() {
		
		if (right) {
			x += 12;
			checkX += 1;
			right = false;
		}
		
		else if (left) {
			x -= 12;
			checkX -= 1;
			left = false;
		}
		
		else if (up) {
			y -= 12;
			checkY -= 1;
			up = false;
		}
		
		else if (down) {
			y += 12;
			checkY += 1;
			down = false;
		}
		
	} 
	
	public void Draw(Canvas canvas) {
		
		Update();
		
		// FOR SOME REASON THE MAP COORDINATES ARE NEGATIVE?????!
		int sourceX = -((map.getWidth() / 2) - (int)(MainActivity.displayValueX / 2)) - x; 
		int sourceY = -((map.getHeight() / 2) - (int)(MainActivity.displayValueY / 2)) - y;
		charX = sourceX;
		charY = sourceY;
		
		canvas.drawBitmap(map, sourceX, sourceY, null);
	}

}
