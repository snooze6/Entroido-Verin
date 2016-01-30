package es.develover.joker.entroido.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import es.develover.joker.entroido.Model.Colaborador;
import es.develover.joker.entroido.Model.ContentProvider;
import es.develover.joker.entroido.R;

/**
 * Created by entakitos on 30/01/16.
 */
public class ColaboradoresAdapter extends BaseAdapter{

    ArrayList<Colaborador> colaboradores= ContentProvider.colaboradores;
    private LayoutInflater layoutInflater = null;

    public ColaboradoresAdapter(LayoutInflater layoutInflater) {
        this.layoutInflater = layoutInflater;
    }

    @Override
    public int getCount() {
        return colaboradores.size();
    }

    @Override
    public Object getItem(int position) {
        return colaboradores.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.card_colaboradores, parent, false);
        }

        ImageView img=(ImageView)convertView.findViewById(R.id.card_colaboradores_image);
        img.setImageResource(colaboradores.get(position).getImagen());
        TextView text=(TextView)convertView.findViewById(R.id.card_colaboradores_colaboracion);
        text.setText(colaboradores.get(position).getColaboración());



        return convertView;

    }
}
