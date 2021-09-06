package models;

public class TurnoModel {
    private int tur_numero;
    private String tur_fecha;
    private int id_asesor;

    public TurnoModel(int tur_numero, String tur_fecha, int id_asesor) {
        this.tur_numero = tur_numero;
        this.tur_fecha = tur_fecha;
        this.id_asesor = id_asesor;
    }

    public int getTur_numero() {
        return tur_numero;
    }

    public String getTur_fecha() {
        return tur_fecha;
    }

    public void setTur_fecha(String tur_fecha) {
        this.tur_fecha = tur_fecha;
    }

    public int getId_asesor() {
        return id_asesor;
    }

}
