package com.android.leaftionary.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.leaftionary.R;
import com.android.leaftionary.model.PlantModel;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Kevin on 12/6/2014.
 */
public class PlantListAdapter extends BaseAdapter {

    Context context;
    ArrayList<PlantModel> plants;
    Random rand;

    public PlantListAdapter(Context context, ArrayList<PlantModel> plants) {
        this.context = context;
        this.plants = plants;
        rand = new Random();

    }

    @Override
    public int getCount() {
        return plants.size();
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
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();

            convertView = View.inflate(context, R.layout.activity_plantlist_itemview, null);
            holder.plantImage = (ImageView)convertView.findViewById(R.id.plantImage);
            holder.plantName = (TextView)convertView.findViewById(R.id.plantName);
            holder.plantDetail = (TextView)convertView.findViewById(R.id.plantPrimeDetail);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }

        holder.plantImage.setBackgroundColor(Color.argb(255, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
        holder.plantName.setText(plants.get(position).plantName);
        holder.plantDetail.setText(plants.get(position).plantCommonNames);

        return convertView;
    }

    static class ViewHolder{
        TextView plantName;
        TextView plantDetail;
        ImageView plantImage;
    }
}
