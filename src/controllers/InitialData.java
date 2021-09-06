package controllers;

import access.*;
import models.*;

import java.util.ArrayList;

public class InitialData {
    private ArrayList<CargoModel> cargos = null;
    private ArrayList<ConsultaModel> consultas = null;
    private ArrayList<EmpleadoModel> empleados = null;
    private ArrayList<PacienteModel> pacientes = null;
    private ArrayList<SedeModel> sedes = null;
    private ArrayList<TurnoModel> turnos = null;

    public InitialData() {
        CargoDAO  cargoDao=new CargoDAO();
        this.cargos = cargoDao.getAllCargos();

        ConsultaDAO  consultaDao=new ConsultaDAO();
        this.consultas = consultaDao.getAllConsultas();

        EmpleadoDAO  empleadoDao=new EmpleadoDAO();
        this.empleados = empleadoDao.getAllEmpleados();

        PacienteDAO  pacienteDao=new PacienteDAO();
        this.pacientes = pacienteDao.getAllPacientes();

        SedeDAO  sedeDao=new SedeDAO();
        this.sedes = sedeDao.getAllSede();

        TurnoDAO turnoDao=new TurnoDAO();
        this.turnos = turnoDao.getAllTurno();
    }

    public ArrayList<PacienteModel> getPacientes() {
        return pacientes;
    }

    public ArrayList<CargoModel> getCargos() {
        return cargos;
    }

    public ArrayList<ConsultaModel> getConsultas() {
        return consultas;
    }

    public ArrayList<EmpleadoModel> getEmpleados() {
        return empleados;
    }

    public ArrayList<SedeModel> getSedes() {
        return sedes;
    }

    public ArrayList<TurnoModel> getTurnos() {
        return turnos;
    }
}
