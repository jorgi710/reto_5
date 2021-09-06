package models;

public class SedeModel {
    private int sed_id;
    private String sed_nombre;
    private String sed_direccion;
    private String sed_telefono;

    public SedeModel(int sed_id, String sed_nombre, String sed_direccion, String sed_telefono) {
        this.sed_id = sed_id;
        this.sed_nombre = sed_nombre;
        this.sed_direccion = sed_direccion;
        this.sed_telefono = sed_telefono;
    }

    public int getSed_id() {
        return sed_id;
    }

    public String getSed_nombre() {
        return sed_nombre;
    }

    public void setSed_nombre(String sed_nombre) {
        this.sed_nombre = sed_nombre;
    }

    public String getSed_direccion() {
        return sed_direccion;
    }

    public void setSed_direccion(String sed_direccion) {
        this.sed_direccion = sed_direccion;
    }

    public String getSed_telefono() {
        return sed_telefono;
    }

    public void setSed_telefono(String sed_telefono) {
        this.sed_telefono = sed_telefono;
    }
}
