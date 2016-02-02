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
public class TwitterUpdater extends AsyncTask<Long, Void, Void> {

    private final NetworkAdapter adapter;
    private Activity activity;

    public TwitterUpdater(Activity activity, NetworkAdapter adap) {
        this.adapter =adap;
        this.activity = activity;
    }

    @Override
    protected Void doInBackground(Long... params) {
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

            //Log.d("[TWEET]","  -- Voy a cargar a partir de id:"+params[0]);
            ArrayList<Tweet> tweets=t.update(15, params[0], Configuration.HASTAGS);
            ArrayList<NetworkContent> tweets2=new ArrayList<NetworkContent>();
            tweets2.addAll(tweets);
            for (int i=0; i<tweets2.size(); i++){
                adapter.getContenido().add(0,tweets2.get(i));
            }
            adapter.setMax_id(adapter.getContenido().get(0).getId());

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
