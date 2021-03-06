package com.example.a2ramae45.mapping;

        import android.app.Activity;
        import android.content.SharedPreferences;
        import android.os.Bundle;
        import android.preference.PreferenceManager;
        import org.osmdroid.views.MapView;
        import org.osmdroid.util.GeoPoint;
        import org.osmdroid.config.Configuration;
        import android.view.Menu;
        import android.view.MenuInflater;
        import android.view.MenuItem;
        import android.content.Intent;
        import org.osmdroid.tileprovider.tilesource.TileSourceFactory;

public class HelloMap extends Activity
{

    MapView mv;

    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // this line tells OpenStreetMap about our app.
        // If you miss this out, you might get banned from OSM servers
        Configuration.getInstance().load
                (this, PreferenceManager.getDefaultSharedPreferences(this));

        mv = (MapView)findViewById(R.id.map1);

        mv.setBuiltInZoomControls(true);
        mv.getController().setZoom(14);
        mv.getController().setCenter(new GeoPoint(40.1,22.5));
    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_hello_map, menu);
        inflater.inflate(R.menu.menu_location_set, menu);
        inflater.inflate(R.menu.preferences, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item)
    {


        if(item.getItemId() == R.id.choosemap)
        {
            // react to the menu item being selected...
            Intent intent = new Intent(this,MapChooseActivity.class);
            startActivityForResult(intent,0);
            return true;
        }


        if(item.getItemId() == R.id.setLocationMap) {
            Intent intent = new Intent(this,SetLocation.class);
            startActivityForResult(intent, 1);
            return true;
        }

        if(item.getItemId() == R.id.preferences) {
            Intent intent = new Intent(this,MyPrefActivity.class);
            startActivityForResult(intent, 2);
            return true;
        }


        return false;
    }

    protected void onActivityResult(int requestCode,int resultCode,Intent intent)
    {

        if(requestCode==0)
        {

            if (resultCode==RESULT_OK)
            {
                Bundle extras=intent.getExtras();
                boolean cyclemap = extras.getBoolean("com.example.cyclemap");
                if(cyclemap==true)
                {
                    mv.setTileSource(TileSourceFactory.CYCLEMAP);
                }
                else
                {
                    mv.getTileProvider().setTileSource(TileSourceFactory.MAPNIK);
                }
            }
        }

        if(requestCode==1) {
            if(resultCode==RESULT_OK)
            {

                Bundle extras=intent.getExtras();
                Double lat = extras.getDouble("com.example.lat");
                Double lon = extras.getDouble("com.example.lon");
                mv.getController().setCenter(new GeoPoint(lat,lon));
            }
        }

    }

    public void onStart() {
        super.onStart();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        double lat = Double.parseDouble ( prefs.getString("lat", "50.9"));
        double lon = Double.parseDouble ( prefs.getString("lon", "-1.4"));
        mv.getController().setCenter(new GeoPoint(lat,lon));


    }



}