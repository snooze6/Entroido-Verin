package es.develover.joker.entroido.Adapters;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import es.develover.joker.entroido.Model.Day;
import es.develover.joker.entroido.Model.Event;
import es.develover.joker.entroido.R;

/**
 * Created by Denis on 25/01/2016.
 */
public class FiestaAdapter extends BaseAdapter {
    private Day day;
    private ArrayList<Event> Events;
    private Activity activity;
    private LayoutInflater layoutInflater = null;

    public FiestaAdapter(Day day, Activity activity) {
        this.day = day;
        this.Events = this.day.getEvents();


        this.activity = activity;
        layoutInflater = (LayoutInflater) activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public FiestaAdapter(ArrayList<Event> events, Activity activity){
        this.Events=events;
        this.activity = activity;
        layoutInflater = (LayoutInflater) activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return Events.size();
    }

    @Override
    public Object getItem(int position) {
        return Events.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            if (position < Events.size()) {
                convertView = layoutInflater.inflate(R.layout.card_history_event, parent, false);


            } else {
                convertView = layoutInflater.inflate(R.layout.blank, parent, false);
            }
        } else {
            if (position < Events.size()) {

                if (convertView.findViewById(R.id.item_title) == null) {
                    convertView = layoutInflater.inflate(R.layout.card_history_event, parent, false);
                }

            } else {
                convertView = layoutInflater.inflate(R.layout.blank, parent, false);
            }
        }

        if (position < Events.size()) {

            //Log.e("He tocado aqui","He tocado aqui");



            //Getting the elements of a item
           ImageView image = (ImageView) convertView.findViewById(R.id.card_network_image);
            TextView title = (TextView) convertView.findViewById(R.id.item_title_special);
            TextView description = (TextView) convertView.findViewById(R.id.item_description_special);
            //Fill with the right content
            Event event = (Event) getItem(position);
            title.setText(event.getTitle());

            description.setText(event.getDescription());
            if (event.getImage()!=0) {
                Picasso.with(activity).load(event.getImage()).into(image);
            } else {
                image.setImageResource(R.drawable.hermione);
            }
        }


        return convertView;
    }
}
