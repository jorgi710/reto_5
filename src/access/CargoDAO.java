package access;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import models.CargoModel;
import utils.ConnectionDB;

public class CargoDAO {
    private Connection conn = null;

    public ArrayList<CargoModel> getAllCargos() {
        ArrayList<CargoModel> cargos = new ArrayList();
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "SELECT car_id,car_nombre,car_description FROM cargo;";
            Statement statement = conn.createStatement();
            ResultSet result    = statement.executeQuery(sql);

            while (result.next()) {
                CargoModel cargo = new CargoModel(result.getInt(1),
                        result.getString(2),result.getString(3));
                cargos.add( cargo );
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return cargos;
    }

    public void insertCargo(CargoModel cargo){
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "INSERT INTO cargo(car_id, car_nombre, car_description ) VALUES (?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, cargo.getCar_id());
            statement.setString(2, cargo.getCar_nombre());
            statement.setString(3, cargo.getCar_description());

            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0)
                JOptionPane.showMessageDialog(null, "The record was successfully added  !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }

    public void updateCargo(CargoModel cargo) {
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "UPDATE cargo SET car_description =? WHERE car_id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, cargo.getCar_description());
            statement.setInt(2, cargo.getCar_id());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0)
                JOptionPane.showMessageDialog(null, "The record was updated successfully !!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }

    public void deleteCargo(int car_id) {
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "DELETE FROM cargo WHERE car_id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, car_id);
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
