package com.android.leaftionary.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.leaftionary.R;
import com.android.leaftionary.model.PlantModel;

/**
 * Created by Kevin on 12/18/2014.
 */
public class PlantDetailListAdapter extends BaseAdapter {

    Context context;
    PlantModel plantModel;

    public PlantDetailListAdapter(Context context, PlantModel plantModel){
        this.context = context;
        this.plantModel = plantModel;
    }

    @Override
    public int getCount() {
        return 8;
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
            convertView = View.inflate(context, R.layout.fragment_plantdetail_viewitem, null);

            holder.detailLabel = (TextView)convertView.findViewById(R.id.textView);
            holder.detailContent = (TextView)convertView.findViewById(R.id.textView2);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }

        String label = "";
        String content = "";

        switch (position){
            case 0:
                label = "Scientific Names";
                content = plantModel.plantSciNames;
                break;
            case 1:
                label = "Common Names";
                content = plantModel.plantCommonNames;
                break;
            case 2:
                label = "Vernacular Names";
                content = plantModel.plantVernacularNames;
                break;
            case 3:
                label = "Description";
                content = plantModel.plantDescription;
                break;
            case 4:
                label = "Distribution";
                content = plantModel.plantDistribution;
                break;
            case 5:
                label = "Constituents";
                content = plantModel.plantConstituents;
                break;
            case 6:
                label = "Properties";
                content = plantModel.plantProperties;
                break;
            case 7:
                label = "Parts Used";
                content = plantModel.plantPartsUsed;
                break;
        }

        holder.detailLabel.setText(label);
        holder.detailContent.setText(content);

        return convertView;
    }

    static class ViewHolder{
        TextView detailLabel;
        TextView detailContent;
    }
}
