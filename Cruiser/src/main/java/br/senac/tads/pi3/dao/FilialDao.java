package br.senac.tads.pi3.dao;

import br.senac.tads.pi3.jdbc.ConexaoFactory;
import br.senac.tads.pi3.model.Filial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Cruiser
 */
public class FilialDao {

    public FilialDao() {

    }

    public void inserirFilial(Filial filial) throws SQLException {
        Connection conn = ConexaoFactory.Conectar();
        String sql = "INSERT INTO LOJA(LOJA_CIDADE, LOJA_TELEFONE, LOJA_TIPO) VALUES (?,?,?);";
        conn.setAutoCommit(false);

        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, filial.getCidade());
            stmt.setString(2, filial.getTelefone());
            stmt.setString(3, filial.getTipo());
            stmt.executeUpdate();

            //----- RETORNA A ID MAS O MÉTODO AINDA ESTÁ VOID ------
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                while (rs.next()) {
                    int idFilial = rs.getInt(1);
                }
            }

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

    public ArrayList<Filial> listarFilial() throws SQLException {
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
            throw new SQLException(e);
        } finally {
            ConexaoFactory.CloseConnection(conn);
        }
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
}
