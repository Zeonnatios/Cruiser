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
            System.out.println("LISTAGEM DE FUNCIONARIOS");
            return funDAO.listarFuncionario();
        } catch (SQLException e) {
            throw new FuncionarioException("ERRO NA LISTAGEM DE FUNCIONARIOS", e);
        }
    }

    private boolean isValid(Funcionario f) {
        return f != null && f.getNome() != null && f.getSenha() != null && f.getEmail() != null
                && f.getCidade() != null && f.getDepartamento() != null;
    }

    public void inserirFuncionario(Funcionario f) throws FuncionarioException {
        try {
            if (isValid(f)) {
                System.out.println("CADASTRANDO UM FUNCIONÁRIO");
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
            System.out.println("PESQUISANDO FUNCIONÁRIO PELO ID");
            return funDAO.select(id);
        } catch (SQLException e) {
            throw new FuncionarioException("ERRO AO PESQUISAR DADOS DO FUNCIONÁRIO", e);
        }

    }

    public void editarFuncionario(Funcionario f) throws FuncionarioException {

        try {
            if (isValid(f)) {
                System.out.println("ALTERANDO DADOS DE UM FUNCIONÁRIO");
                funDAO.editarFuncionario(f);
            } else {
                throw new FuncionarioException("DADOS INVALIDOS", null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new FuncionarioException("ERRO NA ATUALIZAÇÃO DOS DADOS", e);
        }

    }

}
