package br.senac.tads.pi3.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Cruiser
 */
public class ConexaoFactory {
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String LOGIN = "root";
    private static final String SENHA = "";
    private static final String URL = "jdbc:mysql://localhost:3306/cruiserbd?zeroDateTimeBehavior=convertToNull";  
    
    
    public static Connection Conectar() throws SQLException {
        
        java.sql.Connection conexao;
        
        try{
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            return conexao;
        } catch (ClassNotFoundException e){
            throw new SQLException(e);
        }
    }
    
    public static void CloseConnection(Connection conn) throws Exception{
        
        try{
            if(conn != null){
                conn.close();
            }
        } catch (SQLException e){
            throw new Exception(e);
        }
    }
    
    
    
}
