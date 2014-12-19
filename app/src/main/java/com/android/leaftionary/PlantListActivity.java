package com.android.leaftionary;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.leaftionary.adapter.PlantListAdapter;
import com.android.leaftionary.fragment.PlantDetailFragment;
import com.android.leaftionary.model.PlantModel;

import java.util.ArrayList;

/**
 * Created by Kevin on 12/6/2014.
 */
public class PlantListActivity extends Activity {

    PlantListAdapter adapter;
    ListView listView;
    ArrayList<PlantModel> plants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plantlist);

        getActionBar().setDisplayHomeAsUpEnabled(true);

        listView = (ListView)findViewById(R.id.plantList);

        plants = new ArrayList<>();
        PlantModel model;
        for(int i=0;i<100;i++){
            model = new PlantModel();
            model.plantName = "Plant Name #"+(i+1);
            model.plantCommonNames = "Plant Detail #"+(i+1);
            plants.add(model);
        }

        adapter = new PlantListAdapter(this, plants);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                PlantDetailFragment pdf = new PlantDetailFragment();
                pdf.setModel(plants.get(position));
                ft.replace(R.id.container, pdf);
                ft.addToBackStack("plantdetailview");
                ft.commit();
            }
        });

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
