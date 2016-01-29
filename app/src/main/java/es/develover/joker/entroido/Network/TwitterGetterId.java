package es.develover.joker.entroido.Network;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import es.develover.joker.entroido.Model.Tweet;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by snooze on 27/01/16.
 */
public class TwitterGetterId extends AsyncTask<Long, String, ArrayList<Tweet>> {

    private Context c = null;

    public TwitterGetterId() {
    }

    public TwitterGetterId(Context c) {
        this.c = c;
    }

    @Override
    protected ArrayList<Tweet> doInBackground(Long... params) {
        try {
            Twitah t;
            if (c!=null) {
                t = new Twitah(c);
            } else {
                t = new Twitah();
            }
            t.autentificarOAUTH2();
            Log.d("[TWEET]", "  -- Voy a cargar a partir de id:" + params[0]);
            ArrayList<Tweet> tw=t.tweetsPorHashtag(15, params[0], "verin", "entroidoverin", "entroidoverin2016", "verin2016","entroidoverin16","carnavalVerin","carnavalVerin16");
            Log.d("DFJKÑFH","ARRAY SIZE: "+tw.size());
            return tw;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Twitah.Oauth2Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<Tweet>();
    }
}
