package br.senac.tads.pi3.controller;

import java.util.List;
import java.sql.SQLException;
import br.senac.tads.pi3.dao.FuncionarioDao;
import br.senac.tads.pi3.exception.FuncionarioException;
import br.senac.tads.pi3.model.Funcionario;

/**
 *
 * @author Cruiser
 */
public class FuncionarioService {

    private FuncionarioDao funDAO = new FuncionarioDao();

    public List<Funcionario> listarFuncionarios() throws FuncionarioException {
        try {
            System.out.println("LSITAGEM DE FUNCIONARIOS");
            return funDAO.listarFuncionario();
        } catch (SQLException e) {
            throw new FuncionarioException("ERRO NA LSITAGEM DE FUNCIONARIOS", e);
        }
    }

    private boolean isValid(Funcionario f) {
        return f != null && f.getNome() != null && f.getSenha() != null && f.getEmail() != null
                && f.getCidade() != null && f.getDepartamento() != null;
    }

    public void inserirFuncionario(Funcionario f) throws FuncionarioException {
        try {
            if (isValid(f)) {
                funDAO.inserirFuncionario(f);
            } else {
                throw new FuncionarioException("DADOS INVALIDOS", null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new FuncionarioException("ERRO NA INCLUSÃO DOS DADOS", e);
        }
    }

    public Funcionario select(int id) throws FuncionarioException {

        try {
            return funDAO.select(id);
        } catch (SQLException e) {
            throw new FuncionarioException("ERRO NA INCLUSÃO DOS DADOS", e);
        }

    }

}
