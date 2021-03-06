package com.example.myfirstapp;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

@SuppressLint("NewApi")
public class DisplayMessageActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_message);
		// Show the Up button in the action bar.
		setupActionBar();
		
		// Get the message from the intent
		Intent intent = getIntent();
		String name = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
		
		if (name.isEmpty()){
			name = "you";
		}
		else {
			name = (Character.toUpperCase(name.charAt(0))) + name.substring(1);
		}
		
		Random randomGenerator = new Random();
		
		int msgIndex = randomGenerator.nextInt(4);
		
		String message;
			
		switch (msgIndex){
			case 0:
				message = "Hey, "+ name + ". Looking good there!";
				break;
			case 1:
				message = "Hang in there, "+ name + "!";
				break;
			case 2:
				message = "Keep going, "+ name + ". Just a bit more!";
				break;
			case 3:
				message = name + ", jiayou!";
				break;
			default:
				message = "Hey, "+ name + ". Looking good there!";
				break;
		}
		
		// Create the text view
		TextView textView = new TextView(this);
		textView.setTextSize(40);
		textView.setText(message);
		
		// Set the text view as the activity layout
		setContentView(textView);
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@SuppressLint("NewApi")
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
