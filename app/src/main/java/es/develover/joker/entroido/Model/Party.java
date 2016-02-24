package es.develover.joker.entroido.Model;

import android.util.Log;

/**
 * Created by Denis on 26/01/2016.
 */
public class Party {
    public String title;
    public int image;
    public String uriWeb;
    public String date;
    public String uriYoutube;
    public Party(String title, int image,String date, String uriWeb,String uriYoutube) {
        this.title = title;
        this.image = image;
        this.uriWeb = uriWeb;
        this.date=date;
        this.uriYoutube=uriYoutube;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUriYoutube() {
        return uriYoutube;
    }

    public void setUriYoutube(String uriYoutube) {
        this.uriYoutube = uriYoutube;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getUriWeb() {
        return uriWeb;
    }

    public void setUriWeb(String uriWeb) {
        this.uriWeb = uriWeb;
    }

    public void print(){
        String LOG_TAG = "XML_TEST";
        Log.d(LOG_TAG,"--<party>");
        Log.d(LOG_TAG,"title=      " +title);
        Log.d(LOG_TAG,"image=      " +image);
        Log.d(LOG_TAG,"date=       " +date);
        Log.d(LOG_TAG,"web=        " +uriWeb);
        Log.d(LOG_TAG,"video=      " +uriYoutube);
        Log.d(LOG_TAG,"--</party>");
    }
}
