package es.develover.joker.entroido.Adapters;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import es.develover.joker.entroido.Activities.MainActivity;
import es.develover.joker.entroido.Model.NetworkContent;
import es.develover.joker.entroido.Model.Tweet;
import es.develover.joker.entroido.Network.ConnectionDetector;
import es.develover.joker.entroido.Network.TwitterGetterId;
import es.develover.joker.entroido.Network.TwitterUpdater;
import es.develover.joker.entroido.R;

/**
 * Created by snooze on 27/01/16.
 */
public class NetworkAdapter extends BaseAdapter {

    private ArrayList<NetworkContent> contenido = null;
    private Activity activity;
    private LayoutInflater layoutInflater = null;
    private int NUM_COL = 5;
    private int ITEMS_AT_SAME = 20;
    private long min_id;
    private long max_id;
    private boolean done = true;

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public long getMin_id() {
        return min_id;
    }

    public void setContenido(ArrayList<NetworkContent> contenido) {
        this.contenido = contenido;
        min_id = contenido.get(contenido.size()-1).getId();
        max_id = contenido.get(0).getId();
    }

    public ArrayList<NetworkContent> getContenido() {
        return contenido;
    }

    public NetworkAdapter(ArrayList<NetworkContent> contenido, Activity activity) {
        this.activity = activity;
        this.contenido = contenido;
        this.layoutInflater = activity.getLayoutInflater();

        for (int i=0; i<contenido.size(); i++){
            ((Tweet)contenido.get(i)).print();
        }
        if (contenido!=null) {
            if (contenido.size() != 0) {
                min_id = contenido.get(contenido.size() - 1).getId();
                max_id = contenido.get(0).getId();
            }
        }
    }

    @Override
    public int getCount() {
        return contenido.size();
    }

    @Override
    public Object getItem(int position) {
        return contenido.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private void doTheLoad(){

        ConnectionDetector cd = new ConnectionDetector(activity);
        if (cd.isConnectingToInternet()) {
            //Log.d("[TWEET]", "  -- Voy a cargar más por abajo");
            /*for (int i = 0; i < contenido.size(); i++) {
                ((Tweet) contenido.get(i)).print();
            }*/


                new TwitterGetterId(activity,this).execute(min_id - 1);

//            ArrayList<Tweet> arr = new TwitterGetter().execute("FelizMiercoles").get();
//            contenido.addAll(arr);

        }else{
            ((MainActivity)activity).internetDialog();
        }
    }

    public void doTheUpdate(){
        //Log.d("[TWEET]", "  -- Voy a cargar más por arriba");
        for (int i=0; i<contenido.size(); i++){
            ((Tweet)contenido.get(i)).print();
        }
        try {
            new TwitterUpdater(this).execute(max_id+1).get();

            notifyDataSetChanged();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (position+NUM_COL>=contenido.size() && contenido.size()>2 && isDone()){
            done=false;
            doTheLoad();
        }
        if (convertView==null){
            convertView = layoutInflater.inflate(R.layout.card_network, parent, false);
        }

        ImageView image = (ImageView) convertView.findViewById(R.id.card_network_image);
        ImageView imageProfile = (ImageView) convertView.findViewById(R.id.card_network_profile_image);
        TextView author = (TextView) convertView.findViewById(R.id.card_network_title);
        TextView text = (TextView) convertView.findViewById(R.id.card_network_texto);



        NetworkContent n = contenido.get(position);
        author.setText(n.getUser());
        text.setText(n.getTexto());

        if(n.getUserImage()!=null){
            Picasso.with(activity).load(n.getUserImage()).into(imageProfile);

        }
        if (n.getUrlImagen()!=null && !n.getUrlImagen().isEmpty()) {
            Picasso.with(activity).load(n.getUrlImagen()).into(image);
            image.setVisibility(View.VISIBLE);
        } else {
            image.setImageResource(R.drawable.hermione);
            Picasso.with(activity).load(R.drawable.hermione).into(image);
            image.setVisibility(View.GONE);
        }

        convertView.setClickable(true);
        for (View v:convertView.getTouchables()) {
            v.setClickable(true);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        Intent tweet_in_native_app = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://status?status_id=" + contenido.get(position).getId()));
                        activity.startActivity(tweet_in_native_app);
                    }catch (ActivityNotFoundException e){
                        Intent tweet_in_browser = new Intent(Intent.ACTION_VIEW, Uri.parse("http://twitter.com/"+contenido.get(position).getUser()+"/status/"+contenido.get(position).getId()));
                        activity.startActivity(tweet_in_browser);
                    }
                }
            });
        }

       return convertView;

    }

    public NetworkAdapter setMin_id(long min_id) {
        this.min_id = min_id;
        return this;
    }

    public NetworkAdapter setMax_id(long max_id) {
        this.max_id = max_id;
        return this;
    }
}
