package Modelo;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {

    Connection connection = null;
    private static final String URL = "jdbc:mysql://localhost:3306/pruebaproyecto";
    private static final String BD = "pruebaproyecto";
    private static final String USER = "root";
    private static final String PASSWORD = "agentepeke";
    private static Conexion instancia;
    
    public Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebaproyecto", "root", "agentepeke");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    public void cerrarResultado (ResultSet resultado){
        try{
            resultado.close();
        } catch (SQLException error) {
            System.out.println(error);
        }
    }
    
    public void desconectar(Connection conexion){
        try {
            conexion.close();
        } catch (SQLException error) {
            System.out.println(error);
        }
    }
    
    public void cerrarStatement(PreparedStatement statement) {
     try {
            statement.close();
        } catch (SQLException error) {
            System.out.println(error);
        }
    }
    
    public static Conexion getInstance(){
    if (instancia ==null){
        instancia = new Conexion();
    }
    return instancia;
    }
    
    public String getUsuario(){
        return USER;
    }
    
    public String getPassword(){
        return PASSWORD;
    }
    public String getBD(){
        return BD;
    }
    
}
