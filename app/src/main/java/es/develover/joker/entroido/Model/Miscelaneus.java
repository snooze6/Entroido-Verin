package es.develover.joker.entroido.Model;

/**
 * Created by Denis on 28/01/2016.
 */
public class Miscelaneus {
    public static final int ORQUESTA = 0;
    public static final int HISTORIA = 1;
    public static final int CIGARRON = 2;
    public static final int CONCURSO = 3;
    public String title;
    public int imageID;
    public int id;


    public Miscelaneus(String tittle, int id, int imageID){
        this.title=tittle;
        this.id=id;
        this.imageID=imageID;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String tittle) {
        this.title = tittle;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
