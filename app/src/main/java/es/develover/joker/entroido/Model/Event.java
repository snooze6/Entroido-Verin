package es.develover.joker.entroido.Model;

import android.util.Log;

/**
 * Created by Denis on 26/01/2016.
 */
public class Event {
    public String title;
    public String description;
    public int image;

    public Event(String title, String description, int image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void print(){
        String LOG_TAG = "XML_TEST";
        Log.d(LOG_TAG,"--<event>");
        Log.d(LOG_TAG,"title=      " +title);
        Log.d(LOG_TAG,"description=" +description);
        Log.d(LOG_TAG,"image=      " +image);
        Log.d(LOG_TAG,"--</event>" +title);
    }
}
