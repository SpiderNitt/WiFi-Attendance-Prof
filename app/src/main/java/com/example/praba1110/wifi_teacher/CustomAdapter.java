package com.example.praba1110.wifi_teacher;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by praba1110 on 6/10/15.
 */
public class CustomAdapter extends ArrayAdapter<String> {
    Activity context;
    String[] rnos;
    public CustomAdapter(Activity context, String[] stuff) {
        super(context,R.layout.singlerow, stuff);
        this.rnos=stuff;
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View v=inflater.inflate(R.layout.singlerow, null, true);
        TextView rno= (TextView) v.findViewById(R.id.textView2);
        rno.setText(rnos[position]);
        return v;
    }
}
