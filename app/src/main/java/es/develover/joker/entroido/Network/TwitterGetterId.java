package es.develover.joker.entroido.Network;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import es.develover.joker.entroido.Adapters.NetworkAdapter;
import es.develover.joker.entroido.Model.NetworkContent;
import es.develover.joker.entroido.Model.Tweet;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by snooze on 27/01/16.
 */
public class TwitterGetterId extends AsyncTask<Long, String, Void> {

    private Context c = null;
    private NetworkAdapter adapter;
    private Activity act;

    public TwitterGetterId() {
    }

    public TwitterGetterId(Activity act,NetworkAdapter adapter) {
        this.act=act;
        this.adapter=adapter;
    }

    public TwitterGetterId(Context c) {
        this.c = c;
    }

    @Override
    protected Void doInBackground(Long... params) {
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

            if(adapter != null){
                ArrayList<NetworkContent> adap=adapter.getContenido();
                adap.addAll(tw);
                //adapter.setMin_id(adapter.getContenido().get(adapter.getContenido().size() - 1).getId());
                adapter.setContenido(adap);

                act.runOnUiThread(new Runnable() {
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
