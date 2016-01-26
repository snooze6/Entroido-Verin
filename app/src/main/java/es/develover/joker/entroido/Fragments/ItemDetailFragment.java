package es.develover.joker.entroido.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import es.develover.joker.entroido.Activities.ItemDetailActivity;
import es.develover.joker.entroido.Activities.ItemListActivity;
import es.develover.joker.entroido.Adapters.EventAdapter;
import es.develover.joker.entroido.Model.ContentProvider;
import es.develover.joker.entroido.Model.Day;
import es.develover.joker.entroido.Model.DummyContent;
import es.develover.joker.entroido.R;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
   private DummyContent.DummyItem mItem;
    private Day day;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("DetailFragment", "DetailFragment");
        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.

            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            day= ContentProvider.days.get(Integer.parseInt(getArguments().getString(ARG_ITEM_ID))-1);
            Activity activity = this.getActivity();
/*            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.content);
            }*/
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e("DetailFragment", "siuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
        View rootView = inflater.inflate(R.layout.fragment_item_detail, container, false);
        ListView listView = (ListView) rootView.findViewById(R.id.listview_events);


        EventAdapter eventAdapter = new EventAdapter(day,this.getActivity());
       // DayAdapter dayAdapter = new DayAdapter(ContentProvider.days,this.getActivity());

        listView.setAdapter(eventAdapter);

        return rootView;
    }
}
