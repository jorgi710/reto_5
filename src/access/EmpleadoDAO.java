package access;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import models.EmpleadoModel;
import utils.ConnectionDB;

public class EmpleadoDAO {
    private Connection conn = null;

    public ArrayList<EmpleadoModel> getAllEmpleados() {
        ArrayList<EmpleadoModel> empleados = new ArrayList();
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "SELECT emp_cedula,emp_apellidos,emp_nombres,id_cargo,id_sede FROM empleado;";
            Statement statement = conn.createStatement();
            ResultSet result    = statement.executeQuery(sql);

            while (result.next()) {
                EmpleadoModel empleado = new EmpleadoModel(result.getInt(1),
                        result.getString(2),result.getString(3),
                        result.getInt(4),result.getInt(5));
                empleados.add(empleado);
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return empleados;
    }

    public void insertEmpleado(EmpleadoModel empleado){
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "INSERT INTO empleado(emp_cedula, emp_apellidos, emp_nombres,id_cargo,id_sede ) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, empleado.getEmp_cedula());
            statement.setString(2, empleado.getEmp_apellidos());
            statement.setString(3, empleado.getEmp_nombres());
            statement.setInt(4,empleado.getId_cargo());
            statement.setInt(5, empleado.getId_sede());


            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0)
                JOptionPane.showMessageDialog(null, "The record was successfully added  !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }

    public void updateEmpleado(EmpleadoModel empleado) {
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "UPDATE empleado SET emp_nombres =? WHERE emp_cedula=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, empleado.getEmp_nombres());
            statement.setInt(2, empleado.getEmp_cedula());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0)
                JOptionPane.showMessageDialog(null, "The record was updated successfully !!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }

    public void deleteEmpleado(int emp_cedula) {
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "DELETE FROM empleado WHERE emp_cedula=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, emp_cedula);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "The record was successfully eliminated !!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }


}
