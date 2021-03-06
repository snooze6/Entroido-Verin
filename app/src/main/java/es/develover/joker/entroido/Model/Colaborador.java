package es.develover.joker.entroido.Model;

import android.net.Uri;
import android.util.Log;

/**
 * Created by entakitos on 30/01/16.
 */
public class Colaborador {
    private Uri fuente;
    private String nombre;
    private int imagen;
    private String colaboración;
    private String descripcionColaboracion;

    public Uri getFuente() {
        return fuente;
    }

    public void setFuente(Uri fuente) {
        this.fuente = fuente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getColaboración() {
        return colaboración;
    }

    public void setColaboración(String colaboración) {
        this.colaboración = colaboración;
    }

    public String getDescripcionColaboración() {
        return descripcionColaboracion;
    }

    public void setDescripcionColaboración(String descripcioónColaboración) {
        this.descripcionColaboracion = descripcioónColaboración;
    }

    public Colaborador(String nombre, int imagen, Uri fuente,String colaboración,String descripcionColaboracion) {
        this.colaboración = colaboración;
        this.imagen = imagen;
        this.nombre = nombre;
        this.fuente = fuente;
        this.descripcionColaboracion = descripcionColaboracion;
    }

    public void print(){
        String LOG_TAG = "XML_TEST";
        Log.d(LOG_TAG,"--<colaborator>");
        Log.d(LOG_TAG,"name=        " +nombre);
        Log.d(LOG_TAG,"colaboracion=" +colaboración);
        Log.d(LOG_TAG,"descripcion= " +descripcionColaboracion);
        Log.d(LOG_TAG,"imagen=      " +imagen);
        Log.d(LOG_TAG,"fuente=      " +fuente.toString());
        Log.d(LOG_TAG,"--</colaborator>");
    }
}
