package com.abhishek.tempmapproject;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Abhishek on 05-06-2015.
 */
public class MainActivity extends Fragment implements AdapterView.OnItemClickListener {
    DrawerLayout drawer;
    ListView lv;
    String[] content;
    MyAdapter myad;

    View v;
    private ActionBarDrawerToggle abdt;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.activity_main, container, false);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lv = (ListView) v.findViewById(R.id.drawerlist);
        content = v.getResources().getStringArray(R.array.itemslist);
        myad = new MyAdapter(v.getContext());
        lv.setAdapter(myad);
        //lv.setAdapter(new ArrayAdapter<>(v.getContext(), android.R.layout.simple_list_item_1,content));
        lv.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("Drawer Message", "Item " + position + " Clicked");
        Toast.makeText(v.getContext(), "Item " + position + " Clicked", Toast.LENGTH_SHORT).show();
    }

}

class MyAdapter extends BaseAdapter {
    Context context;
    String[] content;
    int[] picture = {android.R.drawable.ic_dialog_alert, android.R.drawable.ic_dialog_dialer, android.R.drawable.ic_dialog_email, android.R.drawable.ic_dialog_info, android.R.drawable.ic_dialog_map, android.R.drawable.btn_star};

    public MyAdapter(Context context) {
        this.context = context;
        content = context.getResources().getStringArray(R.array.itemslist);
    }

    @Override
    public int getCount() {
        return content.length;
    }

    @Override
    public Object getItem(int position) {
        return content[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = null;
        if (convertView == null) {
            LayoutInflater inflating = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflating.inflate(R.layout.custom_nav_drawer, parent, false);

        } else {
            row = convertView;
        }
        TextView titletv = (TextView) row.findViewById(R.id.custumtv);
        ImageView titleiv = (ImageView) row.findViewById(R.id.imageView1);
        titletv.setText(content[position]);
        titleiv.setImageResource(picture[position]);
        return row;
    }
}
