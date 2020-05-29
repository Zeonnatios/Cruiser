package br.senac.tads.pi3.dao;

import br.senac.tads.pi3.jdbc.ConexaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author CRUISER
 */
public class HomeDao {

    public int numeroRegistroClientes() throws SQLException {
        String sql = "SELECT COUNT(*) FROM CLIENTE;";
        int numeroLinhas = 0;
        try (Connection conn = ConexaoFactory.Conectar();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                numeroLinhas = rs.getInt("COUNT(*)");
            }
            System.out.println("linhas " + numeroLinhas);
        }
        return numeroLinhas;
    }

    public int numeroRegistroFucnionariosAtivos() throws SQLException {
        String sql = "SELECT COUNT(*) FROM FUNCIONARIO where func_status = true;";
        int numeroLinhas = 0;
        try (Connection conn = ConexaoFactory.Conectar();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                numeroLinhas = rs.getInt("COUNT(*)");
            }

            //  System.out.println("linhas " + numeroLinhas);
        }
        return numeroLinhas;
    }

    public int numeroRegistroFucnionariosTotal() throws SQLException {
        String sql = "SELECT COUNT(*) FROM FUNCIONARIO;";
        int numeroLinhas = 0;
        try (Connection conn = ConexaoFactory.Conectar();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                numeroLinhas = rs.getInt("COUNT(*)");
            }

            //  System.out.println("linhas " + numeroLinhas);
        }
        return numeroLinhas;
    }

    public int numeroRegistroProdutos() throws SQLException {
        String sql = "SELECT COUNT(*) FROM PRODUTO where prod_qtde > 0;";
        int numeroLinhas = 0;
        try (Connection conn = ConexaoFactory.Conectar();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                numeroLinhas = rs.getInt("COUNT(*)");
            }

            //  System.out.println("linhas " + numeroLinhas);
        }
        return numeroLinhas;
    }

    public int numeroProdutoEstoque() throws SQLException {
        String sql = "SELECT SUM(prod_qtde) FROM PRODUTO where prod_qtde > 0;";
        int numeroLinhas = 0;
        try (Connection conn = ConexaoFactory.Conectar();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                numeroLinhas = rs.getInt("SUM(prod_qtde)");
            }

            //  System.out.println("linhas " + numeroLinhas);
        }
        return numeroLinhas;
    }

}
