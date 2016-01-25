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

import es.develover.joker.entroido.Model.Day;
import es.develover.joker.entroido.R;

/**
 * Created by Denis on 25/01/2016.
 */
public class MainAdapter extends BaseAdapter {

    private ArrayList<Day> days;
    private Activity activity;
    private LayoutInflater layoutInflater = null;

    public MainAdapter(ArrayList<Day> days, Activity activity) {

        this.days = days;
        this.days = new ArrayList<Day>();
        Day day = new Day("8 de Febrero", R.drawable.domingo, "Domingo de carnaval", "Cabalgata espectacular en el pequeño gran pueblo de Verín");
        for (int i = 0; i < 20; i++) {
            this.days.add(day);
        }
        this.activity = activity;
        layoutInflater = (LayoutInflater) activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return days.size() + 1;
    }

    @Override
    public Object getItem(int position) {
        return days.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int positionSpecial=3;
        if (convertView == null) {
            if (position < days.size()) {
                if (position == positionSpecial) {
                    convertView = layoutInflater.inflate(R.layout.card_item_special, parent, false);
                } else {
                    convertView = layoutInflater.inflate(R.layout.card_item, parent, false);
                }

            } else {
                convertView = layoutInflater.inflate(R.layout.blank, parent, false);
            }
        } else {
            if (position < days.size()) {
                if (position==positionSpecial){
                    if (convertView.findViewById(R.id.item_title_special) == null) {
                        convertView = layoutInflater.inflate(R.layout.card_item_special, parent, false);
                    }
                } else {
                    if (convertView.findViewById(R.id.item_title) == null) {
                        convertView = layoutInflater.inflate(R.layout.card_item, parent, false);
                    }
                }

/*                if (convertView.findViewById(R.id.item_title) == null) {
                    if (position == positionSpecial) {
                        convertView = layoutInflater.inflate(R.layout.card_item_special, parent, false);
                    } else {
                        convertView = layoutInflater.inflate(R.layout.card_item, parent, false);
                    }
                }*/
            } else {
                convertView = layoutInflater.inflate(R.layout.blank, parent, false);
            }
        }

        if (position < days.size()) {
            //Getting the elements of a item
            if (position == positionSpecial) {
                convertView = layoutInflater.inflate(R.layout.card_item_special, parent, false);
                ImageView image = (ImageView) convertView.findViewById(R.id.item_image_special);
                TextView title = (TextView) convertView.findViewById(R.id.item_title_special);
                //Fill with the right content
                Day day = (Day) getItem(position);
                title.setText(day.getDayName());
                Picasso.with(activity).load(R.drawable.icon).into(image);
            } else {
                ImageView image = (ImageView) convertView.findViewById(R.id.item_image);
                TextView title = (TextView) convertView.findViewById(R.id.item_title);
                TextView date = (TextView) convertView.findViewById(R.id.item_date);
                //Fill with the right content
                Day day = (Day) getItem(position);
                title.setText(day.getDayName());
                date.setText(day.getDate());
                Picasso.with(activity).load(day.getPhotoId()).into(image);
            }

        }

        return convertView;
    }
}
