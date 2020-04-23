package br.senac.tads.pi3.dao;

import br.senac.tads.pi3.jdbc.ConexaoFactory;
import br.senac.tads.pi3.model.Filial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Sony
 */
public class FilialDao {

    public FilialDao() {

    }

    public void inserirFilial(Filial filial) throws SQLException {
        Connection conn = ConexaoFactory.Conectar();
        String sql = "INSERT INTO FILIAL(CIDADE, TELEFONE, TIPO) VALUES (?,?,?);";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, filial.getCidade());
            stmt.setString(2, filial.getTelefone());
            stmt.setString(3, filial.getTipo());
            stmt.executeUpdate();
            //CONFIGURAR MENSAGEM DE ADICIONADO COM SUCESSO

        } catch (SQLException e) {
            //CONFIGURAR MENSAGEM DE ERRO
        } finally {
            ConexaoFactory.CloseConnection(conn);
        }
    }

    public ArrayList<Filial> consultarFilial() throws SQLException {
        Connection conn = ConexaoFactory.Conectar();
        String sql = "SELECT * FROM FILIAL;";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            ArrayList<Filial> lista = new ArrayList();
            while (rs.next()) {
                Filial filial = new Filial();
                filial.setCidade(rs.getString("CIDADE"));
                filial.setTelefone(rs.getString("TELEFONE"));
                filial.setTipo(rs.getString("TIPO"));
                lista.add(filial);
            }
            return lista;
        } catch (SQLException e) {
            //CONFIGURAR MENSAGEM DE ERRO
            return null;
        } finally {
            ConexaoFactory.CloseConnection(conn);
        }
    }

    public void editarFilial(Filial filial) throws SQLException {
        Connection conn = ConexaoFactory.Conectar();
        String sql = "UPDATE FILIAL SET CIDADE = ?, TELEFONE = ?, TIPO = ? "
                + " WHERE IDFILIAL = ?;";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, filial.getCidade());
            stmt.setString(2, filial.getTelefone());
            stmt.setString(3, filial.getTipo());
            stmt.setInt(4, filial.getIdFilial());
            stmt.executeUpdate();
        } catch (SQLException e) {
            //CONFIGURAR MENSAGEM DE ERRO
        } finally {
            ConexaoFactory.CloseConnection(conn);
        }
    }
}
