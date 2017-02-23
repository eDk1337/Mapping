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
    double lat = Double.parseDouble(latitude.getText().toString());
    EditText longitude = (EditText)findViewById(R.id.longitudeBox);
    double lon = Double.parseDouble(longitude.getText().toString());

    Intent intent = new Intent();
    Bundle bundle=new Bundle();
    bundle.putDouble("com.example.lat", lat);
    bundle.putDouble("com.example.lon", lon);
    intent.putExtras(bundle);
    setResult(RESULT_OK,intent);
    finish();


}


}
