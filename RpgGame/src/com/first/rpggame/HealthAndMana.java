package com.first.rpggame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.first.rpggame.MainActivity.GameView;

public class HealthAndMana {

	GameView game;
	Paint border, background, hp, mp, textPaint;
	BattleStuff stuff = new BattleStuff();

	int displayX, displayY;

	public HealthAndMana() {

		displayX = (int) MainActivity.displayValueX;
		displayY = (int) MainActivity.displayValueY;

	}

	public void MakePaint() {

		border = new Paint();
		border.setColor(Color.BLACK);
		border.setStyle(Paint.Style.STROKE);

		background = new Paint();
		background.setColor(Color.GRAY);

		hp = new Paint();
		hp.setColor(Color.RED);

		mp = new Paint();
		mp.setColor(Color.BLUE);

		textPaint = new Paint();
		textPaint.setColor(Color.BLACK);
		;

	}

	public void Draw(Canvas canvas) {

		if (PlayerStats.currentHealth < 0)
			PlayerStats.currentHealth = 0;

		double hRatio = (double) PlayerStats.currentHealth
				/ (double) PlayerStats.health;
		int currentHealth = PlayerStats.currentHealth;
		int drawHealth = (int) (105.0 * hRatio);

		if (PlayerStats.currentMana < 0)
			PlayerStats.currentMana = 0;

		double mRatio = (double) PlayerStats.currentMana
				/ (double) PlayerStats.mana;
		int currentMana = PlayerStats.currentMana;
		int drawMana = (int) (105.0 * mRatio);

		MakePaint();

		canvas.drawRect(20, 40, 126, 50, background);
		canvas.drawRect(20, 40, 126, 50, border);
		canvas.drawRect(21, 41, drawHealth + 21, 50, hp);
		canvas.drawText("Health: " + currentHealth, 20, 37, textPaint);

		canvas.drawRect(20, 75, 126, 85, background);
		canvas.drawRect(20, 75, 126, 85, border);
		canvas.drawRect(21, 76, drawMana + 21, 85, mp);
		canvas.drawText("Mana: " + currentMana, 20, 72, textPaint);

	}

	public void DrawEnemyBars(Canvas canvas) {

		if (Enemy.currentHealth < 0)
			Enemy.currentHealth = 0;

		double hRatio = (double) Enemy.currentHealth
				/ (double) Enemy.health;
		int currentHealth = Enemy.currentHealth;
		int drawHealth = (int) (105.0 * hRatio);

		if (Enemy.currentMana < 0)
			Enemy.currentMana = 0;

		double mRatio = (double) Enemy.currentMana
				/ (double) Enemy.mana;
		int currentMana = Enemy.currentMana;
		int drawMana = (int) (105.0 * mRatio);

		MakePaint();

		canvas.drawRect(displayX - 126, 40, displayX - 20, 50, background);
		canvas.drawRect(displayX - 126, 40, displayX - 20, 50, border);
		canvas.drawRect(displayX - drawHealth - 20, 41, displayX - 20, 50, hp);
		canvas.drawText(Enemy.enemyName + " Health: " + currentHealth, displayX - 125, 37,
				textPaint);

		canvas.drawRect(displayX - 126, 75, displayX - 20, 85, background);
		canvas.drawRect(displayX - 126, 75, displayX - 20, 85, border);
		canvas.drawRect(displayX - drawMana - 20, 76, displayX - 20, 85, mp);
		canvas.drawText(Enemy.enemyName + " Mana: " + currentMana, displayX - 125, 72,
				textPaint);

	}
}
