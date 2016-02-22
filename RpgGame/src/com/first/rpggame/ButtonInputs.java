package com.first.rpggame;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class ButtonInputs implements OnTouchListener {
	
	public static boolean runLostHealth = true;
	
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		
		BattleStuff battle = new BattleStuff();
		
		int action = event.getAction();

		
		
		
		
		if (action == MotionEvent.ACTION_DOWN && v.getId() == 121250) {
			MainActivity.mHandler.removeCallbacks(Move.yDecrease);
			MainActivity.mHandler.postAtTime(Move.yDecrease,
					SystemClock.uptimeMillis() + 100);
		}

		else if (action == MotionEvent.ACTION_UP && v.getId() == 121250) {
			MainActivity.mHandler.removeCallbacks(Move.yDecrease);
			MainActivity.up.setBackgroundResource(R.drawable.up);
		}
		
		
		
		

		else if (action == MotionEvent.ACTION_DOWN && v.getId() == 12125) {
			MainActivity.mHandler.removeCallbacks(Move.yIncrease);
			MainActivity.mHandler.postAtTime(Move.yIncrease,
					SystemClock.uptimeMillis() + 100);
		}

		else if (action == MotionEvent.ACTION_UP && v.getId() == 12125) {
			MainActivity.mHandler.removeCallbacks(Move.yIncrease);
			MainActivity.down.setBackgroundResource(R.drawable.down);
		}
		
		
		
		

		else if (action == MotionEvent.ACTION_DOWN && v.getId() == 1212) {
			MainActivity.mHandler.removeCallbacks(Move.xIncrease);
			MainActivity.mHandler.postAtTime(Move.xIncrease,
					SystemClock.uptimeMillis() + 100);
		}

		else if (action == MotionEvent.ACTION_UP && v.getId() == 1212) {
			MainActivity.mHandler.removeCallbacks(Move.xIncrease);
			MainActivity.right.setBackgroundResource(R.drawable.right);
		}
		
		
		
		

		else if (action == MotionEvent.ACTION_DOWN && v.getId() == 121) {
			MainActivity.mHandler.removeCallbacks(Move.xDecrease);
			MainActivity.mHandler.postAtTime(Move.xDecrease,
					SystemClock.uptimeMillis() + 100);
		}

		else if (action == MotionEvent.ACTION_UP && v.getId() == 121) {
			MainActivity.mHandler.removeCallbacks(Move.xDecrease);
			MainActivity.left.setBackgroundResource(R.drawable.left);
		}
		
		
		
		

		// WHEN USER PRESSES THE FIGHT BUTTON
		else if (v.getId() == 123) {
			
			MainActivity.fightButton.setVisibility(View.INVISIBLE);
			MainActivity.attackButton.setVisibility(View.VISIBLE);
			MainActivity.itemsButton.setVisibility(View.VISIBLE);
			MainActivity.runButton.setVisibility(View.VISIBLE);
			
			MainActivity.startBattle = true;
			runLostHealth = true;
		}
		
		// WHEN USER PRESSES THE OKAY BUTTON AFTER FINISHING A BATTLE
		else if (v.getId() == 2121) {
			BattleStuff.ChangeProperButtons();
		}

		// WHEN USER PRESSES ATTACK ON BATTLE MENU
		else if (v.getId() == 12 && !BattleStuff.killedEnemy && !BattleStuff.dead) {
			
			battle.Attack();
			
		}

		// WHEN USER PRESSES ITEMS ON BATTLE MENU
		else if (v.getId() == 21 && !BattleStuff.killedEnemy && !BattleStuff.dead) {
			
			battle.Items();
			
		}

		// WHEN USER PRESSES RUN ON BATTLE MENU
		else if (v.getId() == 212 && !BattleStuff.killedEnemy && !BattleStuff.dead) {
			
			battle.Run();
			
		}

		return false;
	}

}
