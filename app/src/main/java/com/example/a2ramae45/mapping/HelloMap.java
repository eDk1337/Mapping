package com.example.a2ramae45.mapping;
import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceManager;
import org.osmdroid.views.MapView;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.config.Configuration;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;

public class HelloMap extends Activity implements View.OnClickListener
{

    MapView mv;

    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button submitButton = (Button)findViewById(R.id.submitButton);
        submitButton.setOnClickListener(this);

        // this line tells OpenStreetMap about our app.
        // If you miss this out, you might get banned from OSM servers
        Configuration.getInstance().load
                (this, PreferenceManager.getDefaultSharedPreferences(this));

        mv = (MapView)findViewById(R.id.map1);

        mv.setBuiltInZoomControls(true);
        mv.getController().setZoom(14);
        mv.getController().setCenter(new GeoPoint(40.1,22.5));
    }

    @Override
    public void onClick(View view) {
        EditText et = (EditText)findViewById(R.id.latitudeEditText);
        double latitude = Integer.parseInt(et.getText().toString());

        double latitude = 0;
        double longitude = 0;
        mv.getController().setCenter(new GeoPoint(latitude,longitude));
    }
}