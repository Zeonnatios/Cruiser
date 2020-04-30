package br.senac.tads.pi3.exception;

import java.sql.SQLException;
import br.senac.tads.pi3.dao.ClienteDao;
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
            System.out.println("TESTE LISTAGEM");
            return cliDAO.listarCliente();
        } catch (SQLException e) {
            throw new ClienteException("ERRO NA CONSULTA DOS DADOS", e);
        }
    }
}
