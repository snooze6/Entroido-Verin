package es.develover.joker.entroido.Activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import es.develover.joker.entroido.R;


public class GalleryActivity extends AppCompatActivity {


    public static ArrayList<String> urls;
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private static SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    public void createUrls() {
        int i = 1;
        urls = new ArrayList<String>();
        for (i = 1; i < 11; i++) {
            String urlBasic = "http://www.carnavaldeverin.com/wp-content/uploads/2015/07/Compadres-2016-";
            String url = urlBasic + i+".jpg";
            Log.e("URL:", url);
            urls.add(url);
        }
        for (i = 1; i < 11; i++) {
            String urlBasic = "http://www.carnavaldeverin.com/wp-content/uploads/2015/07/Comadres_2016_";
            String url = urlBasic + i+".jpg";
            Log.e("URL:", url);
            urls.add(url);
        }

        for (i = 1; i < 11; i++) {
            String urlBasic = "http://www.carnavaldeverin.com/wp-content/uploads/2015/07/Corredoiro-2016-";
            String url = urlBasic + i+"-1.jpg";
            Log.e("URL:", url);
            urls.add(url);
        }
        for (i = 590; i < 600; i++) {
            String urlBasic = "http://www.carnavaldeverin.com/wp-content/uploads/2015/07/Desfile-nenos_2016_";
            String url = urlBasic + i+".jpg";
            Log.e("URL:", url);
            urls.add(url);
        }
/*urls.clear();
        urls.add("http://www.carnavaldeverin.com/wp-content/uploads/2015/07/Comadres_2016_20.jpg");
        urls.add("http://www.carnavaldeverin.com/wp-content/uploads/2015/07/Compadres-2016-3.jpg");*/

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createUrls();
        setContentView(R.layout.activity_gallery);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.hideOverflowMenu();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

/*        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);*/


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_gallery, menu);
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
            return urls.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
                case 3:
                    return "SECTION 4";
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

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            int section = getArguments().getInt(ARG_SECTION_NUMBER);
            View rootView = inflater.inflate(R.layout.fragment_gallery, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.photo_number);

            String text = "Imagen " + section + " / " + mSectionsPagerAdapter.getCount();
            ;
            textView.setText(text);
            ImageView image = (ImageView) rootView.findViewById(R.id.card_gallery);
           /* switch (section) {
                case 1:
                    Picasso.with(getActivity()).load("http://www.carnavaldeverin.com/wp-content/uploads/2015/07/Comadres_2016_18.jpg").into(image);
                    break;
                case 2:
                    Picasso.with(getActivity()).load("http://www.carnavaldeverin.com/wp-content/uploads/2015/07/Corredoiro-2016-11-1.jpg").into(image);
                    break;
                case 3:
                    Picasso.with(getActivity()).load("http://www.carnavaldeverin.com/wp-content/uploads/2015/07/Comadres_2016_15.jpg").into(image);
                    break;
                case 4:
                    Picasso.with(getActivity()).load("http://www.carnavaldeverin.com/wp-content/uploads/2015/07/Compadres-2016-3.jpg").into(image);
                    break;
                case 5:
                    Picasso.with(getActivity()).load("http://www.carnavaldeverin.com/wp-content/uploads/2015/07/Comadres_2016_1.jpg").into(image);
                    break;
            }*/

            Picasso.with(getActivity()).load(urls.get(section-1)).into(image);
            //textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }
}
