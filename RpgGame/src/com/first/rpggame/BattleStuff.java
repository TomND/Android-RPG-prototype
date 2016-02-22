package com.first.rpggame;

import android.view.View;

public class BattleStuff {
	
	public static int firstEncounter = 0;
	public static boolean didSomething, killedEnemy, dead = false;
	
	// WHEN USER PRESSES ATTACK IN A BATTLE
	public void Attack() {
		
		// RIGHT NOW ONLY ONE BASIC ATTACK
		if (!didSomething) { // DIDSOMETHING IS TO MAKE SURE THE USER DOESNT SPAM ATTACK
			
			double damageDealt;
			damageDealt = PlayerStats.strength - ((double)Enemy.defence * 0.3);
		
			int generateRandom = (int)(((damageDealt + 5) - (damageDealt - 5) + 1) * Math.random() + (damageDealt - 5));
		
			if (generateRandom <= 0) {
				generateRandom = (int)((5 - 1 + 1) * Math.random() + 1);
			}
			
			Enemy.currentHealth -= generateRandom;
			
			if (Enemy.currentHealth <= 0) {
				didSomething = false;
				killedEnemy = true;
				MainActivity.finishBattleButton.setVisibility(View.VISIBLE);
			}
			
			didSomething = true;
		}
		
		
	}
	
	// WHEN USER PRESSES ITEMS IN A BATTLE
	public void Items() {
		
	}
	
	// WHEN USER PRESSES RUN IN A BATTLE
	public void Run() {
		
		ChangeProperButtons();
		
		if (ButtonInputs.runLostHealth == true) {
			
			// PLAYER LOSES HEALTH WHILE RUNNING AWAY
			double lostHealth = (int)(((((double)PlayerStats.health * 0.10) + 5) - (((double)PlayerStats.health * 0.10) - 5) + 1) 
					* Math.random() + (((double)PlayerStats.health * 0.10) - 5));
			
			PlayerStats.currentHealth = PlayerStats.currentHealth - (int) lostHealth;
			
			// ADD SOME SORT OF NOTIFICATION MAYBE A TOAST OR SOMETHING
			
			ButtonInputs.runLostHealth = false;
			
		}
	}
	
	public void EnemyAttack() {
		
		double damageDealt;
		damageDealt = Enemy.strength - ((double)PlayerStats.defence * 0.3);
	
		int generateRandom = (int)(((damageDealt + 5) - (damageDealt - 5) + 1) * Math.random() + (damageDealt - 5));
		
		if (generateRandom <= 0) {
			generateRandom = (int)((5 - 1 + 1) * Math.random() + 1);
		}
	
		PlayerStats.currentHealth -= generateRandom;
		
		if (PlayerStats.currentHealth <= 0) {
			firstEncounter = 0;
		}
		
	}
	
	public static void ChangeProperButtons() {
		
		MainActivity.startBattle = false;
		BattleMenu.fight = false;
		didSomething = false;
		killedEnemy = false;
		dead = false;
		firstEncounter = 0;

		MainActivity.finishBattleButton.setVisibility(View.INVISIBLE);
		MainActivity.up.setVisibility(View.VISIBLE);
		MainActivity.down.setVisibility(View.VISIBLE);
		MainActivity.right.setVisibility(View.VISIBLE);
		MainActivity.left.setVisibility(View.VISIBLE);
		MainActivity.itemsButton.setVisibility(View.INVISIBLE);
		MainActivity.attackButton.setVisibility(View.INVISIBLE);
		MainActivity.runButton.setVisibility(View.INVISIBLE);
		
	}

}
