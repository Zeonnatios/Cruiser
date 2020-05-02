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

        String sql = "INSERT INTO CLIENTE(CLI_NOME, CLI_CPF, CLI_EMAIL) VALUES (?,?,?);";

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
        List<Cliente> clientes = new ArrayList<>();
        try (Connection conn = ConexaoFactory.Conectar();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cliente c = new Cliente();

                c.setIdCliente(rs.getInt("cli_id"));
                c.setNome(rs.getString("cli_nome"));
                c.setCpf(rs.getString("cli_cpf"));
                c.setEmail(rs.getString("cli_email"));

                clientes.add(c);
            }
        }
        return clientes;
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

}
