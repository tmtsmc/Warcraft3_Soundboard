package com.example.warcraft3soundboard;

import java.util.ArrayList;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

public class MainActivity extends Activity implements View.OnClickListener, OnItemClickListener {
	private MediaPlayer currentMediaPlayer = null;
	private int currentMenu = 0;
	private int previousMenu = 0;
	private Integer[] menu = {R.layout.activity_main, R.layout.activity_human, R.layout.activity_orc, R.layout.activity_nightelf, R.layout.activity_undead, R.layout.activity_neutral, R.layout.activity_favorite, R.layout.activity_unit};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	    GridView gridview = (GridView) findViewById(R.id.gridview);
	    gridview.setAdapter(new ImageAdapter(this, 0));
	    gridview.setOnItemClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		if (currentMediaPlayer == null) {
			setContentView(R.layout.activity_human);
			MediaPlayer media = MediaPlayer.create(this, R.raw.goblinzeppelinyes4);
			currentMediaPlayer = media;
	        media.setOnCompletionListener(new OnCompletionListener() {
	
	            @Override
	            public void onCompletion(MediaPlayer mp) {
	                mp.release();
	                currentMediaPlayer = null;
	            }
	
	        });   
	        media.start();
		}
	}
	
	public void playSound(Integer sound) {
		if (currentMediaPlayer == null) {
			MediaPlayer media = MediaPlayer.create(this, sound);
			currentMediaPlayer = media;
	        media.setOnCompletionListener(new OnCompletionListener() {
	
	            @Override
	            public void onCompletion(MediaPlayer mp) {
	                mp.release();
	                currentMediaPlayer = null;
	            }
	
	        });   
	        media.start();
		}
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		if (currentMediaPlayer != null) {
			currentMediaPlayer.release();
		}
	}
	
	@Override
	public void onBackPressed() {
		if (currentMenu == 0) { // Main Menu
			super.onBackPressed();
		} else if (currentMenu < 7) { // Unit selection menu 
			setCurrentMenu(0);
		} else { // Unit sound selection menu
			setCurrentMenu(previousMenu);
		}
	}
	
	public void setCurrentMenu(int id) {
		setContentView(menu[id]);
		if (id < 7) {
			GridView gridview = (GridView) findViewById(R.id.gridview);
		    gridview.setAdapter(new ImageAdapter(this, id));
		    gridview.setOnItemClickListener(this);
		}
	    previousMenu = currentMenu;
	    currentMenu = id;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
		if (currentMenu == 0) { // Main Menu
			setCurrentMenu(position + 1);
		} else if (currentMenu < 7) { // Unit selection menu 
			// Show sound selection menu
			setCurrentMenu(7);
			ListView listview = (ListView) findViewById(R.id.listview);
			ListAdapter adapter = new ListAdapter(this, R.layout.unit_item, position);
			listview.setAdapter(adapter);
			listview.setOnItemClickListener(this);
		} else { // Unit sound selection menu
			ListView listview = (ListView) findViewById(R.id.listview);
			ListAdapter adapter = (ListAdapter) listview.getAdapter();
			playSound(adapter.sounds.get(position));
		}
	}

}
