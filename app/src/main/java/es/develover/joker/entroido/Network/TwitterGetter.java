package es.develover.joker.entroido.Network;

import android.os.AsyncTask;
import es.develover.joker.entroido.Model.Tweet;

import java.util.ArrayList;

/**
 * Created by snooze on 27/01/16.
 */
public class TwitterGetter extends AsyncTask<String, String, ArrayList<Tweet>> {

    @Override
    protected ArrayList<Tweet> doInBackground(String... params) {
//        try {
//            return Twitah.tweetsPorHashtag("entroidoVerin");
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (Twitah.Oauth2Exception e) {
//            e.printStackTrace();
//        }
        return new ArrayList<Tweet>();
    }
}
