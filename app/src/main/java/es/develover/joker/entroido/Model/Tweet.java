package es.develover.joker.entroido.Model;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by entakitos on 27/01/16.
 */
public class Tweet implements NetworkContent{
    private String nombreUsuario;
    private String texto;
    private String urlImagen;
    private long id;
    private String urlUserImage;

    @Override
    public String getUser() {
        return nombreUsuario;
    }

    @Override
    public String getTexto() {
        return texto;
    }

    @Override
    public String  getUrlImagen() {
        return urlImagen;
    }

    @Override
    public long getId() {return id;}

    @Override
    public String getUserImage() {
        return urlUserImage;
    }

    public Tweet(JSONObject json) {
        try {
            id = json.getLong("id");
            nombreUsuario = json.getJSONObject("user").getString("name");
            texto = json.getString("text");
            try {
                //urlImagen = json.getJSONObject("entities").getJSONObject("media").getString("media_url");
                urlImagen = json.getJSONObject("entities").getJSONArray("media").getJSONObject(0).getString("media_url");
            } catch (Exception e) { //non se encontrou a imagen
                urlImagen = null;
                e.printStackTrace();
            }
            try {
                //urlImagen = json.getJSONObject("entities").getJSONObject("media").getString("media_url");
                urlUserImage = json.getJSONObject("user").getString("profile_image_url");
            } catch (Exception e) { //non se encontrou a imagen
                urlUserImage= null;
                e.printStackTrace();
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    public Tweet(String nombreUsuario, String texto, String urlImagen) {
        this.nombreUsuario = nombreUsuario;
        this.texto = texto;
        this.urlImagen = urlImagen;
        id = 1;
    }

    public void print(){
        Log.d("[TWEET]","[Id: "+id+"] - ["+nombreUsuario+"]");
    }
}

