package access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import models.TurnoModel;
import utils.ConnectionDB;

public class TurnoDAO {
    private Connection conn = null;

    public ArrayList<TurnoModel> getAllTurno() {
        ArrayList<TurnoModel> turnos = new ArrayList();
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "SELECT tur_numero,tur_fecha,id_asesor FROM turno;";
            Statement statement = conn.createStatement();
            ResultSet result    = statement.executeQuery(sql);

            while (result.next()) {
                TurnoModel turno = new TurnoModel(result.getInt(1),
                        result.getString(2),result.getInt(3));
                turnos.add( turno );
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return turnos;
    }

    public void insertTurno(TurnoModel turno){
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "INSERT INTO turno(tur_numero, tur_fecha, id_asesor ) VALUES (?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, turno.getTur_numero());
            statement.setString(2, turno.getTur_fecha());
            statement.setInt(3, turno.getId_asesor());

            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0)
                JOptionPane.showMessageDialog(null, "The record was successfully added  !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }

    public void updateTurno(TurnoModel turno) {
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "UPDATE turno SET tur_fecha =? WHERE tur_numero=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, turno.getTur_fecha());
            statement.setInt(2, turno.getTur_numero());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0)
                JOptionPane.showMessageDialog(null, "The record was updated successfully !!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }

    public void deleteTurno(int tur_numero) {
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "DELETE FROM turno WHERE tur_numero=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, tur_numero);
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
