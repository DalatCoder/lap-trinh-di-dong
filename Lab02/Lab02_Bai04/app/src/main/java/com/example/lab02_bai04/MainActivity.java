package com.example.lab02_bai04;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.sql.Struct;
import java.util.List;

class CustomListAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] mainTitle;
    private final String[] subTitle;
    private final Integer[] imageID;

    public CustomListAdapter(Activity context, String[] mainTitle, String[] subTitle, Integer[] imageID) {
        super(context, R.layout.mylist, mainTitle);

        this.context = context;
        this.mainTitle = mainTitle;
        this.subTitle = subTitle;
        this.imageID = imageID;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.mylist, null, true);

        TextView titleText = (TextView) rowView.findViewById(R.id.title);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView subTitleText = (TextView) rowView.findViewById(R.id.subtitle);

        titleText.setText(mainTitle[position]);
        imageView.setImageResource(imageID[position]);
        subTitleText.setText(subTitle[position]);

        return rowView;
    }
}

public class MainActivity extends AppCompatActivity {

    ListView listView;

    String[] mainTitle = {
            "Mercury",
            "Venus",
            "Earth"
    };

    String[] subTitle = {
            "A small, rocky planet",
            "A small, rocky planet blanketed in a thick layer of yellowish clouds.",
            "A small, rocky planet which supports a variety of life!"
    };

    Integer[] imageID = {
            R.drawable.mercury,
            R.drawable.venus,
            R.drawable.earth
    };

    private void init() {
        listView = (ListView) findViewById(R.id.listView);

        CustomListAdapter adapter = new CustomListAdapter(this, mainTitle, subTitle, imageID);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }
}