package com.example.pokemon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Mylistadapter extends BaseAdapter {
    Context c;
    ArrayList<Pokemon> pro;

    LayoutInflater inflater;
    private View.OnClickListener itemlisten;

    public Mylistadapter(Context c, ArrayList<Pokemon> pro) {
        this.c = c;
        this.pro = pro;
    }

    public Mylistadapter() {
    }

    @Override
    public int getCount() {
        return pro.size();
    }

    @Override
    public Object getItem(int position) {
        return pro.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    public void setOnItemClickListener(View.OnClickListener itemClickListener) {
        itemlisten = itemClickListener;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
        {
            inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }


        if(convertView == null)
        {
            convertView = inflater.inflate(R.layout.lstitem,parent,false);
        }


        ImageView pimg = convertView.findViewById(R.id.img_poke);
        TextView  pname = convertView.findViewById(R.id.txt_poke);

        Picasso.get().load(pro.get(position).getImage()).into(pimg);
        pname.setText(pro.get(position).getName());

        return convertView;
    }

}
