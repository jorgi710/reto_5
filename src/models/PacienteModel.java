package models;

public class PacienteModel {

    private int pac_cedula;
    private String pac_apellido;
    private String pac_nombre;
    private String pac_genero;
    private int pac_edad;

    public PacienteModel(int pac_cedula, String pac_apellido, String pac_nombre, String pac_genero, int pac_edad) {
        this.pac_cedula = pac_cedula;
        this.pac_apellido = pac_apellido;
        this.pac_nombre = pac_nombre;
        this.pac_genero = pac_genero;
        this.pac_edad = pac_edad;
    }

    public int getPac_cedula() {
        return pac_cedula;
    }

    public String getPac_apellido() {
        return pac_apellido;
    }

    public void setPac_apellido(String pac_apellido) {
        this.pac_apellido = pac_apellido;
    }

    public String getPac_nombre() {
        return pac_nombre;
    }

    public void setPac_nombre(String pac_nombre) {
        this.pac_nombre = pac_nombre;
    }

    public String getPac_genero() {
        return pac_genero;
    }

    public void setPac_genero(String pac_genero) {
        this.pac_genero = pac_genero;
    }

    public int getPac_edad() {
        return pac_edad;
    }

    public void setPac_edad(int pac_edad) {
        this.pac_edad = pac_edad;
    }

    @Override
    public String toString() {
        return "PacienteModel{" + "pac_nombre='" + pac_nombre + '\'' + '}';
    }
}
