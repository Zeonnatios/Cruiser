package br.senac.tads.pi3.dao;

import br.senac.tads.pi3.jdbc.ConexaoFactory;
import br.senac.tads.pi3.model.Cliente;
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
public class ClienteDao {

    public void inserirCliente(Cliente cliente) throws SQLException {
        Connection conn = ConexaoFactory.Conectar();
        String sql = "INSERT INTO CLIENTE(CLI_NOME, CLI_CPF, CLI_EMAIL) VALUES (?,?,?);";
        conn.setAutoCommit(false);

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEmail());
            stmt.executeUpdate();

            //----- RETORNA A ID MAS O MÉTODO AINDA ESTÁ VOID ------
            //usar ostatement.getgeneratedkeys caso
//            try (ResultSet rs = stmt.getGeneratedKeys()) {
//                while (rs.next()) {
//                    int idCliente = rs.getInt(1);
//                }
//            }
            //EXECUTA TODAS AS OPERAÇÕES NO BANCO DE DADOS
            conn.commit();
        } catch (SQLException e) {
            // DESFAZ AS OPERAÇÕES REALIZADAS NO BANCO DE DADOS
            conn.rollback();
        } finally {
            ConexaoFactory.CloseConnection(conn);
        }
    }

    public List<Cliente> listarCliente() throws SQLException {
        Connection conn = ConexaoFactory.Conectar();
        String sql = "SELECT * FROM CLIENTE;";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            List<Cliente> lista = new ArrayList();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("CLI_ID"));
                cliente.setNome(rs.getString("CLI_NOME"));
                cliente.setCpf(rs.getString("CLI_CPF"));
                cliente.setEmail(rs.getString("CLI_EMAIL"));
                lista.add(cliente);
            }
            return lista;
        } catch (SQLException e) {
            return null;
        } finally {
            ConexaoFactory.CloseConnection(conn);
        }
    }

    public void editarCliente(Cliente cliente) throws SQLException {
        Connection conn = ConexaoFactory.Conectar();
        String sql = "UPDATE CLIENTE SET CLI_NOME = ?, CLI_CPF = ?, CLI_EMAIL = ? WHERE CLI_ID = ?;";
        conn.setAutoCommit(false);

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEmail());
            stmt.setInt(4, cliente.getIdCliente());
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

}
