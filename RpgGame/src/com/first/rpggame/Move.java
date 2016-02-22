package com.first.rpggame;

import android.os.SystemClock;
import android.view.View;

public class Move {

	
	public static Runnable yDecrease = new Runnable() {
		
		public void run() {
			
	  		if (BattleMenu.fight) {
	 			MainActivity.up.setVisibility(View.INVISIBLE);
	 			MainActivity.down.setVisibility(View.INVISIBLE);
	 			MainActivity.right.setVisibility(View.INVISIBLE);
	 			MainActivity.left.setVisibility(View.INVISIBLE);
	 			MainActivity.fightButton.setVisibility(View.VISIBLE);
	 		}
	  		
	  		else {
	  			MainActivity.y -= 1;
	  			MainActivity.up.setBackgroundResource(R.drawable.upheld);
	  			MainActivity.tv.setText("X: " + Map.checkX + " Y: " + Map.checkY);
	  			MainActivity.mHandler.postAtTime(this, SystemClock.uptimeMillis() + 100);
	  		}
		}
		
	};
	
	public static Runnable yIncrease = new Runnable() {
		
		public void run() {
			
	  		if (BattleMenu.fight) {
	 			MainActivity.up.setVisibility(View.INVISIBLE);
	 			MainActivity.down.setVisibility(View.INVISIBLE);
	 			MainActivity.right.setVisibility(View.INVISIBLE);
	 			MainActivity.left.setVisibility(View.INVISIBLE);
	 			MainActivity.fightButton.setVisibility(View.VISIBLE);
	 		}
	  		
	  		// Stops the character from moving if he hit a monster
	  		else {
	  			MainActivity.y += 1;
	  			MainActivity.down.setBackgroundResource(R.drawable.downheld);
	  			MainActivity.tv.setText("X: " + Map.checkX + " Y: " + Map.checkY);
	  			MainActivity.mHandler.postAtTime(this, SystemClock.uptimeMillis() + 100);
	  		}
		}
		
	};
	
	public static Runnable xDecrease = new Runnable() {
		
		public void run() {
			
	  		if (BattleMenu.fight) {
	 			MainActivity.up.setVisibility(View.INVISIBLE);
	 			MainActivity.down.setVisibility(View.INVISIBLE);
	 			MainActivity.right.setVisibility(View.INVISIBLE);
	 			MainActivity.left.setVisibility(View.INVISIBLE);
	 			MainActivity.fightButton.setVisibility(View.VISIBLE);
	 		}
	  		
	  		// Stops the character from moving if he hits a monster
	  		else {
	  			MainActivity.x -= 1;
	  			MainActivity.left.setBackgroundResource(R.drawable.leftheld);
	  			MainActivity.tv.setText("X: " + Map.checkX + " Y: " + Map.checkY);
	  			MainActivity.mHandler.postAtTime(this, SystemClock.uptimeMillis() + 100);
	  		}
		}
		
	};
	
	public static Runnable xIncrease = new Runnable() {
		
		public void run() {
			
	  		if (BattleMenu.fight) {
	 			MainActivity.up.setVisibility(View.INVISIBLE);
	 			MainActivity.down.setVisibility(View.INVISIBLE);
	 			MainActivity.right.setVisibility(View.INVISIBLE);
	 			MainActivity.left.setVisibility(View.INVISIBLE);
	 			MainActivity.fightButton.setVisibility(View.VISIBLE);
	 		}
	  		
	  		// Stops the character from moving if he hits a monster
	  		else {
	  			MainActivity.x += 1;
	  			MainActivity.right.setBackgroundResource(R.drawable.rightheld);
	  			MainActivity.tv.setText("X: " + Map.checkX + " Y: " + Map.checkY);
	  			MainActivity.mHandler.postAtTime(this, SystemClock.uptimeMillis() + 100);
	  		}
		}
		
	};
	
}
