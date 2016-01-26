package es.develover.joker.entroido.Model;

/**
 * Created by Denis on 26/01/2016.
 */
public class Party {
    public String title;
    public int image;
    public String uri;

    public Party(String title, int image, String uri) {
        this.title = title;
        this.image = image;
        this.uri = uri;
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

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
