package br.senac.tads.pi3.dao;

import br.senac.tads.pi3.jdbc.ConexaoFactory;
import br.senac.tads.pi3.model.Venda;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author lukas
 */
public class VendasDao {

    public VendasDao() {
        
    }

   
    
    public void inserirItem(Venda venda) throws SQLException {

        String sql = "INSERT INTO VENDA( VENDA_DATA, VENDA_VALOR_TOTAL, VENDA_PRODUTO_ID, VENDA_CLIENTE_ID"
                + ") VALUES (?,?,?,?);";

        try (Connection conn = ConexaoFactory.Conectar()) {

            conn.setAutoCommit(false);

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setDate(1, (Date) venda.getDataVenda());
                stmt.setDouble(2, venda.getValorTotal());
                stmt.setInt(3, venda.getProduto().getIdProduto());
                stmt.setInt(4, venda.getCliente().getIdCliente());
               
                stmt.executeUpdate();
                
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
}
