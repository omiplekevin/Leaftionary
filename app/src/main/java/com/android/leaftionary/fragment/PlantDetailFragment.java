package com.android.leaftionary.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.android.leaftionary.R;
import com.android.leaftionary.model.PlantModel;

/**
 * Created by Kevin on 12/6/2014.
 */
public class PlantDetailFragment extends Fragment {

    View view;
    ListView listView;
    ImageView plantImage;
    PlantModel model;

    public void setModel(PlantModel model){
        this.model = model;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(view == null){
            view = inflater.inflate(R.layout.fragment_plantdetail_view, container, false);
        }

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView = (ListView)view.findViewById(R.id.plantDetailList);
        plantImage = (ImageView)view.findViewById(R.id.plantDetailImage);

        loadInformation();
    }

    private void loadInformation(){
        String[] items = {model.plantName,model.plantDetail,model.plantDetail,model.plantDetail,model.plantDetail,model.plantDetail,model.plantDetail};
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,items);
        listView.setAdapter(adapter);
    }
}
