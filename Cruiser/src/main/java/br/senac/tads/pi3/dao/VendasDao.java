package br.senac.tads.pi3.dao;

import br.senac.tads.pi3.jdbc.ConexaoFactory;
import br.senac.tads.pi3.model.Produto;
import br.senac.tads.pi3.model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author CRUISER
 */
public class VendasDao {

    public VendasDao() {

    }

    public void inserirItem(Venda venda) throws SQLException {
        String sql = "INSERT INTO VENDA( VENDA_DATA, VENDA_VALOR_TOTAL, VENDA_FUNCIONARIO_ID, VENDA_CLIENTE_ID)"
                + "VALUES (?,?,?,?);";

        try (Connection conn = ConexaoFactory.Conectar()) {
            conn.setAutoCommit(false);

            try (PreparedStatement stmtVenda = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                stmtVenda.setDate(1, java.sql.Date.valueOf(venda.getDataVenda()));
                stmtVenda.setDouble(2, venda.getValorTotal());
                stmtVenda.setInt(3, venda.getIdFuncionario());
                stmtVenda.setInt(4, venda.getIdCliente());

                int resultados = stmtVenda.executeUpdate();

                try (ResultSet rs = stmtVenda.getGeneratedKeys()) {

                    while (rs.next()) {
                        Integer idGerado = rs.getInt(1);

                        String sqlItens = "INSERT INTO ITENS(itens_prod_id, itens_venda_id, itens_quantidade, itens_preco_unit) "
                                + "VALUES (?, ?, ?, ?)";
                        String sqlEstoque = "UPDATE PRODUTO SET PRODUTO.prod_qtde = prod_qtde - ? WHERE prod_id = ?";

                        if (venda.getProduto() != null && !venda.getProduto().isEmpty()) {
                            for (Produto p : venda.getProduto()) {
                                try (PreparedStatement stmtItens = conn.prepareStatement(sqlItens)) {
                                    stmtItens.setInt(1, p.getIdProduto());
                                    stmtItens.setInt(2, idGerado);
                                    stmtItens.setInt(3, p.getQuantidade());
                                    stmtItens.setDouble(4, p.getPreco());
                                    int resultadoItens = stmtItens.executeUpdate();
                                }
                                try (PreparedStatement stmtEstoque = conn.prepareStatement(sqlEstoque)) {
                                    stmtEstoque.setInt(1, p.getQuantidade());
                                    stmtEstoque.setInt(2, p.getIdProduto());
                                    int resultadoEstoque = stmtEstoque.executeUpdate();
                                }
                            }
                        }

                    }
                }

                conn.commit();
            } catch (Exception e) {
                conn.rollback();
                throw new SQLException(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public int consultarEstoque(int id) throws SQLException {
        String sql = "SELECT PRODUTO.prod_qtde FROM PRODUTO WHERE PRODUTO.prod_id = ?;";
        int quantidade = 0;
        try (Connection conn = ConexaoFactory.Conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    quantidade = rs.getInt("prod_qtde");
                }
            }
        }
        return quantidade;
    }

}
