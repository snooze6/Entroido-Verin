package es.develover.joker.entroido.Activities;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import es.develover.joker.entroido.R;

public class ColaboradoresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colaboradores);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Log.d("ROTATE: ",""+isTablet());
        if (!isTablet()) {
            // stop screen rotation on phones because <explain>
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER_PORTRAIT);
        }
    }

    private boolean isTablet() {
        return (this.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

}
