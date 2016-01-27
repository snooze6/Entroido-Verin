package es.develover.joker.entroido.Network;

import android.content.Context;
import android.os.AsyncTask;
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
            return t.tweetsPorHashtag("verin", 30, params[0]);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Twitah.Oauth2Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<Tweet>();
    }
}
