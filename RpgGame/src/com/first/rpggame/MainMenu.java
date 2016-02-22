package com.first.rpggame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainMenu extends Activity implements OnClickListener{

	Button start;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.mainmenu);
		
		start = (Button) findViewById(R.id.bStartGame);
		start.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch(v.getId()) {
		
		case R.id.bStartGame:
			
			Intent i = new Intent(MainMenu.this, MainActivity.class);
			startActivity(i);
			
			break;
		
		}
		
	}
	
	

}
