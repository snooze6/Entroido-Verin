package es.develover.joker.entroido.Network;

import android.content.Context;
import android.os.AsyncTask;

import es.develover.joker.entroido.Adapters.NetworkAdapter;
import es.develover.joker.entroido.Model.NetworkContent;
import es.develover.joker.entroido.Model.Tweet;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by snooze on 27/01/16.
 */
public class TwitterUpdater extends AsyncTask<Long, String, ArrayList<Tweet>> {

    private NetworkAdapter netAdap=null;
    private Context c = null;

    public TwitterUpdater() {
    }

    public TwitterUpdater(NetworkAdapter adap) {
        this.netAdap=adap;
    }

    public TwitterUpdater(Context c) {
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

            ArrayList<Tweet> tweets=t.update("verin", 10, params[0]);
            ArrayList<NetworkContent> tweets2=new ArrayList<NetworkContent>();

            tweets2.addAll(tweets);
            netAdap.getContenido().addAll(tweets2);


            return tweets;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Twitah.Oauth2Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<Tweet>();
    }
}
