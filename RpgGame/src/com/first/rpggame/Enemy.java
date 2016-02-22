package com.first.rpggame;

import java.util.Random;

public class Enemy {
	
	public static String enemyName = "";
	
	public static int health = 75;
	public static int currentHealth = 75;
	public static int mana = 75;
	public static int currentMana = 75;
	public static int strength = 15;
	public static int defence = 15;
	public static int dexterity = 20;
	public static int intelligence = 20;
	
	public static void NewEnemy(String mobName) {
		
		if (mobName.equalsIgnoreCase("Bandit")) {
			enemyName = mobName;
			health = 100;
			currentHealth = 100;
			mana = 75;
			currentMana = 75;
			strength = 15;
			defence = 10;
			dexterity = 20;
			intelligence = 20;
		}
		
		else if (mobName.equalsIgnoreCase("Goblin")) {
			enemyName = mobName;
			health = 75;
			currentHealth = 75;
			mana = 75;
			currentMana = 75;
			strength = 20;
			defence = 15;
			dexterity = 20;
			intelligence = 20;
		}
		
		else if (mobName.equalsIgnoreCase("Golem")) {
			enemyName = mobName;
			health = 125;
			currentHealth = 125;
			mana = 75;
			currentMana = 75;
			strength = 5;
			defence = 15;
			dexterity = 20;
			intelligence = 20;
		}
		
		else if (mobName.equalsIgnoreCase("Skeleton")) {
			enemyName = mobName;
			health = 85;
			currentHealth = 85;
			mana = 75;
			currentMana = 75;
			strength = 13;
			defence = 13;
			dexterity = 20;
			intelligence = 20;
		}
		
	}
	
	public static void RandomizeMobs() {
		
		Random r = new Random();
		
		int num = r.nextInt(4);
		
		if (num == 0)
			NewEnemy("Bandit");
		
		else if (num == 1)
			NewEnemy("Goblin");
		
		else if (num == 2) 
			NewEnemy("Golem");
		
		else if (num == 3)
			NewEnemy("Skeleton");
		
	}

}
