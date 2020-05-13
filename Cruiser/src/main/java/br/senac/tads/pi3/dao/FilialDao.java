package br.senac.tads.pi3.dao;

import br.senac.tads.pi3.jdbc.ConexaoFactory;
import br.senac.tads.pi3.model.Filial;
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
public class FilialDao {

    public FilialDao() {

    }

    public void inserirFilial(Filial filial) throws SQLException {

        String sql = "INSERT INTO LOJA(LOJA_CIDADE, LOJA_TELEFONE, LOJA_TIPO) VALUES (?,?,?);";
        try (Connection conn = ConexaoFactory.Conectar()) {

            conn.setAutoCommit(false);

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, filial.getCidade());
                stmt.setString(2, filial.getTelefone());
                stmt.setString(3, filial.getTipo());
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

    public List<Filial> listarFilial() throws SQLException {

        String sql = "SELECT * FROM LOJA;";
        List<Filial> lista = new ArrayList<>();
        try (Connection conn = ConexaoFactory.Conectar();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Filial filial = new Filial();
                filial.setIdFilial(rs.getInt("LOJA_ID"));
                filial.setCidade(rs.getString("LOJA_CIDADE"));
                filial.setTelefone(rs.getString("LOJA_TELEFONE"));
                filial.setTipo(rs.getString("LOJA_TIPO"));
                lista.add(filial);
            }
        }
        return lista;
    }

    public void editarFilial(Filial filial) throws SQLException {
        Connection conn = ConexaoFactory.Conectar();
        String sql = "UPDATE LOJA SET LOJA_CIDADE = ?, LOJA_TELEFONE = ?, LOJA_TIPO = ? "
                + " WHERE LOJA_ID = ?;";
        conn.setAutoCommit(false);

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, filial.getCidade());
            stmt.setString(2, filial.getTelefone());
            stmt.setString(3, filial.getTipo());
            stmt.setInt(4, filial.getIdFilial());
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

    public Filial select(int id) throws SQLException {
        String sql = "SELECT * FROM LOJA WHERE LOJA_ID = ?;";
        Filial filial = new Filial();
        try (Connection conn = ConexaoFactory.Conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    filial.setIdFilial(rs.getInt("LOJA_ID"));
                    filial.setCidade(rs.getString("LOJA_CIDADE"));
                    filial.setTelefone(rs.getString("LOJA_TELEFONE"));
                    filial.setTipo(rs.getString("LOJA_TIPO"));

                }
            }
        }
        return filial;

    }

}
