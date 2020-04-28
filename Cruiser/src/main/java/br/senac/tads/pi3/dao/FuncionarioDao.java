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
        String sql = "INSERT INTO FUNCIONARIO(func_id, func_nome, func_email, func_senha, func_cidade,func_departamento, func_status )"
                + "VALUES (?,?,?,?,?,?,?);";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, funcionario.getIdFuncionario());
            stmt.setString(2, funcionario.getNome());
            stmt.setString(3, funcionario.getEmail());
            stmt.setString(4, funcionario.getSenha());
            stmt.setString(5, funcionario.getCidade());
            stmt.setString(6, funcionario.getDepartamento());
            stmt.setString(7, funcionario.getStatus());
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
                funcionario.setIdFuncionario(rs.getInt("IDFUNCIONARIO"));
                funcionario.setNome(rs.getString("NOME"));
                funcionario.setEmail(rs.getString("EMAIL"));
                funcionario.setSenha(rs.getString("SENHA"));
                funcionario.setCidade(rs.getString("CIDADE"));
                funcionario.setDepartamento(rs.getString("DEPARTAMENTO"));
                funcionario.setStatus(rs.getString("STATUS"));
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
        String sql = "UPDATE FUNCIONARIO SET IDFILIAL = ?, NOME = ?, EMAIL = ?,"
                + "SENHA = ?, DEPARTAMENTO = ?, STATUS = ? WHERE IDFUNCIONARIO = ?;";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getEmail());
            stmt.setString(3, funcionario.getSenha());
            stmt.setString(4, funcionario.getCidade());
            stmt.setString(5, funcionario.getDepartamento());
            stmt.setString(6, funcionario.getStatus());
            stmt.setInt(7, funcionario.getIdFuncionario());
            stmt.executeUpdate();
        } catch (SQLException e) {
            //CONFIGURAR MENSAGEM DE ERRO
        } finally {
            ConexaoFactory.CloseConnection(conn);
        }
    }

    public void ativarInativarFuncionario(Funcionario funcionario) throws SQLException {
        Connection conn = ConexaoFactory.Conectar();
        String sql = "UPDATE FUNCIONARIO SET STATUS = ? WHERE IDFUNCIONARIO = ?;";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getStatus());
            stmt.setInt(2, funcionario.getIdFuncionario());
            stmt.executeUpdate();
        } catch (SQLException e) {
            //CONFIGURAR MENSAGEM DE ERRO
        } finally {
            ConexaoFactory.CloseConnection(conn);
        }
    }
}
