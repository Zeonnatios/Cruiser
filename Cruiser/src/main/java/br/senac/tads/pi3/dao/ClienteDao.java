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

        String sql = "INSERT INTO CLIENTE(cli_nome,cli_cpf,cli_email) VALUES (?,?,?);";

        try (Connection conn = ConexaoFactory.Conectar()) {

            conn.setAutoCommit(false);

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, cliente.getNome());
                stmt.setString(2, cliente.getCpf());
                stmt.setString(3, cliente.getEmail());
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

    public List<Cliente> listarCliente() throws SQLException {
        String sql = "SELECT * FROM CLIENTE;";
        List<Cliente> listaCliente = new ArrayList<>();
        try (Connection conn = ConexaoFactory.Conectar();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente();

                cliente.setIdCliente(rs.getInt("cli_id"));
                cliente.setNome(rs.getString("cli_nome"));
                cliente.setCpf(rs.getString("cli_cpf"));
                cliente.setEmail(rs.getString("cli_email"));

                listaCliente.add(cliente);
            }
        }
        return listaCliente;
    }

    public void editarCliente(Cliente cliente) throws SQLException {

        String sql = "UPDATE CLIENTE SET CLI_NOME = ?, CLI_CPF = ?, CLI_EMAIL = ? WHERE CLI_ID = ?;";
        try (Connection conn = ConexaoFactory.Conectar()) {

            conn.setAutoCommit(false);

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, cliente.getNome());
                stmt.setString(2, cliente.getCpf());
                stmt.setString(3, cliente.getEmail());
                stmt.setInt(4, cliente.getIdCliente());
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

    public Cliente select(int id) throws SQLException {
        String sql = "SELECT * FROM CLIENTE WHERE CLI_ID = ?;";
        Cliente cliente = new Cliente();
        try (Connection conn = ConexaoFactory.Conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    cliente.setIdCliente(rs.getInt("CLI_ID"));
                    cliente.setNome(rs.getString("CLI_NOME"));
                    cliente.setCpf(rs.getString("CLI_CPF"));
                    cliente.setEmail(rs.getString("CLI_EMAIL"));

                }
            }
        }
        return cliente;

    }

}
