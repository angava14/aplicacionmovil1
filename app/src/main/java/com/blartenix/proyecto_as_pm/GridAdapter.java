package com.blartenix.proyecto_as_pm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Andres on 9/17/2017.
 */

public class GridAdapter extends BaseAdapter {

    Context context;
    private final String [] values;
    View view;
    LayoutInflater layoutInflater;

    public GridAdapter(Context context, String[] values) {
        this.context = context;
        this.values = values;
    }

    @Override
    public int getCount() {
        return values.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null ){
            view= new View (context);
            view = layoutInflater.inflate(R.layout.singleitem, null);
            TextView textview = (TextView) view.findViewById(R.id.textView);
            textview.setText(values[position]);
        }
return view;
    }
}
