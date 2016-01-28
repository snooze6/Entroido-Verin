package es.develover.joker.entroido.Network;

import android.os.AsyncTask;

import es.develover.joker.entroido.Adapters.NetworkAdapter;
import es.develover.joker.entroido.Model.NetworkContent;
import es.develover.joker.entroido.Model.Tweet;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by snooze on 27/01/16.
 */
public class TwitterGetter extends AsyncTask<String, String, ArrayList<Tweet>> {

    private NetworkAdapter netAdap=null;

    public TwitterGetter(NetworkAdapter netAdap) {
        this.netAdap = netAdap;
    }

    @Override
    protected ArrayList<Tweet> doInBackground(String... params) {
        try {
            Twitah t = new Twitah();
              t.autentificarOAUTH2();

            ArrayList<Tweet> tweets=new ArrayList<Tweet>();
            ArrayList<NetworkContent> tweets2=new ArrayList<NetworkContent>();
            tweets=t.tweetsPorHashtag(7,params);
            tweets2.addAll(tweets);
            netAdap.setContenido(tweets2);
            return tweets;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Twitah.Oauth2Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<Tweet>();
    }
}
