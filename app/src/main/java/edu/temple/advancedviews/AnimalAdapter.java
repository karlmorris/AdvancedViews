package edu.temple.advancedviews;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Random;

public class AnimalAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> animals;

    public AnimalAdapter (Context context, ArrayList<String> animals) {
        this.context = context;
        this.animals = animals;
    }

    @Override
    public int getCount() {
        return animals.size();
    }

    @Override
    public Object getItem(int position) {
        return animals.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int colors[] = new int[5];
        colors[0] = Color.BLUE;
        colors[1] = Color.GREEN;
        colors[2] = Color.LTGRAY;
        colors[3] = Color.MAGENTA;
        colors[4] = Color.RED;

        TextView textView;
        if (convertView == null) {
            textView = new TextView(context);
            textView.setPadding(5,5,5,5);
            textView.setTextSize(22);
        }
        else
            textView = (TextView) convertView;

        textView.setText(getItem(position).toString());
        textView.setBackgroundColor(colors[position % colors.length]);

        return textView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = getView(position, convertView, parent);
        v.setBackgroundColor(Color.LTGRAY);
        return v;
    }
}
