package es.develover.joker.entroido.Model;

/**
 * Created by Denis on 25/01/2016.
 */
public class Day {
   String date;
    int photoId;
    String dayName;
    String description;

    public Day(String date, int photoId, String dayName, String description) {
        this.date = date;
        this.photoId = photoId;
        this.dayName = dayName;
        this.description = description;
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
}
