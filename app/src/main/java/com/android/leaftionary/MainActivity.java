package com.android.leaftionary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.android.leaftionary.helper.Utilities;


public class MainActivity extends Activity implements View.OnClickListener{

    ImageButton cameraBtn;
    ImageButton bookBtn;
    ImageButton questionBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cameraBtn = (ImageButton)findViewById(R.id.cameraBtn);
        cameraBtn.setOnClickListener(this);

        bookBtn = (ImageButton)findViewById(R.id.bookBtn);
        bookBtn.setOnClickListener(this);

        questionBtn = (ImageButton)findViewById(R.id.questionBtn);
        questionBtn.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.cameraBtn:
                break;
            case R.id.bookBtn:
                Intent intent = new Intent(this, PlantListActivity.class);
                startActivity(intent);
                break;
            case R.id.questionBtn:
                break;
        }
    }

    @Override
    protected void onResume() {
        if(Utilities.checkDatabase(getApplicationContext())){
            String res = Utilities.SendJSONRequest("http://localhost/herbal/public/json/plants.json");
            if(res != null){
                Log.e("JSONString", res);
            }
        }
    }
}
