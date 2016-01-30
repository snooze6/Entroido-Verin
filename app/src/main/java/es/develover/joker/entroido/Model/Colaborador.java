package es.develover.joker.entroido.Model;

import android.net.Uri;

/**
 * Created by entakitos on 30/01/16.
 */
public class Colaborador {
    private Uri fuente;
    private String nombre;
    private Uri imagen;
    private String colaboración;

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

    public Uri getImagen() {
        return imagen;
    }

    public void setImagen(Uri imagen) {
        this.imagen = imagen;
    }

    public String getColaboración() {
        return colaboración;
    }

    public void setColaboración(String colaboración) {
        this.colaboración = colaboración;
    }

    public Colaborador(String nombre, Uri imagen, Uri fuente,String colaboración ) {
        this.colaboración = colaboración;
        this.imagen = imagen;
        this.nombre = nombre;
        this.fuente = fuente;
    }
}
