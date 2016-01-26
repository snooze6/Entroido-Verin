package es.develover.joker.entroido.Model;

import android.net.Uri;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by entakitos on 27/01/16.
 */
public class Tweet {
    private String nombreUsuario;
    private String texto;
    private Uri urlImagen;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getTexto() {
        return texto;
    }

    public Uri getUrlImagen() {
        return urlImagen;
    }

    public Tweet(JSONObject json) {

        try {

            nombreUsuario = json.getJSONObject("user").getString("name");
            texto = json.getString("text");

            try {

                json.getJSONObject("entities").getJSONObject("media").getString("media_url");

            } catch (Exception e) { //non se encontrou a imagen
                urlImagen = null;
            }

        }catch (JSONException e){
            e.printStackTrace();
        }


    }
}

