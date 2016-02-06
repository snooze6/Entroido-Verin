package es.develover.joker.entroido.Model;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Denis on 25/01/2016.
 */
public class Day {
   String date;
    int photoId;
    String dayName;
    String description;
    ArrayList<Event> events;

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    public Day(String date, int photoId, String dayName, String description,ArrayList<Event> events) {
        this.date = date;
        this.photoId = photoId;
        this.dayName = dayName;
        this.description = description;
        this.events=events;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public int getPhoto() {
        return photoId;
    }

    public void setPhoto(int photoId) {
        this.photoId = photoId;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void print(){
        String LOG_TAG = "XML_TEST";
        Log.d(LOG_TAG,"--<day>");
        Log.d(LOG_TAG,"date=       " +date);
        Log.d(LOG_TAG,"image=      " +photoId);
        Log.d(LOG_TAG,"title=      " +dayName);
        Log.d(LOG_TAG,"description=" +events);
        for (int i=0; i<events.size(); i++){
            events.get(i).print();
        }
        Log.d(LOG_TAG,"--</day>");
    }
}
