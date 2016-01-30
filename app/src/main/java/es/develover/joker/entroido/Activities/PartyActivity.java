package es.develover.joker.entroido.Activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import es.develover.joker.entroido.Adapters.FiestaAdapter;
import es.develover.joker.entroido.Model.ContentProvider;
import es.develover.joker.entroido.Model.Event;
import es.develover.joker.entroido.R;

public class PartyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView listView = (ListView) findViewById(R.id.listview_events);
        listView.setAdapter(new FiestaAdapter(ContentProvider.parties, this));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Event event = ContentProvider.parties.get(position);
                switch (position) {
                    case 0:
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/d/viewer?hl=es&hl=es&authuser=0&authuser=0&mid=zyvEGOd-KfmM.kJldpL7zlo5o"));
                        startActivity(intent);
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    default:
                        break;
                }

            }
        });

        if (getResources().getBoolean(R.bool.portrait_only)) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



}
