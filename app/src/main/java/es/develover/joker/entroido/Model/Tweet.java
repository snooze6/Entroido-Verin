package es.develover.joker.entroido.Model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by entakitos on 27/01/16.
 */
public class Tweet implements NetworkContent{
    private String nombreUsuario;
    private String texto;
    private String urlImagen;

    @Override
    public String getUser() {
        return nombreUsuario;
    }

    public String getTexto() {
        return texto;
    }

    public String  getUrlImagen() {
        return urlImagen;
    }

    public Tweet(JSONObject json) {
        try {
            nombreUsuario = json.getJSONObject("user").getString("name");
            texto = json.getString("text");
            try {
                urlImagen = json.getJSONObject("entities").getJSONObject("media").getString("media_url");
            } catch (Exception e) { //non se encontrou a imagen
                urlImagen = null;
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    public Tweet(String nombreUsuario, String texto, String urlImagen) {
        this.nombreUsuario = nombreUsuario;
        this.texto = texto;
        this.urlImagen = urlImagen;
    }
}

