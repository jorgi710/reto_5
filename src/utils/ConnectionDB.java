package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    private static Connection conn = null;
    private static JSONParser parser = new JSONParser();

    public static Connection getConnection() {

        // conectar
        try {
            String credentials_path = System.getProperty("user.dir") + "/src/utils/db_credentials.json";
            JSONObject jsonObject = (JSONObject)parser.parse(new FileReader(credentials_path));

            String host     = (String)jsonObject.get("db_ip");
            String port     = (String)jsonObject.get("dp_port");
            String username = (String)jsonObject.get("db_user");
            String password = (String)jsonObject.get("db_password");
            String schemaName = (String)jsonObject.get("db_name");
            String dbURL = "jdbc:mysql://"+host+":"+port+"/" + schemaName ;

            conn = DriverManager.getConnection(dbURL, username, password);
            if( conn != null ) System.out.println ( "Successful Connection.." );
        }
        catch( SQLException  ex ) {
            JOptionPane.showMessageDialog(null,"Error : " + ex.getMessage());
            ex.printStackTrace();
        }
        catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }

        return conn;
    }

    static class MiShDwnHook extends Thread{
        //Justo antes de finalizar el programa la JVM invocará
        //este método donde podemos cerra la conexión
        @Override
        public void run(){
            try{
                Connection con = ConnectionDB.getConnection();
                con.close();
                System.out.println("DB CLOSED..");
            }
            catch (SQLException ex){
                JOptionPane.showMessageDialog(null,"Error : " +
                        ex.getMessage());
            }
        }
    }

    public static void main(String[] args){
        getConnection();
    }

}
