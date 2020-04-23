package br.senac.tads.pi3.dao;

import br.senac.tads.pi3.jdbc.ConexaoFactory;
import br.senac.tads.pi3.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}
