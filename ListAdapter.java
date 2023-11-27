package com.example.warcraft3soundboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.widget.ArrayAdapter;

class ListAdapter extends ArrayAdapter<String> {
	public ArrayList<Integer> sounds = new ArrayList<Integer>();
	public int id = 0;
	
	public ListAdapter(Context context, int textViewResourceId, int id) {
	  super(context, textViewResourceId, getSounds(id));
	  this.id  = id;
	  for (int i = 0; i < unities[id].length; i++) {
		  if (unities[id][i] != 0) {
			  sounds.add(unities[id][i]);
		  }
	  }
	}
	
	private static List<String> getSounds(int id) {
		List<String> values = new ArrayList<String>();
		for (int i = 0; i < unities[id].length; i++) {
			if (unities[id][i] != 0) {
				values.add(label[i]);
			}
		}
		return values;
	}
	
	private static String[] label = {"Pissed1", "Yes1", "Yes2"};
	
	static Integer[][] unities = {
			{0, R.raw.footmanyes1, R.raw.footmanyes2},
			{R.raw.gryphonriderpissed1, R.raw.gryphonrideryes1, R.raw.gryphonrideryes2}
		};
	
 }