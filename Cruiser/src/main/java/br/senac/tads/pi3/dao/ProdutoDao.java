package br.senac.tads.pi3.dao;

import br.senac.tads.pi3.jdbc.ConexaoFactory;
import br.senac.tads.pi3.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Sony
 */
public class ProdutoDao {

    public ProdutoDao() {

    }

    public void inserirProduto(Produto produto) throws SQLException {
        Connection conn = ConexaoFactory.Conectar();
        String sql = "INSERT INTO PRODUTO(NOME, QUANTIDADE, PRECO, "
                + "DISPONIVEL) VALUES (?,?,?,?);";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setInt(2, produto.getQuantidade());
            stmt.setDouble(3, produto.getPreco());
            stmt.setBoolean(4, produto.getDisponivel());
            stmt.executeUpdate();

        } catch (SQLException e) {
            //CONFIGURAR MENSAGEM DE ERRO
        } finally {
            ConexaoFactory.CloseConnection(conn);
        }
    }

    public ArrayList<Produto> consultarProduto() throws SQLException {
        Connection conn = ConexaoFactory.Conectar();
        String sql = "SELECT * FROM PRODUTO;";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            ArrayList<Produto> lista = new ArrayList();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("IDPRODUTO"));
                produto.setNome(rs.getString("NOME"));
                produto.setQuantidade(rs.getInt("QUANTIDADE"));
                produto.setPreco(rs.getDouble("PRECO"));
                produto.setDisponivel(rs.getBoolean("DISPONIVEL"));
                lista.add(produto);
            }
            return lista;
        } catch (SQLException e) {
            //CONFIGURAR MENSAGEM DE ERRO
            return null;
        } finally {
            ConexaoFactory.CloseConnection(conn);
        }
    }

    public void editarProduto(Produto produto) throws SQLException {
        Connection conn = ConexaoFactory.Conectar();
        String sql = "UPDATE PRODUTO SET NOME = ?, QUANTIDADE = ?, PRECO = ?, DISPONIVEL = ? WHERE IDPRODUTO = ?;";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setInt(2, produto.getQuantidade());
            stmt.setDouble(3, produto.getPreco());
            stmt.setBoolean(4, produto.getDisponivel());
            stmt.setInt(5, produto.getIdProduto());
            stmt.executeUpdate();
        } catch (SQLException e) {
            //CONFIGURAR MENSAGEM DE ERRO
        } finally {
            ConexaoFactory.CloseConnection(conn);
        }
    }
}
