package es.develover.joker.entroido.Activities;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.GridView;

import es.develover.joker.entroido.Adapters.PartyAdapter;
import es.develover.joker.entroido.Model.ContentProvider;
import es.develover.joker.entroido.R;

public class OrquestaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orquesta);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar()!=null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setTitle("Orquesta");
        GridView gridView= (GridView)findViewById(R.id.grid);
        gridView.setAdapter(new PartyAdapter(ContentProvider.orquestas, this));

        if(getResources().getBoolean(R.bool.portrait_only)){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            //Log.v(LOG_TAG, "HOOOME");
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }




}
