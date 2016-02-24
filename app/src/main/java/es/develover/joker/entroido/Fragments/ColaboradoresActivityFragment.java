package es.develover.joker.entroido.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import es.develover.joker.entroido.Adapters.ColaboradoresAdapter;
import es.develover.joker.entroido.Model.Colaborador;
import es.develover.joker.entroido.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class ColaboradoresActivityFragment extends Fragment {

    public ColaboradoresActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_colaboradores, container, false);

        final ListView list=(ListView)v.findViewById(R.id.listview_colaboradores);
        list.setAdapter(new ColaboradoresAdapter(inflater));

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent tweet_in_browser = new Intent(Intent.ACTION_VIEW, ((Colaborador)((ColaboradoresAdapter)list.getAdapter()).getItem(position)).getFuente());
                getActivity().startActivity(tweet_in_browser);
            }
        });

        return v;
    }
}
