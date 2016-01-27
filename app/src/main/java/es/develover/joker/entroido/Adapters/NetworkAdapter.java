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
import es.develover.joker.entroido.R;

import java.util.ArrayList;

/**
 * Created by snooze on 27/01/16.
 */
public class NetworkAdapter extends BaseAdapter {

    private ArrayList<NetworkContent> contenido = null;
    private Activity activity;
    private LayoutInflater layoutInflater = null;
    private int NUM_COL = 1;
    private int ITEMS_AT_SAME = 20;

    public NetworkAdapter(ArrayList<NetworkContent> contenido, Activity activity) {
        this.activity = activity;
        this.contenido = contenido;
        this.layoutInflater = activity.getLayoutInflater();
    }

    public int getITEMS_AT_SAME() {
        return ITEMS_AT_SAME;
    }

    public NetworkAdapter setITEMS_AT_SAME(int ITEMS_AT_SAME) {
        this.ITEMS_AT_SAME = ITEMS_AT_SAME;
        return this;
    }

    public ArrayList<NetworkContent> getContenido() {
        return contenido;
    }

    public NetworkAdapter setContenido(ArrayList<NetworkContent> contenido) {
        this.contenido = contenido;
        return this;
    }

    public Activity getActivity() {
        return activity;
    }

    public NetworkAdapter setActivity(Activity activity) {
        this.activity = activity;
        return this;
    }

    public LayoutInflater getLayoutInflater() {
        return layoutInflater;
    }

    public NetworkAdapter setLayoutInflater(LayoutInflater layoutInflater) {
        this.layoutInflater = layoutInflater;
        return this;
    }

    public int getNUM_COL() {
        return NUM_COL;
    }

    public NetworkAdapter setNUM_COL(int NUM_COL) {
        this.NUM_COL = NUM_COL;
        return this;
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
//        TwitterGetter t = new TwitterGetter();
//        try {
//            ArrayList<Tweet> arr = t.execute("entroidoVerin").get();
//            contenido.addAll(arr);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
        for (int i=0; i<=ITEMS_AT_SAME; i++){
            contenido.add(contenido.get(i));
        }
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (position+NUM_COL>=contenido.size()){
            doTheLoad();
        }
        Log.e("[Posición]: ",""+position+" - "+contenido.size());

        if (convertView==null){
            convertView = layoutInflater.inflate(R.layout.card_network, parent, false);
        }

        ImageView image = (ImageView) convertView.findViewById(R.id.card_network_image);
        TextView author = (TextView) convertView.findViewById(R.id.card_network_title);
        TextView text = (TextView) convertView.findViewById(R.id.card_network_texto);

        NetworkContent n = contenido.get(position);
        author.setText(n.getUser());
        text.setText(n.getTexto());
        Picasso.with(activity).load(n.getUrlImagen()).into(image);

        return convertView;
    }
}
