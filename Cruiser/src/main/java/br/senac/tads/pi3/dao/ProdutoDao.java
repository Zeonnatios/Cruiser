package br.senac.tads.pi3.dao;

import br.senac.tads.pi3.jdbc.ConexaoFactory;
import br.senac.tads.pi3.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cruiser
 */
public class ProdutoDao {

    public ProdutoDao() {

    }

    public void inserirProduto(Produto produto) throws SQLException {

        String sql = "INSERT INTO PRODUTO(PROD_NOME, PROD_QTDE, PROD_PRECO, PROD_STATUS, PROD_LOJA_ID)"
                + " VALUES (?,?,?,?,?);";

        try (Connection conn = ConexaoFactory.Conectar()) {

            conn.setAutoCommit(false);

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, produto.getNome());
                stmt.setInt(2, produto.getQuantidade());
                stmt.setDouble(3, produto.getPreco());
                stmt.setBoolean(4, produto.getDisponivel());
                stmt.setInt(5, produto.getIdLoja());
                System.out.println(produto.getIdLoja());
                stmt.executeUpdate();
                //EXECUTA TODAS AS OPERAÇÕES NO BANCO DE DADOS
                conn.commit();
            } catch (Exception e) {
                // DESFAZ AS OPERAÇÕES REALIZADAS NO BANCO DE DADOS
                conn.rollback();
                throw new SQLException(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<Produto> listarProduto(int id) throws SQLException {
        String sql = "SELECT * FROM `PRODUTO` WHERE PRODUTO.prod_loja_id = ?;";

        List<Produto> lista = new ArrayList<>();
        try (Connection conn = ConexaoFactory.Conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    Produto produto = new Produto();
                    produto.setIdProduto(rs.getInt("PROD_ID"));
                    produto.setNome(rs.getString("PROD_NOME"));
                    produto.setQuantidade(rs.getInt("PROD_QTDE"));
                    produto.setPreco(rs.getDouble("PROD_PRECO"));
                    produto.setDisponivel(rs.getBoolean("PROD_STATUS"));
                    lista.add(produto);
                }
            }
            return lista;
        }
    }

    public List<Produto> listarProdutoEstoque(int id) throws SQLException {
        String sql = "SELECT * FROM PRODUTO WHERE PRODUTO.prod_loja_id = ? AND PRODUTO.prod_qtde > 0;";

        List<Produto> lista = new ArrayList<>();
        try (Connection conn = ConexaoFactory.Conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    Produto produto = new Produto();
                    produto.setIdProduto(rs.getInt("PROD_ID"));
                    produto.setNome(rs.getString("PROD_NOME"));
                    produto.setQuantidade(rs.getInt("PROD_QTDE"));
                    produto.setPreco(rs.getDouble("PROD_PRECO"));
                    produto.setDisponivel(rs.getBoolean("PROD_STATUS"));
                    lista.add(produto);
                }
            }
            return lista;
        }
    }

    public void editarProduto(Produto produto) throws SQLException {
        Connection conn = ConexaoFactory.Conectar();
        String sql = "UPDATE PRODUTO SET PROD_NOME = ?, PROD_QTDE = ?, PROD_PRECO = ?, PROD_STATUS = ? WHERE PROD_ID = ?;";
        conn.setAutoCommit(false);

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setInt(2, produto.getQuantidade());
            stmt.setDouble(3, produto.getPreco());
            stmt.setBoolean(4, produto.getDisponivel());
            stmt.setInt(5, produto.getIdProduto());
            stmt.executeUpdate();

            //EXECUTA TODAS AS OPERAÇÕES NO BANCO DE DADOS
            conn.commit();
        } catch (SQLException e) {
            // DESFAZ AS OPERAÇÕES REALIZADAS NO BANCO DE DADOS
            conn.rollback();
            throw new SQLException(e);
        } finally {
            ConexaoFactory.CloseConnection(conn);
        }
    }

    public Produto select(int id) throws SQLException {
        String sql = "SELECT * FROM PRODUTO WHERE PROD_ID = ?;";
        Produto produto = new Produto();
        try (Connection conn = ConexaoFactory.Conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    produto.setIdProduto(rs.getInt("PROD_ID"));
                    produto.setNome(rs.getString("PROD_NOME"));
                    produto.setQuantidade(rs.getInt("PROD_QTDE"));
                    produto.setPreco(rs.getDouble("PROD_PRECO"));
                    produto.setDisponivel(rs.getBoolean("PROD_STATUS"));
                }
            }
        }
        return produto;

    }
}
