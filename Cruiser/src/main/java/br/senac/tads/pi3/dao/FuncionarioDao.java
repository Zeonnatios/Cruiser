package br.senac.tads.pi3.dao;

import br.senac.tads.pi3.jdbc.ConexaoFactory;
import br.senac.tads.pi3.model.Funcionario;
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
public class FuncionarioDao {

    public FuncionarioDao() {

    }

    public void inserirFuncionario(Funcionario funcionario) throws SQLException {

        String sql = "INSERT INTO FUNCIONARIO(FUNC_NOME, FUNC_EMAIL, FUNC_SENHA, FUNC_CIDADE, FUNC_DEPARTAMENTO, FUNC_STATUS, FUNC_LOJA_ID)"
                + "VALUES (?,?,?,?,?,?,?);";
        try (Connection conn = ConexaoFactory.Conectar()) {

            conn.setAutoCommit(false);
            String pesquisarCidade = funcionario.getCidade();
            Funcionario f = new Funcionario();
            f = pegarIdLoja(pesquisarCidade);

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, funcionario.getNome());
                stmt.setString(2, funcionario.getEmail());
                stmt.setString(3, funcionario.getSenha());
                stmt.setString(4, funcionario.getCidade());
                stmt.setString(5, funcionario.getDepartamento());
                stmt.setBoolean(6, funcionario.getStatus());
                stmt.setInt(7, f.getIdLoja());
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

    public List<Funcionario> listarFuncionario() throws SQLException {
        String sql = "SELECT * FROM FUNCIONARIO;";
        List<Funcionario> lista = new ArrayList<>();
        try (Connection conn = ConexaoFactory.Conectar();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setIdFuncionario(rs.getInt("FUNC_ID"));
                funcionario.setNome(rs.getString("FUNC_NOME"));
                funcionario.setEmail(rs.getString("FUNC_EMAIL"));
                funcionario.setSenha(rs.getString("FUNC_SENHA"));
                funcionario.setCidade(rs.getString("FUNC_CIDADE"));
                funcionario.setDepartamento(rs.getString("FUNC_DEPARTAMENTO"));
                funcionario.setStatus(rs.getBoolean("FUNC_STATUS"));
                funcionario.setIdLoja(rs.getInt("FUNC_LOJA_ID"));
                lista.add(funcionario);
            }
        }
        return lista;
    }

    public void editarFuncionario(Funcionario funcionario) throws SQLException {

        String sql = "UPDATE FUNCIONARIO SET FUNC_NOME = ?, FUNC_EMAIL = ?, FUNC_SENHA = ?, FUNC_CIDADE = ?,"
                + "FUNC_DEPARTAMENTO = ?, FUNC_STATUS = ?, FUNC_LOJA_ID = ? WHERE FUNC_ID = ?;";
        try (Connection conn = ConexaoFactory.Conectar()) {

            conn.setAutoCommit(false);
            String pesquisarCidade = funcionario.getCidade();
            Funcionario f = new Funcionario();
            f = pegarIdLoja(pesquisarCidade);

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, funcionario.getNome());
                stmt.setString(2, funcionario.getEmail());
                stmt.setString(3, funcionario.getSenha());
                stmt.setString(4, funcionario.getCidade());
                stmt.setString(5, funcionario.getDepartamento());
                stmt.setBoolean(6, funcionario.getStatus());
                stmt.setInt(7, f.getIdLoja());
                stmt.setInt(8, funcionario.getIdFuncionario());
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

    public Funcionario pegarIdLoja(String cidade) throws SQLException {
        int idLoja = 0;
        Funcionario f = new Funcionario();
        String sql = "SELECT * FROM LOJA WHERE LOJA_CIDADE = ?;";
        try (Connection conn = ConexaoFactory.Conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cidade);
            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    f.setIdLoja(rs.getInt("loja_id"));
                }

            }
        }
        return f;
    }

//    public void ativarInativarFuncionario(Funcionario funcionario) throws SQLException {
//        Connection conn = ConexaoFactory.Conectar();
//        String sql = "UPDATE FUNCIONARIO SET FUNC_STATUS = ? WHERE FUNC_ID = ?;";
//
//        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
//            stmt.setBoolean(1, funcionario.getStatus());
//            stmt.setInt(2, funcionario.getIdFuncionario());
//            stmt.executeUpdate();
//        } catch (SQLException e) {
//            throw new SQLException(e);
//        } finally {
//            ConexaoFactory.CloseConnection(conn);
//        }
//    }
    public Funcionario select(int id) throws SQLException {
        String sql = "SELECT * FROM FUNCIONARIO WHERE FUNC_ID = ?;";
        Funcionario funcionario = new Funcionario();
        try (Connection conn = ConexaoFactory.Conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    funcionario.setIdFuncionario(rs.getInt("FUNC_ID"));
                    funcionario.setNome(rs.getString("FUNC_NOME"));
                    funcionario.setEmail(rs.getString("FUNC_EMAIL"));
                    funcionario.setSenha(rs.getString("FUNC_SENHA"));
                    funcionario.setCidade(rs.getString("FUNC_CIDADE"));
                    funcionario.setDepartamento(rs.getString("FUNC_DEPARTAMENTO"));
                    funcionario.setStatus(rs.getBoolean("FUNC_STATUS"));
                    funcionario.setIdLoja(rs.getInt("FUNC_LOJA_ID"));
                }
            }
        }
        return funcionario;

    }

    public Funcionario autenticar(Funcionario funcionario) throws SQLException {
        Connection conn = ConexaoFactory.Conectar();
        String sql = "SELECT * FROM FUNCIONARIO WHERE FUNC_EMAIL = ?;";
        Funcionario f = new Funcionario();

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getEmail());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                f = new Funcionario();
                f.setIdFuncionario(rs.getInt("FUNC_ID"));
                f.setNome(rs.getString("FUNC_NOME"));
                f.setEmail(rs.getString("FUNC_EMAIL"));
                f.setSenha(rs.getString("FUNC_SENHA"));
                f.setDepartamento(rs.getString("FUNC_DEPARTAMENTO"));
                f.setCidade(rs.getString("FUNC_CIDADE"));
                f.setStatus(rs.getBoolean("FUNC_STATUS"));
                f.setIdLoja(rs.getInt("FUNC_LOJA_ID"));
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        } finally {
            ConexaoFactory.CloseConnection(conn);
        }
        return f;
    }
}
