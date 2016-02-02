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
public class TwitterGetterId extends AsyncTask<Long, Void, Void> {

    private NetworkAdapter adapter;
    private Activity activity;

    public TwitterGetterId(Activity act,NetworkAdapter adapter) {
        this.activity =act;
        this.adapter=adapter;
    }

    @Override
    protected Void doInBackground(Long... params){
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

            //Log.d("[TWEET]", "  -- Voy a cargar a partir de id:" + params[0]);
            ArrayList<Tweet> tw=t.tweetsPorHashtag(15, params[0], Configuration.HASTAGS);

            if(adapter != null){
                ArrayList<NetworkContent> adap=adapter.getContenido();
                adap.addAll(tw);
                //adapter.setMin_id(adapter.getContenido().get(adapter.getContenido().size() - 1).getId());
                adapter.setContenido(adap);

                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                        adapter.setDone(true);
                    }
                });
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (Twitah.Oauth2Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
