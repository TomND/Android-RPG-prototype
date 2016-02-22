package com.first.rpggame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import com.first.rpggame.MainActivity.GameView;

public class BattleMenu {

	GameView game;
	HealthAndMana forEnemy;
	BattleStuff stuff;
	Bitmap battle;
	Paint p1, p2, textPaint;

	static int displayX, displayY, count = 0;

	public static boolean fight = false; // THIS VALUE DETERMINES IF I HIT THE
											// RANDOM NUMBER TO START A FIGHT

	public BattleMenu(Bitmap battleScene) {

		battle = battleScene;
		displayX = (int) MainActivity.displayValueX;
		displayY = (int) MainActivity.displayValueY;
		forEnemy = new HealthAndMana();
		stuff = new BattleStuff();

	}

	public BattleMenu() {

		displayX = (int) MainActivity.displayValueX;
		displayY = (int) MainActivity.displayValueY;
		forEnemy = new HealthAndMana();
		stuff = new BattleStuff();

	}

	public void RandomBattle(int randomNum) {

		if (randomNum <= 3) {
			fight = true;
			Sprite.count = 0;
		}

		else {
			fight = false;
		}

	}

	public void MakePaint() {

		p1 = new Paint();
		p1.setColor(Color.WHITE);
		p1.setStyle(Paint.Style.STROKE);
		p1.setStrokeWidth(6);

		p2 = new Paint();
		p2.setColor(Color.BLACK);

		textPaint = new Paint();
		textPaint.setColor(Color.WHITE);
		textPaint.setTextSize(20);

	}

	public void PopUpMenu(Canvas canvas) {

		// DRAWING THE POP-UP MENU OF GETTING ATTACKED
		Rect popUp = new Rect(100, 100, displayX - 100, displayY - 100);
		canvas.drawRect(popUp, p2);
		canvas.drawRect(popUp, p1);
		canvas.drawText("An enemy has attacked!", 125, 250, textPaint);

	}
	
	public void KilledEnemyPopUp(Canvas canvas) {
		
		Rect popUp = new Rect(100, 100, displayX - 100, displayY - 250);
		canvas.drawRect(popUp, p2);
		canvas.drawRect(popUp, p1);
		canvas.drawText("You have successfully killed ", 120, 250, textPaint);
		canvas.drawText("the " + Enemy.enemyName + "!", 190, 275, textPaint);
		
	}
	
	public void Dead(Canvas canvas) {
		
		Rect popUp = new Rect(100, 100, displayX - 100, displayY - 250);
		canvas.drawRect(popUp, p2);
		canvas.drawRect(popUp, p1);
		canvas.drawText("You are dead", 120, 250, textPaint);
		
	}

	public void InBattle(Canvas canvas) {

		Rect r = new Rect(0, 0, battle.getWidth(), battle.getHeight());
		Rect r2 = new Rect(0, 0, displayX, displayY);
		Rect battleChoices = new Rect(10, displayY - 75, displayX - 10,
				displayY - 10);
		Rect statsOnEnemyAndPlayer = new Rect(10, displayY - 225,
				displayX - 10, displayY - 90);

		// DRAWING THE BATTLECHOICES MENU
		canvas.drawBitmap(battle, r, r2, null);
		canvas.drawRect(battleChoices, p2);
		canvas.drawRect(battleChoices, p1);

		// DRAWING THE STATS SECTION OF THE BATTLE SCREEN
		canvas.drawRect(statsOnEnemyAndPlayer, p2);
		canvas.drawRect(statsOnEnemyAndPlayer, p1);

		// PLAYER STATS BEING DRAWN
		canvas.drawText("Your Stats ", 15, displayY - 200, textPaint);
		canvas.drawText("Strength: " + PlayerStats.strength, 15,
				displayY - 175, textPaint);
		canvas.drawText("Defence: " + PlayerStats.defence, 15, displayY - 150,
				textPaint);
		canvas.drawText("Dexterity: " + PlayerStats.dexterity, 15,
				displayY - 125, textPaint);
		canvas.drawText("Intelligence: " + PlayerStats.intelligence, 15,
				displayY - 100, textPaint);

		// ENEMY STATS BEING DRAWN
		canvas.drawText(Enemy.enemyName + " Stats ", displayX - 175, displayY - 200,
				textPaint);
		canvas.drawText("Strength: " + Enemy.strength, displayX - 175,
				displayY - 175, textPaint);
		canvas.drawText("Defence: " + Enemy.defence, displayX - 175,
				displayY - 150, textPaint);
		canvas.drawText("Dexterity: " + Enemy.dexterity, displayX - 175,
				displayY - 125, textPaint);
		canvas.drawText("Intelligence: " + Enemy.intelligence,
				displayX - 175, displayY - 100, textPaint);

		forEnemy.DrawEnemyBars(canvas);

	}

	public void Sleep(int time) {

		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void Draw(Canvas canvas) {

		MakePaint();

		if (!MainActivity.startBattle)
			PopUpMenu(canvas);

		else {
			
			if (BattleStuff.firstEncounter == 0) {
				Enemy.RandomizeMobs();
			}

			InBattle(canvas);
			
			if (BattleStuff.killedEnemy)
				KilledEnemyPopUp(canvas);
			
			else if (BattleStuff.dead)
				Dead(canvas);
			
			DrawEnemyHealthFirst: {

				if (BattleStuff.didSomething && !BattleStuff.killedEnemy) {
					
					if (count != 1) {
						count++;
						break DrawEnemyHealthFirst;
					}
					
					Sleep(1000);
					stuff.EnemyAttack();
					BattleStuff.didSomething = false;
					count = 0;
				}

			}

			BattleStuff.firstEncounter++;
			
		}

	}

}
