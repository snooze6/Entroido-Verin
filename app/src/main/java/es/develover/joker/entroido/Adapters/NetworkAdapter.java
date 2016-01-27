package es.develover.joker.entroido.Adapters;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import es.develover.joker.entroido.Model.NetworkContent;
import es.develover.joker.entroido.Model.Tweet;
import es.develover.joker.entroido.Network.TwitterGetterId;
import es.develover.joker.entroido.Network.TwitterUpdater;
import es.develover.joker.entroido.R;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by snooze on 27/01/16.
 */
public class NetworkAdapter extends BaseAdapter {

    private ArrayList<NetworkContent> contenido = null;
    private Activity activity;
    private LayoutInflater layoutInflater = null;
    private int NUM_COL = 1;
    private int ITEMS_AT_SAME = 20;
    private long min_id;
    private long max_id;

    public NetworkAdapter(ArrayList<NetworkContent> contenido, Activity activity) {
        this.activity = activity;
        this.contenido = contenido;
        this.layoutInflater = activity.getLayoutInflater();

        min_id = contenido.get(0).getId();
        max_id = contenido.get(0).getId();
        for (int i=1; i<contenido.size(); i++){
//            Log.d("DEBUG_API", "[Tweet: "+i+" - Id: "+contenido.get(i).getId());
            if (contenido.get(i).getId()<min_id){
                min_id = contenido.get(i).getId();
            }
            if (contenido.get(i).getId()>max_id){
                max_id = contenido.get(i).getId();
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
        Log.d("DEBUG_API","  -- Voy a cargar más");

        try {
            ArrayList<Tweet> arr = new TwitterGetterId().execute(min_id-1).get();
            contenido.addAll(arr);

            for (int i=0; i<arr.size(); i++){
                if (arr.get(i).getId() < min_id){
                    min_id = arr.get(i).getId();
                }
                if (contenido.get(i).getId()>max_id){
                    max_id = contenido.get(i).getId();
                }
            }
            notifyDataSetChanged();

//            ArrayList<Tweet> arr = new TwitterGetter().execute("FelizMiercoles").get();
//            contenido.addAll(arr);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
//        Log.d("DEBUG_API", "[Min_id: "+min_id+"]");
//        for (int i=0; i<contenido.size(); i++){
//            if (i==0 || i==(contenido.size()-1)) {
//                Log.d("DEBUG_API", "[Tweet: "+i+" - Id: " + contenido.get(i).getId());
//            }
//        }
    }

    private void doTheUpdate(){
        try {
            ArrayList<Tweet> arr = new TwitterUpdater().execute(max_id).get();
            for (int i=0; i<arr.size(); i++){
                if (arr.get(i).getId() < min_id){
                    min_id = arr.get(i).getId();
                }
                if (contenido.get(i).getId()>max_id){
                    max_id = contenido.get(i).getId();
                }
                contenido.add(0,arr.get(i));
            }
            notifyDataSetChanged();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (position+NUM_COL>=contenido.size()){
            doTheLoad();
        }
        if (position==0){
            doTheUpdate();
        }
        if (convertView==null){
            convertView = layoutInflater.inflate(R.layout.card_network, parent, false);
        }

        ImageView image = (ImageView) convertView.findViewById(R.id.card_network_image);
        TextView author = (TextView) convertView.findViewById(R.id.card_network_title);
        TextView text = (TextView) convertView.findViewById(R.id.card_network_texto);

        NetworkContent n = contenido.get(position);
        author.setText(n.getUser());
        text.setText(n.getTexto());

        if (n.getUrlImagen()!=null) {
            Picasso.with(activity).load(n.getUrlImagen()).into(image);
            image.setVisibility(View.VISIBLE);
        } else {
            image.setImageResource(R.drawable.hermione);
            Picasso.with(activity).load(R.drawable.hermione).into(image);
            image.setVisibility(View.GONE);
        }

        return convertView;
    }
}
