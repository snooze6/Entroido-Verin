package es.develover.joker.entroido.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import es.develover.joker.entroido.Adapters.ColaboradoresAdapter;
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

        ListView list=(ListView)v.findViewById(R.id.listview_colaboradores);
        list.setAdapter(new ColaboradoresAdapter());

        return v;
    }
}
