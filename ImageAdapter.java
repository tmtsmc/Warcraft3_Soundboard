package com.example.warcraft3soundboard;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private Integer[] currentTumbId = null;

    public ImageAdapter(Context c, int i) {
        mContext = c;
        if (i == 0) {
        	currentTumbId = thumbIdMain;
        } else if (i == 1) {
        	currentTumbId = thumbIdHuman;
        } else if (i == 2) {
        	currentTumbId = thumbIdOrc;
        } else if (i == 3) {
        	currentTumbId = thumbIdNightelf;
        } else if (i == 4) {
        	currentTumbId = thumbIdUndead;
        } else if (i == 5) {
        	currentTumbId = thumbIdNeutral;
        } else if (i == 6) {
        	currentTumbId = thumbIdFavorite;
        } 
        
    }

    public int getCount() {
        return currentTumbId.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        imageView = new ImageView(mContext);
        imageView.setImageResource(currentTumbId[position]);
        return imageView;
    }

    private Integer[] thumbIdMain = {
            R.drawable.humanseal, R.drawable.orcseal, R.drawable.nightelfseal, R.drawable.undeadseal, R.drawable.neutralseal, R.drawable.favoriteseal
    };
    
    private Integer[] thumbIdHuman = {R.drawable.footman, R.drawable.gryphonrider, R.drawable.gyrocopter, R.drawable.knight, R.drawable.mortarteam, R.drawable.peasant, R.drawable.priest, R.drawable.rifleman, R.drawable.sorceress, R.drawable.steamtank};

    
    private Integer[] thumbIdOrc = {R.drawable.demolisher, R.drawable.grunt, R.drawable.headhunter, R.drawable.kotobeast, R.drawable.peon, R.drawable.raider, R.drawable.shaman, R.drawable.tauren, R.drawable.witchdoctor, R.drawable.wyvernrider};
    
    private Integer[] thumbIdNightelf = {
            R.drawable.nightelfseal
    };
    
    private Integer[] thumbIdUndead = {
            R.drawable.undeadseal
    };
    
    private Integer[] thumbIdNeutral = {
            R.drawable.neutralseal
    };
    
    private Integer[] thumbIdFavorite = {
            R.drawable.favoriteseal
    };
}