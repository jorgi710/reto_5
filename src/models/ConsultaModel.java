package models;

public class ConsultaModel {

    private int con_numero;
    private String con_fecha;
    private String con_observacion;
    private int medico_id;
    private int paciente_id;
    private int tur_numero;

    public ConsultaModel(int con_numero, String con_fecha, String con_observacion, int medico_id, int paciente_id, int tur_numero) {
        this.con_numero = con_numero;
        this.con_fecha = con_fecha;
        this.con_observacion = con_observacion;
        this.medico_id = medico_id;
        this.paciente_id = paciente_id;
        this.tur_numero = tur_numero;
    }

    public int getCon_numero() {
        return con_numero;
    }

    public String getCon_fecha() {
        return con_fecha;
    }

    public String getCon_observacion() {
        return con_observacion;
    }

    public int getMedico_id() {
        return medico_id;
    }

    public int getPaciente_id() {
        return paciente_id;
    }

    public int getTur_numero() {
        return tur_numero;
    }

    public void setCon_fecha(String con_fecha) {
        this.con_fecha = con_fecha;
    }

    public void setCon_observacion(String con_observacion) {
        this.con_observacion = con_observacion;
    }
}
