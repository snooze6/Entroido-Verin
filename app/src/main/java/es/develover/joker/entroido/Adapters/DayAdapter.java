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
import java.util.Calendar;

import es.develover.joker.entroido.Model.Day;
import es.develover.joker.entroido.R;

/**
 * Created by Denis on 25/01/2016.
 */
public class DayAdapter extends BaseAdapter {

    private ArrayList<Day> days;
    private Activity activity;
    private LayoutInflater layoutInflater = null;
private int positionSpecial=3;

    public DayAdapter(ArrayList<Day> days, Activity activity) {



        this.days = days;
        this.activity = activity;
        layoutInflater = (LayoutInflater) activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    private void refreshSpecialPosition() {
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DAY_OF_MONTH);
        switch(day){
            case 28:
                positionSpecial=0;
                break;

            case 29:
            case 30:
            case 31:
                positionSpecial=1;
                break;
            case 1:
            case 2:
            case 3:
            case 4:
                positionSpecial=2;
                break;
            case 5:
                positionSpecial=3;
                break;
            case 6:
                positionSpecial=4;
                break;
            case 7:
                positionSpecial=5;
                break;
            case 8:
                positionSpecial=6;
                break;
            case 9:
                positionSpecial=7;
                break;
            default:
                positionSpecial=8;

        }

    }

    public int getPositionSpecial() {
        return positionSpecial;
    }

    public void setPositionSpecial(int positionSpecial) {
        this.positionSpecial = positionSpecial;
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
        refreshSpecialPosition();
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
                Picasso.with(activity).load(day.getPhotoId()).fit().into(image);
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
