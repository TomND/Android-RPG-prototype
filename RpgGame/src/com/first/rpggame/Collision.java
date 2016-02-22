package com.first.rpggame;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.first.rpggame.MainActivity.GameView;

public class Collision {
	
	public static int x, y, previousX, previousY, checkX, checkY = 0, objX, objY, objPX, objPY;
	Bitmap object;
	GameView game;
	boolean right, left, up, down = false;
	
	public Collision(Bitmap object, int objX, int objY, int objPX, int objPY) {
		// TODO Auto-generated constructor stub
		
		Collision.objX = objX;
		Collision.objY = objY;
		Collision.objPX = objPX;
		Collision.objPY = objPY;
		
		
		this.object = object;
		
		previousX = MainActivity.previousX;
		previousY = MainActivity.previousY;
		
		//if(Map.charX + 1 ==)
		
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
		int sourceX = -((object.getWidth() / 2)  - (int)(MainActivity.displayValueX / 2)) - x; 
		int sourceY = -((object.getHeight() / 2) - (int)(MainActivity.displayValueY / 2)) - y;
		
		
		canvas.drawBitmap(object, sourceX + objX, sourceY + objY, null);
	}

}
