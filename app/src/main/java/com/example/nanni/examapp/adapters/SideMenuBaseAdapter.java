package com.example.nanni.examapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.nanni.examapp.R;

/**
 * Created by nanni...!!! on 5/22/2017.
 */

public class SideMenuBaseAdapter extends BaseAdapter {
    String[] menuText={"Home","e-Wallet","e-Documents","Take a Exam","Premium Exams","Exam Analysis","My Wallet",
            "Refer a Buddy","About","Logout"};
    @Override
    public int getCount() {
        return menuText.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_sidemenu_items,parent,false);

        TextView mSideMenuText=(TextView)convertView.findViewById(R.id.tv_sideMenuText);
        mSideMenuText.setText(menuText[position]);
        return convertView;
    }
}
