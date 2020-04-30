package br.senac.tads.pi3.dao;

import br.senac.tads.pi3.jdbc.ConexaoFactory;
import br.senac.tads.pi3.model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Sony
 */
public class FuncionarioDao {

    public FuncionarioDao() {

    }

    public void inserirFuncionario(Funcionario funcionario) throws SQLException {

        Connection conn = ConexaoFactory.Conectar();
        String sql = "INSERT INTO FUNCIONARIO(func_nome, func_email, func_senha, func_cidade,func_departamento, func_status, func_loja_id)"
                + "VALUES (?,?,?,?,?,?,?);";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getEmail());
            stmt.setString(3, funcionario.getSenha());
            stmt.setString(4, funcionario.getCidade());
            stmt.setString(5, funcionario.getDepartamento());
            stmt.setBoolean(6, funcionario.getStatus());
            stmt.setInt(7, funcionario.getIdLoja());
            stmt.executeUpdate();
            //CONFIGURAR MENSAGEM DE ADICIONADO COM SUCESSO

        } catch (SQLException e) {
            //CONFIGURAR MENSAGEM DE ERRO
        } finally {
            ConexaoFactory.CloseConnection(conn);
        }
    }

    public ArrayList<Funcionario> consultarFuncionario() throws SQLException {
        Connection conn = ConexaoFactory.Conectar();
        String sql = "SELECT * FROM FUNCIONARIO;";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            ArrayList<Funcionario> lista = new ArrayList();
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();

                funcionario.setNome(rs.getString("FUNC_NOME"));
                funcionario.setEmail(rs.getString("FUNC_EMAIL"));
                funcionario.setSenha(rs.getString("FUNC_SENHA"));
                funcionario.setCidade(rs.getString("FUNC_CIDADE"));
                funcionario.setDepartamento(rs.getString("FUNC_DEPARTAMENTO"));
                funcionario.setStatus(rs.getBoolean("FUNC_STATUS"));
                funcionario.setIdLoja(rs.getInt("FUNC_LOJA_ID"));
                lista.add(funcionario);
            }
            return lista;
        } catch (SQLException e) {
            //CONFIGURAR MENSAGEM DE ERRO
            return null;
        } finally {
            ConexaoFactory.CloseConnection(conn);
        }
    }

    public void editarFuncionario(Funcionario funcionario) throws SQLException {
        Connection conn = ConexaoFactory.Conectar();
        String sql = "UPDATE FUNCIONARIO SET FUNC_NOME = ?, FUNC_EMAIL = ?,"
                + "FUNC_SENHA = ?, FUNC_CIDADE = ?, FUNC_DEPARTAMENTO = ?, FUNC_STATUS = ?, FUNC_LOJA_ID = ? WHERE FUNC_ID = ?;";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getEmail());
            stmt.setString(3, funcionario.getSenha());
            stmt.setString(4, funcionario.getCidade());
            stmt.setString(5, funcionario.getDepartamento());
            stmt.setBoolean(6, funcionario.getStatus());
            stmt.setInt(7, funcionario.getIdLoja());
            stmt.setInt(8, funcionario.getIdFuncionario());
            stmt.executeUpdate();
        } catch (SQLException e) {
            //CONFIGURAR MENSAGEM DE ERRO
        } finally {
            ConexaoFactory.CloseConnection(conn);
        }
    }

    public void ativarInativarFuncionario(Funcionario funcionario) throws SQLException {
        Connection conn = ConexaoFactory.Conectar();
        String sql = "UPDATE FUNCIONARIO SET FUNC_STATUS = ? WHERE FUNC_ID = ?;";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setBoolean(1, funcionario.getStatus());
            stmt.setInt(2, funcionario.getIdFuncionario());
            stmt.executeUpdate();
        } catch (SQLException e) {
            //CONFIGURAR MENSAGEM DE ERRO
        } finally {
            ConexaoFactory.CloseConnection(conn);
        }
    }

    public Funcionario autenticar(Funcionario funcionario) throws SQLException {
        Connection conn = ConexaoFactory.Conectar();
        String sql = "SELECT * FROM FUNCIONARIO WHERE FUNC_EMAIL = ? AND FUNC_SENHA = ? AND FUNC_STATUS = ?;";
        Funcionario f = new Funcionario();

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getEmail());
            stmt.setString(2, funcionario.getSenha());
            stmt.setBoolean(3, true);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                f = new Funcionario();
                f.setIdFuncionario(rs.getInt("FUNC_ID"));
                f.setNome(rs.getString("FUNC_NOME"));
                f.setEmail(rs.getString("FUNC_EMAIL"));
                f.setSenha(rs.getString("FUNC_SENHA"));
                f.setDepartamento(rs.getString("FUNC_DEPARTAMENTO"));
                f.setDepartamento(rs.getString("FUNC_CIDADE"));
                f.setStatus(rs.getBoolean("FUNC_STATUS"));
                f.setIdLoja(rs.getInt("FUNC_LOJA_ID"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            //CONFIGURAR MENSAGEM DE ERRO
        } finally {
            ConexaoFactory.CloseConnection(conn);
        }
        return f;
    }
}
