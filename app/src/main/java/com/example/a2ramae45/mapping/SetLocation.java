package com.example.a2ramae45.mapping;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;

/**
 * Created by 2ramae45 on 09/02/2017.
 */
public class SetLocation extends Activity implements View.OnClickListener {

    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sll);


        Button Search = (Button)findViewById(R.id.searchLocation);
        Search.setOnClickListener(this);
    }
public void onClick(View v)
{
    EditText latitude = (EditText)findViewById(R.id.latitudeBox);
    int lat = Integer.parseInt(latitude.getText().toString());
    EditText longitude = (EditText)findViewById(R.id.longitudeBox);
    int lon = Integer.parseInt(longitude.getText().toString());

    Intent intent = new Intent();
    Bundle bundle=new Bundle();
    bundle.putInt("com.example.lat", lat);
    bundle.putInt("com.example.lon", lon);
    intent.putExtras(bundle);
    setResult(RESULT_OK,intent);
    finish();


}


}
