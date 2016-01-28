package es.develover.joker.entroido.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import es.develover.joker.entroido.Activities.CigarronActivity;
import es.develover.joker.entroido.Activities.HistoriaActivity;
import es.develover.joker.entroido.Activities.OrquestaActivity;
import es.develover.joker.entroido.Model.Miscelaneus;
import es.develover.joker.entroido.R;

/**
 * Created by Denis on 25/01/2016.
 */
public class MiscelaneusAdapter extends BaseAdapter {

    private ArrayList<Miscelaneus> miscelaneusArray;
    private Activity activity;
    private LayoutInflater layoutInflater = null;

    public MiscelaneusAdapter(ArrayList<Miscelaneus> days, Activity activity) {

        this.miscelaneusArray = days;
        this.activity = activity;
        layoutInflater = (LayoutInflater) activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return miscelaneusArray.size();
    }

    @Override
    public Object getItem(int position) {
        return miscelaneusArray.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        Miscelaneus miscelaneus = miscelaneusArray.get(position);
       final int id=miscelaneus.getId();
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.card_party, parent, false);
            convertView.findViewById(R.id.youtubeIcon).setVisibility(View.GONE);
            convertView.findViewById(R.id.item_date_special).setVisibility(View.GONE);
            convertView.findViewById(R.id.imageButton).setVisibility(View.GONE);
        }

        CardView carview = (CardView)convertView.findViewById(R.id.cv);
        ImageView image = (ImageView) convertView.findViewById(R.id.card_network_image);
        TextView title = (TextView) convertView.findViewById(R.id.item_title_special);


        if (image != null) {

            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (id == Miscelaneus.HISTORIA) {
                        Intent intent = new Intent(activity, HistoriaActivity.class);
                        activity.startActivity(intent);
                    } else if (id == Miscelaneus.ORQUESTA) {
                        Intent intent = new Intent(activity, OrquestaActivity.class);
                        activity.startActivity(intent);
                    } else if (id == Miscelaneus.CIGARRON) {
                        Intent intent = new Intent(activity, CigarronActivity.class);
                        activity.startActivity(intent);
                    }
                }
            });
        }



        Picasso.with(activity).load(miscelaneusArray.get(position).getImageID()).into(image);
        title.setText(miscelaneusArray.get(position).getTitle());


        return convertView;
    }
}
