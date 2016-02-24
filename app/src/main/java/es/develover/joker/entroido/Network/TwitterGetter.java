package es.develover.joker.entroido.Network;

import android.app.Activity;
import android.os.AsyncTask;

import es.develover.joker.entroido.Activities.MainActivity;
import es.develover.joker.entroido.Adapters.NetworkAdapter;
import es.develover.joker.entroido.Configuration;
import es.develover.joker.entroido.Model.NetworkContent;
import es.develover.joker.entroido.Model.Tweet;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by snooze on 27/01/16.
 */
public class TwitterGetter extends AsyncTask<Void, Void, Void> {

    private final NetworkAdapter adapter;
    private Activity activity;

    public TwitterGetter(Activity activity, NetworkAdapter netAdap) {
        this.adapter = netAdap;
        this.activity = activity;
    }

    @Override
    protected Void doInBackground(Void... params) {
        if (!new ConnectionDetector(activity).isConnectingToInternet()){
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    ((MainActivity)activity).internetDialog();
                }
            });
            return null;
        }
        try {
            Twitah t = new Twitah();
            t.autentificarOAUTH2();

            ArrayList<Tweet> tweets=new ArrayList<Tweet>();
            ArrayList<NetworkContent> tweets2=new ArrayList<NetworkContent>();
            tweets=t.tweetsPorHashtag(7, Configuration.HASTAGS);
            tweets2.addAll(tweets);
            adapter.setContenido(tweets2);

            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    adapter.notifyDataSetChanged();
                    adapter.setDone(true);
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Twitah.Oauth2Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
