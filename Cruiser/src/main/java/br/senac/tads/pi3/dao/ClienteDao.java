package br.senac.tads.pi3.dao;

import br.senac.tads.pi3.jdbc.ConexaoFactory;
import br.senac.tads.pi3.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Sony
 */
public class ClienteDao {

    public ClienteDao() {

    }

    public void inserirCliente(Cliente cliente) throws SQLException {
        Connection conn = ConexaoFactory.Conectar();
        String sql = "INSERT INTO CLIENTE(NOME, CPF, EMAIL) VALUES (?,?,?);";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEmail());
            stmt.executeUpdate();
            //CONFIGURAR MENSAGEM DE ADICIONADO COM SUCESSO

        } catch (SQLException e) {
            //CONFIGURAR MENSAGEM DE ERRO
        } finally {
            ConexaoFactory.CloseConnection(conn);
        }
    }

    public ArrayList<Cliente> consultarCliente() throws SQLException {
        Connection conn = ConexaoFactory.Conectar();
        String sql = "SELECT * FROM CLIENTE;";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            ArrayList<Cliente> lista = new ArrayList();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("IDCLIENTE"));
                cliente.setNome(rs.getString("NOME"));
                cliente.setCpf(rs.getString("CPF"));
                cliente.setEmail(rs.getString("EMAIL"));
                lista.add(cliente);
            }
            return lista;
        } catch (SQLException e) {
            //CONFIGURAR MENSAGEM DE ERRO
            return null;
        } finally {
            ConexaoFactory.CloseConnection(conn);
        }
    }
    
    public void editarCliente(Cliente cliente) throws SQLException {
        Connection conn = ConexaoFactory.Conectar();
        String sql = "UPDATE CLIENTE SET NOME = ?, CPF = ?, EMAIL = ? WHERE IDCLIENTE = ?;";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEmail());
            stmt.setInt(4, cliente.getIdCliente());
            stmt.executeUpdate();
        } catch (SQLException e) {
            //CONFIGURAR MENSAGEM DE ERRO
        } finally {
            ConexaoFactory.CloseConnection(conn);
        }
    }

}
