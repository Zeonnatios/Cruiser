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
        String sql = "INSERT INTO LOJA(LOJA_CIDADE, LOJA_TELEFONE, LOJA_TIPO) VALUES (?,?,?);";

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
        String sql = "SELECT * FROM LOJA;";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            ArrayList<Filial> lista = new ArrayList();
            while (rs.next()) {
                Filial filial = new Filial();
                filial.setIdFilial(rs.getInt("LOJA_ID"));
                filial.setCidade(rs.getString("LOJA_CIDADE"));
                filial.setTelefone(rs.getString("LOJA_TELEFONE"));
                filial.setTipo(rs.getString("LOJA_TIPO"));
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
        String sql = "UPDATE LOJA SET LOJA_CIDADE = ?, LOJA_TELEFONE = ?, LOJA_TIPO = ? "
                + " WHERE LOJA_ID = ?;";

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
