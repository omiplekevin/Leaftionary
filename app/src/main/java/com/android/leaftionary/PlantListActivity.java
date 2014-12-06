package com.android.leaftionary;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.widget.ListView;

import com.android.leaftionary.adapter.PlantListAdapter;
import com.android.leaftionary.model.PlantModel;

import java.util.ArrayList;

/**
 * Created by Kevin on 12/6/2014.
 */
public class PlantListActivity extends Activity {

    PlantListAdapter adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plantlist);

        getActionBar().setDisplayHomeAsUpEnabled(true);

        listView = (ListView)findViewById(R.id.plantList);

        ArrayList<PlantModel> plants = new ArrayList<>();
        PlantModel model;
        for(int i=0;i<100;i++){
            model = new PlantModel();
            model.plantName = "Plant Name #"+(i+1);
            model.plantDetail = "Plant Detail #"+(i+1);
            plants.add(model);
        }

        adapter = new PlantListAdapter(this, plants);
        listView.setAdapter(adapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
