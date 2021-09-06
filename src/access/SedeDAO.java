package access;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import models.SedeModel;
import utils.ConnectionDB;

public class SedeDAO {
    private Connection conn = null;

    public ArrayList<SedeModel> getAllSede() {
        ArrayList<SedeModel> sedes = new ArrayList();
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "SELECT sed_id,sed_nombre,sed_direccion,sed_telefono FROM sede;";
            Statement statement = conn.createStatement();
            ResultSet result    = statement.executeQuery(sql);

            while (result.next()) {
                SedeModel sede = new SedeModel(result.getInt(1),
                        result.getString(2),result.getString(3),
                        result.getString(4));
                sedes.add( sede );
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return sedes;
    }

    public void insertSede(SedeModel sede){
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "INSERT INTO sede(sed_id, sed_nombre, sed_direccion,sed_telefono ) VALUES (?, ?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, sede.getSed_id());
            statement.setString(2, sede.getSed_nombre());
            statement.setString(3, sede.getSed_direccion());
            statement.setString(4, sede.getSed_telefono());

            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0)
                JOptionPane.showMessageDialog(null, "The record was successfully added  !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }

    public void updateSede(SedeModel sede) {
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "UPDATE sede SET sed_nombre =? WHERE sed_id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, sede.getSed_nombre());
            statement.setInt(2, sede.getSed_id());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0)
                JOptionPane.showMessageDialog(null, "The record was updated successfully !!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }

    public void deleteSede(int sed_id) {
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "DELETE FROM sede WHERE sed_id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, sed_id);
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
