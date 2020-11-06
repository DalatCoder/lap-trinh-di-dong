package com.example.lab02_bai05;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomGridView extends BaseAdapter {

    private final Context context;
    private final String[] titles;
    private final Integer[] contributors;
    private final Integer[] imageIDs;

    public CustomGridView(Context context, String[] titles, Integer[] contributors, Integer[] imageIDs) {
        this.context = context;
        this.titles = titles;
        this.contributors = contributors;
        this.imageIDs = imageIDs;
    }


    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public Object getItem(int position) {
        return titles[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            grid = new View(context);
            grid = inflater.inflate(R.layout.custom_grid_view, null);
            ImageView imageView = (ImageView) grid.findViewById(R.id.image);
            TextView txtTitle = (TextView) grid.findViewById(R.id.title);
            TextView txtContributor = (TextView) grid.findViewById(R.id.contributor);

            imageView.setImageResource(imageIDs[position]);
            txtTitle.setText(titles[position]);
            txtContributor.setText(contributors[position].toString());
        }
        else {
            grid = (View) convertView;
        }

        return grid;
    }
}
