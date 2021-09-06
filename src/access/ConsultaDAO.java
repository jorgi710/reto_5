package access;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import models.ConsultaModel;
import utils.ConnectionDB;

public class ConsultaDAO {
    private Connection conn = null;

    public ArrayList<ConsultaModel> getAllConsultas() {
        ArrayList<ConsultaModel> consultas = new ArrayList();
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "SELECT con_numero,con_fecha,con_observacion,medico_id,paciente_id,tur_numero FROM consulta;";
            Statement statement = conn.createStatement();
            ResultSet result    = statement.executeQuery(sql);

            while (result.next()) {
                ConsultaModel consulta = new ConsultaModel(result.getInt(1),
                        result.getString(2),result.getString(3),
                        result.getInt(4),result.getInt(5),
                        result.getInt(6));
                consultas.add(consulta);
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return consultas;
    }

    public void insertConsulta(ConsultaModel consulta){
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "INSERT INTO consulta(con_numero, con_fecha, con_observacion,medico_id,paciente_id,tur_numero ) VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, consulta.getCon_numero());
            statement.setString(2, consulta.getCon_fecha());
            statement.setString(3, consulta.getCon_observacion());
            statement.setInt(4,consulta.getMedico_id());
            statement.setInt(5, consulta.getPaciente_id());
            statement.setInt(6, consulta.getTur_numero());


            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0)
                JOptionPane.showMessageDialog(null, "The record was successfully added  !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }

    public void updateConsulta(ConsultaModel consulta) {
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "UPDATE consulta SET con_observacion =? WHERE con_numero=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, consulta.getCon_observacion());
            statement.setInt(2, consulta.getCon_numero());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0)
                JOptionPane.showMessageDialog(null, "The record was updated successfully !!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }

    public void deleteConsulta(int con_numero) {
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "DELETE FROM consulta WHERE con_numero=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, con_numero);
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
