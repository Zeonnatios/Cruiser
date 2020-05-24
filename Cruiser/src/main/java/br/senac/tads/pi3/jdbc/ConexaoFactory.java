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
    //private static final String SENHA = "password";
    private static final String SENHA = "";
    private static final String URL = "jdbc:mysql://localhost:3306/cruiserbd?"
            //private static final String URL = "jdbc:mysql://cruiser.ckgybnlcvrko.us-east-1.rds.amazonaws.com:3306/CRUISERBD?"
            + "useUnicode=yes&"
            + "characterEncoding=UTF-8&"
            + "useTimezone=true&"
            + "serverTimezone=UTC";

    public static final Connection Conectar() throws SQLException {

        java.sql.Connection conexao;

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException ex) {
            throw new SQLException(ex);
        }
        Connection conn = DriverManager.getConnection(URL, LOGIN, SENHA);
        return conn;
    }

    public static void CloseConnection(Connection conn) throws SQLException {

        try {
            if (conn != null) {
                conn.close();
            }

        } catch (Exception ErrorSQL) {
            throw new SQLException(ErrorSQL);
        }
    }

}
