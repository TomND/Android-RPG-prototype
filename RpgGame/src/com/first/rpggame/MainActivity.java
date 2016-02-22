package com.first.rpggame;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class MainActivity extends Activity{

	// DIFFERENT CLASSES IN USE
	GameView gameView;
	Sprite sprite;
	Map mapClass;
	HealthAndMana healthAndMana;
	BattleStuff stuff;
	BattleMenu battle;
	FrameLayout game;
	RelativeLayout gameButtons;
	LayoutParams b1, b2, b3, b4, params, bFight, bAttack, bRun, bItems, finish;
	static Button up, down, left, right, fightButton, attackButton, runButton, finishBattleButton,
			itemsButton;
	static TextView tv;
	public static Handler mHandler;
	Bitmap character, map, battleMenu, loadingIcon, trees;
	ButtonInputs b;
	Collision collision;
	

	// DIFFERENT DATA TYPES IN USE
	public static int[][]
	public static float displayValueX, displayValueY;
	public static float x, y = 0;
	public static int previousX = (int) x;
	public static int previousY = (int) y;
	public static boolean startBattle = false; // THIS DETERMINES IF I PRESSED
												// THE FIGHT BUTTON TO START THE
												// BATTLE

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		mHandler = new Handler();

		CreateSprites();
		CreateButtons();
		CreateGameView();

	}
	

	public void CreateButtons() {
		
		b = new ButtonInputs();

		// This is the button code
		up = new Button(this);
		up.setWidth(100);
		up.setId(121250);
		up.setBackgroundResource(R.drawable.up);
		up.setOnTouchListener(b);

		down = new Button(this);
		down.setWidth(100);
		down.setId(12125);
		down.setBackgroundResource(R.drawable.down);
		down.setOnTouchListener(b);

		right = new Button(this);
		right.setWidth(100);
		right.setId(1212);
		right.setBackgroundResource(R.drawable.right);
		right.setOnTouchListener(b);

		left = new Button(this);
		left.setWidth(100);
		left.setId(121);
		left.setBackgroundResource(R.drawable.left);
		left.setOnTouchListener(b);

		fightButton = new Button(this);
		fightButton.setWidth(370);
		fightButton.setHeight(107);
		fightButton.setId(123);
		fightButton.setBackgroundResource(R.drawable.fightbutton);
		fightButton.setVisibility(View.INVISIBLE);
		fightButton.setOnTouchListener(b);

		attackButton = new Button(this);
		attackButton.setWidth(100);
		attackButton.setId(12);
		attackButton.setText("Attack");
		attackButton.setVisibility(View.INVISIBLE);
		attackButton.setOnTouchListener(b);

		itemsButton = new Button(this);
		itemsButton.setWidth(100);
		itemsButton.setId(21);
		itemsButton.setText("Items");
		itemsButton.setVisibility(View.INVISIBLE);
		itemsButton.setOnTouchListener(b);

		runButton = new Button(this);
		runButton.setWidth(100);
		runButton.setId(212);
		runButton.setText("Run");
		runButton.setVisibility(View.INVISIBLE);
		runButton.setOnTouchListener(b);
		
		finishBattleButton = new Button(this);
		finishBattleButton.setWidth(100);
		finishBattleButton.setId(2121);
		finishBattleButton.setText("Okay");
		finishBattleButton.setVisibility(View.INVISIBLE);
		finishBattleButton.setOnTouchListener(b);

		tv = new TextView(this);
		tv.setText("X: " + Map.checkX + " Y: " + Map.checkY);
		
		
		

		// This is the code for the UP button
		b1 = new LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		params = new LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT,
				RelativeLayout.LayoutParams.FILL_PARENT);
		b1.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
		b1.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
		b1.setMargins(0, 50, 200, 75);
		up.setLayoutParams(b1);

		// This is the code for the DOWN button
		b2 = new LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		b2.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
		b2.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
		down.setLayoutParams(b2);

		// This is the code for the RIGHT button
		b3 = new LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		b3.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
		b3.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
		right.setLayoutParams(b3);

		// This is the code for the LEFT button
		b4 = new LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		b4.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
		b4.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
		b4.setMargins(100, 50, 100, 0);
		left.setLayoutParams(b4);

		// STARTING A BATTLE
		bFight = new LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		bFight.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
		bFight.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
		bFight.setMargins(105, 400, 95, 0);
		fightButton.setLayoutParams(bFight);

		// PRESSING ATTACK IN BATTLE MENU
		bAttack = new LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		bAttack.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
		bAttack.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
		bAttack.setMargins(20, 3, 200, 3);
		attackButton.setLayoutParams(bAttack);

		bItems = new LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		bItems.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
		bItems.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
		bItems.setMargins(0, 3, 0, 3);
		itemsButton.setLayoutParams(bItems);

		bRun = new LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		bRun.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
		bRun.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
		bRun.setMargins(200, 3, 20, 3);
		runButton.setLayoutParams(bRun);
		
		finish = new LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		finish.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
		finish.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
		finishBattleButton.setLayoutParams(finish);
	}

	public void CreateGameView() {

		// This is the SurfaceView
		gameView = new GameView(this);

		// This is the linear layout code
		gameButtons = new RelativeLayout(this);
		gameButtons.setLayoutParams(params);
		gameButtons.addView(up);
		gameButtons.addView(down);
		gameButtons.addView(left);
		gameButtons.addView(right);
		gameButtons.addView(tv);
		gameButtons.addView(fightButton);
		gameButtons.addView(attackButton);
		gameButtons.addView(itemsButton);
		gameButtons.addView(runButton);
		gameButtons.addView(finishBattleButton);

		// This is the actual game
		game = new FrameLayout(this);
		game.addView(gameView);
		game.addView(gameButtons);

		setContentView(game);

	}

	public void CreateSprites() {

		character = BitmapFactory.decodeResource(getResources(),
				R.drawable.spritesheet);

		loadingIcon = BitmapFactory.decodeResource(getResources(),
				R.drawable.ic_launcher);

		map = BitmapFactory.decodeResource(getResources(), R.drawable.map_sand);

		battleMenu = BitmapFactory.decodeResource(getResources(),
				R.drawable.battlescene);
		
		trees = BitmapFactory.decodeResource(getResources(), R.drawable.trees);
		
		int yyy = 0;
		
		for(int x = 0; x<500;x++){
			
			if(trees.getPixel(x, 0) != -1){
				
			}
			trees.getPixel(x, 0);
		}
		//trees.getPixel(x, y)

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		gameView.pause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		gameView.resume();
	}

	
	public class GameView extends SurfaceView implements Runnable {

		SurfaceHolder ourHolder;
		Display display = getWindowManager().getDefaultDisplay();
		Thread ourThread = null;
		boolean isRunning = false;

		public GameView(Context context) {
			super(context);
			ourHolder = getHolder();
			displayValueX = display.getWidth();
			displayValueY = display.getHeight();
		}

		public void pause() {
			isRunning = false;

			while (true) {
				try {
					ourThread.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			}

			ourThread = null;

		}

		public void resume() {
			isRunning = true;
			ourThread = new Thread(this);
			ourThread.start();
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub

			while (isRunning) {

				if (!ourHolder.getSurface().isValid())
					continue;
				
				Canvas canvas = ourHolder.lockCanvas();

				sprite = new Sprite(character);
				mapClass = new Map(map);
				healthAndMana = new HealthAndMana();
				battle = new BattleMenu(battleMenu);
				stuff = new BattleStuff();
				collision = new Collision(trees, 100,0,65,45);
				
				//if(Map.charX >0 ){
					
				//}

				previousX = (int) x;
				previousY = (int) y;
				
				Draw(canvas);

				ourHolder.unlockCanvasAndPost(canvas);

			}
		}
	}

	protected void Draw(Canvas canvas) {

		//canvas.drawRGB(1, 1, 1);
		mapClass.Draw(canvas);
		sprite.Draw(canvas);
		collision.Draw(canvas);

		//if (BattleMenu.fight)
			//battle.Draw(canvas);

		healthAndMana.Draw(canvas);

	}
	
}