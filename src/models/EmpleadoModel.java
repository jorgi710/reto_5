package models;

public class EmpleadoModel {

    private int emp_cedula;
    private String emp_apellidos;
    private String emp_nombres;
    private int id_cargo;
    private int id_sede;

    public EmpleadoModel(int emp_cedula, String emp_apellidos, String emp_nombres, int id_cargo, int id_sede) {
        this.emp_cedula = emp_cedula;
        this.emp_apellidos = emp_apellidos;
        this.emp_nombres = emp_nombres;
        this.id_cargo = id_cargo;
        this.id_sede = id_sede;
    }

    public int getEmp_cedula() {
        return emp_cedula;
    }

    public String getEmp_apellidos() {
        return emp_apellidos;
    }

    public String getEmp_nombres() {
        return emp_nombres;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public int getId_sede() {
        return id_sede;
    }

    public void setEmp_apellidos(String emp_apellidos) {
        this.emp_apellidos = emp_apellidos;
    }

    public void setEmp_nombres(String emp_nombres) {
        this.emp_nombres = emp_nombres;
    }
}
