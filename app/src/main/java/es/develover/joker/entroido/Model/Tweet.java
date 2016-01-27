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
    private long id;

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
                if (nombreUsuario.equals("Javier Tresguerras")) {
                    e.printStackTrace();
                }
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
}

