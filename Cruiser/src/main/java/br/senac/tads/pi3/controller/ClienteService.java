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
            System.out.println("LSITAGEM DE CLIENTES");
            return cliDAO.listarCliente();
        } catch (SQLException e) {
            throw new ClienteException("ERRO NA LSITAGEM DE CLIENTES", e);
        }
    }

    private boolean isValid(Cliente c) {
        return c != null && c.getNome() != null && c.getCpf() != null && c.getEmail() != null;
    }

    public void inserirFuncionario(Cliente c) throws ClienteException {
        try {
            if (isValid(c)) {
                cliDAO.inserirCliente(c);
            } else {
                throw new ClienteException("DADOS INVALIDOS", null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ClienteException("ERRO NA INCLUSÃO DOS DADOS", e);
        }
    }
}
