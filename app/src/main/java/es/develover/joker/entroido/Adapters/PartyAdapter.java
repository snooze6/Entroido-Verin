package es.develover.joker.entroido.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
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
    public View getView(int position, View convertView, final ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.card_party, parent, false);
        }
        final int positionFinal = position;
        final ImageButton imageButton = (ImageButton) convertView.findViewById(R.id.imageButton);
        if (positionFinal == 0) {
            imageButton.setVisibility(View.INVISIBLE);
        }

        if (imageButton != null) {
            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://" + parties.get(positionFinal).getUriWeb()));
                    activity.startActivity(intent);
                }
            });

        }
        ImageView image = (ImageView) convertView.findViewById(R.id.item_image_special);
        if (image != null) {    
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (positionFinal == 0) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.es/maps/place/Plaza+Garc%C3%ADa+Barb%C3%B3n,+32600+Ver%C3%ADn,+Ourense/@41.9421979,-7.4385678,273m/data=!3m1!1e3!4m2!3m1!1s0xd3ac1d8a4298475:0x7999f15ffb57b5ec "));
                        activity.startActivity(intent);
                    } else {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        String video_id = parties.get(positionFinal).getUriYoutube();
                        intent.setData(Uri.parse("vnd.youtube:" + video_id));
                        intent.putExtra("VIDEO_ID", video_id);
                        activity.startActivity(intent);
                    }
                }
            });
        }

        TextView title = (TextView) convertView.findViewById(R.id.item_title_special);
        TextView date = (TextView) convertView.findViewById(R.id.item_date_special);
        Picasso.with(activity).load(parties.get(position).getImage()).into(image);
        title.setText(parties.get(position).getTitle());


        return convertView;
    }
}
