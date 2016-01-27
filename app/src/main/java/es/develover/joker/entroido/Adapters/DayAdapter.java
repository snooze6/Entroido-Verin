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
import es.develover.joker.entroido.Model.Day;
import es.develover.joker.entroido.R;

import java.util.ArrayList;

/**
 * Created by Denis on 25/01/2016.
 */
public class DayAdapter extends BaseAdapter {

    private ArrayList<Day> days;
    private Activity activity;
    private LayoutInflater layoutInflater = null;

    public DayAdapter(ArrayList<Day> days, Activity activity) {

        this.days = days;
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
            } else {
                convertView = layoutInflater.inflate(R.layout.blank, parent, false);
            }
        }

        if (position < days.size()) {
            //Getting the elements of a item
            if (position == positionSpecial) {
                ImageView image = (ImageView) convertView.findViewById(R.id.card_network_image);
                TextView title = (TextView) convertView.findViewById(R.id.item_title_special);
                //Fill with the right content
                Day day = (Day) getItem(position);
                title.setText(day.getDayName());
                Picasso.with(activity).load(day.getPhotoId()).into(image);
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
