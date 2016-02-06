package es.develover.joker.entroido.Activities;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;

import es.develover.joker.entroido.Adapters.HistoryAdapter;
import es.develover.joker.entroido.Model.ContentProvider;
import es.develover.joker.entroido.R;

public class CigarronActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cigarron);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.setTitle("Cigarrones");

        if (getSupportActionBar()!=null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ListView listView = (ListView)findViewById(R.id.listview_events);
        listView.setAdapter(new HistoryAdapter(ContentProvider.cigarron, this));

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
