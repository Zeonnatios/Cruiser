package br.senac.tads.pi3.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Sony
 */
public class ConexaoFactory {
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String LOGIN = "root";
    private static final String SENHA = "";
    private static final String URL = ""; //DEFINIR URL 
    
    
    public static Connection Conectar() {
        java.sql.Connection conexao = null;
        try{
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            return conexao;
        } catch (Exception ErrorSQL){
            //DEFINIR MENSAGEM DE ERRO
            return null;
        }
    }
    
    public static void CloseConnection(Connection conn){
        try{
            if(conn != null){
                conn.close();
            }
        } catch (Exception ErrorSQL){
            //DEFINIR MENSAGEM DE ERRO
        }
    }
    
    
    
}
