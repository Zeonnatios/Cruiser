package br.senac.tads.pi3.dao;

import br.senac.tads.pi3.jdbc.ConexaoFactory;
import br.senac.tads.pi3.model.Contas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContasDao {

    public void inserirUsuario(Contas usuario) {
        Connection conn = ConexaoFactory.Conectar();
        String sql = "INSERT INTO USUARIO(nome_usuario, senha_usuario, permissao_usuario) VALUES (?,?,?);";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNomeUsuario());
            stmt.setString(2, usuario.getSenhaUsuario());
            stmt.setString(3, usuario.getPermissaoUsuario());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoFactory.CloseConnection(conn);
        }
    }

    public List<Contas> listar() {
        String sql = "SELECT id_usuario, nome_usuario, senha_usuario, permissao_usuario FROM usuario";

        List<Contas> resultados = new ArrayList<>();
        try (Connection conn = ConexaoFactory.Conectar();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Contas u = new Contas();
                u.setId_usuario(rs.getInt("id_usuario"));
                u.setNomeUsuario(rs.getString("nome_usuario"));
                u.setSenhaUsuario(rs.getString("senha_usuario"));
                u.setPermissaoUsuario(rs.getString("permissao_usuario"));

                resultados.add(u);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultados;
    }
}
