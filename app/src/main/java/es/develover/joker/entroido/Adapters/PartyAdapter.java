package es.develover.joker.entroido.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import es.develover.joker.entroido.Model.Party;
import es.develover.joker.entroido.R;

/**
 * Created by Denis on 25/01/2016.
 */
public class PartyAdapter extends BaseAdapter {

    private ArrayList<Party> parties;
    private Activity activity;
    private LayoutInflater layoutInflater = null;

    public PartyAdapter(ArrayList<Party> days, Activity activity) {

        this.parties = days;
        this.activity = activity;
        layoutInflater = (LayoutInflater) activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return parties.size();
    }

    @Override
    public Object getItem(int position) {
        return parties.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView = layoutInflater.inflate(R.layout.card_party,parent,false);
        }

        ImageView image = (ImageView) convertView.findViewById(R.id.item_image_special);
        TextView title = (TextView) convertView.findViewById(R.id.item_title_special);
        Picasso.with(activity).load(parties.get(position).getImage()).into(image);
        title.setText(parties.get(position).getTitle());

        return convertView;
    }
}
