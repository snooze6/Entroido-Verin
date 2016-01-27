package es.develover.joker.entroido.Activities;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.*;
import android.widget.GridView;
import android.widget.ListView;
import es.develover.joker.entroido.Adapters.NetworkAdapter;
import es.develover.joker.entroido.Adapters.PartyAdapter;
import es.develover.joker.entroido.Fragments.ItemDetailFragment;
import es.develover.joker.entroido.Fragments.ItemListFragment;
import es.develover.joker.entroido.Model.ContentProvider;
import es.develover.joker.entroido.Model.NetworkContent;
import es.develover.joker.entroido.Model.Tweet;
import es.develover.joker.entroido.Network.TwitterGetter;
import es.develover.joker.entroido.R;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity
        implements ItemListFragment.Callbacks {

    public static boolean mTwoPane = false;

    public static View social = null;
    public static View agenda = null;
    public static View fiesta = null;

    public static int item = 1;

    @Override
    public void onItemSelected(String id) {
        //Log.e("[Tocado]: ", "" + mTwoPane + " - " + id);
        item = Integer.parseInt(id);
        if (mTwoPane) {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(ItemDetailFragment.ARG_ITEM_ID, id);
            ItemDetailFragment fragment = new ItemDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.item_detail_container, fragment)
                    .commit();
        } else {
            // In single-pane mode, simply start the detail activity
            // for the selected item ID.

            Intent detailIntent = new Intent(this, ItemDetailActivity.class);
            detailIntent.putExtra(ItemDetailFragment.ARG_ITEM_ID, id);
            startActivity(detailIntent);
        }
    }

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fiesta = null;
        agenda = null;
        social = null;


        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        //Item 0 by default
        tabLayout.getTabAt(1).select();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.

        savedInstanceState.putInt("Item", item);
        // etc.
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.
        if (mTwoPane) {
            item = savedInstanceState.getInt("Item");
            this.onItemSelected("" + item);
            //Log.e("Item>>>>>>>>>", "" + item);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SOCIAL";
                case 1:
                    return "AGENDA";
                case 2:
                    return "ORQUESTAS";
            }
            return null;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = null;
            int section = getArguments().getInt(ARG_SECTION_NUMBER);

            switch (section) {
                case 1:
                    if (social == null) {
                        rootView = inflater.inflate(R.layout.fragment_social, container, false);

                        ListView list = (ListView) rootView.findViewById(R.id.network_grid);

                        ArrayList<NetworkContent> dummyContent=new ArrayList<NetworkContent>();
                        dummyContent.add(new Tweet("","",""));

                        list.setAdapter(new NetworkAdapter(dummyContent, getActivity()));

                        new TwitterGetter((NetworkAdapter)list.getAdapter()).execute("verin");

                        social = rootView;
                    } else {
                        return social;
                    }
                    break;
                case 2:
                    if (agenda == null) {
                        rootView = inflater.inflate(R.layout.activity_item_list, container, false);
                        agenda = rootView;
                        if (rootView.findViewById(R.id.item_detail_container) != null) {
                            // The detail container view will be present only in the
                            // large-screen layouts (res/values-large and
                            // res/values-sw600dp). If this view is present, then the
                            // activity should be in two-pane mode.
                            mTwoPane = true;

                            ((MainActivity) getActivity()).onItemSelected("1");
                            item = 1;
                        } else {
                            mTwoPane = false;
                        }
                    } else {
                        return agenda;
                    }
                    break;
                case 3:
                    if (fiesta == null) {
                        rootView = inflater.inflate(R.layout.fragment_fiesta, container, false);

                        GridView grid = (GridView) rootView.findViewById(R.id.grid);
                        grid.setAdapter(new PartyAdapter(ContentProvider.parties, getActivity()));

                        if (mTwoPane) {
                            Point p = new Point();
                              getActivity().getWindowManager().getDefaultDisplay().getSize(p);
                              int col = 0;
                              if (grid.getRequestedColumnWidth()>0) {
                                  col = (int) p.x/grid.getRequestedColumnWidth();
                              }
                              //Log.e("[Ancho]: ","[Pantalla: "+p.x+"] - [Columna: "+grid.getRequestedColumnWidth()+"] - [Columnas: "+col+"]");

                            grid.setNumColumns(col);
                        } else {
                            grid.setNumColumns(1);
                        }

                        fiesta = rootView;
                    } else {
                        return fiesta;
                    }
                    break;


            }
            return rootView;
        }

    }
}
