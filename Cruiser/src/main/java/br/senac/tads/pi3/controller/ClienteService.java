package br.senac.tads.pi3.controller;

import java.sql.SQLException;
import br.senac.tads.pi3.dao.ClienteDao;
import br.senac.tads.pi3.exception.ClienteException;
import br.senac.tads.pi3.model.Cliente;
import java.util.List;

/**
 *
 * @author Cruiser
 */
public class ClienteService {

    private ClienteDao cliDAO = new ClienteDao();

    public List<Cliente> listarCliente() throws ClienteException {
        try {
            System.out.println("LISTAGEM DE CLIENTES");
            return cliDAO.listarCliente();
        } catch (SQLException e) {
            throw new ClienteException("ERRO NA LISTAGEM DE CLIENTES", e);
        }
    }

    private boolean isValid(Cliente c) {
        return c != null && c.getNome() != null && c.getCpf() != null && c.getEmail() != null;
    }

    public void inserirCliente(Cliente c) throws ClienteException {
        try {
            if (isValid(c)) {
                System.out.println("CADASTRANDO UM CLIENTE");
                cliDAO.inserirCliente(c);
            } else {
                throw new ClienteException("DADOS INVALIDOS", null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ClienteException("ERRO NA INCLUSÃO DOS DADOS", e);
        }
    }

    public Cliente select(int id) throws ClienteException {

        try {
            System.out.println("PESQUISANDO CLIENTE PELO ID");
            return cliDAO.select(id);
        } catch (SQLException e) {
            throw new ClienteException("ERRO AO PESQUISAR DADOS DO CLIENTE", e);
        }

    }

    public void editarCliente(Cliente c) throws ClienteException {

        try {
            if (isValid(c)) {
                System.out.println("ALTERANDO DADOS DE UM CLIENTE");
                cliDAO.editarCliente(c);
            } else {
                throw new ClienteException("DADOS INVALIDOS", null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ClienteException("ERRO NA ATUALIZAÇÃO DOS DADOS", e);
        }

    }
}
