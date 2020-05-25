package br.senac.tads.pi3.controller;

import java.sql.SQLException;
import br.senac.tads.pi3.exception.HomeException;
import br.senac.tads.pi3.dao.HomeDao;

/**
 *
 * @author CRUISER
 */
public class HomeService {

    private HomeDao homeDAO = new HomeDao();

    public int registrosClientes() throws HomeException {
        try {
            System.out.println("NÚMERO DE REGISTROS DE CLIENTES NO BANCO");
            return homeDAO.numeroRegistroClientes();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new HomeException("ERRO AO SELECIONAR NÚMERO DE REGISTROS DE CLIENTES", e);
        }
    }

    public int registrosFuncionariosAtivos() throws HomeException {
        try {
            System.out.println("NÚMERO DE REGISTROS DE FUNCIONÁRIOS ATIVOS NO BANCO");
            return homeDAO.numeroRegistroFucnionariosAtivos();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new HomeException("ERRO AO SELECIONAR NÚMERO DE REGISTROS DE FUNCIONARIOS ATIVOS", e);
        }
    }

    public int registrosFuncionariosTotal() throws HomeException {
        try {
            System.out.println("NÚMERO DE REGISTROS DE FUNCIONÁRIOS NO BANCO");
            return homeDAO.numeroRegistroFucnionariosTotal();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new HomeException("ERRO AO SELECIONAR NÚMERO DE REGISTROS DE FUNCIONARIOS", e);
        }
    }

    public int totalEstoque() throws HomeException {
        try {
            System.out.println("NÚMERO DE ITENS EM ESTOQUE");
            return homeDAO.numeroProdutoEstoque();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new HomeException("ERRO AO CONSULTAR TOTAIS DE PRODUTOS EM ESTOQUE", e);
        }
    }

    public int registroProdutoTotal() throws HomeException {
        try {
            System.out.println("NÚMERO DE REGISTRO DE PRODUTOS");
            return homeDAO.numeroRegistroProdutos();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new HomeException("ERRO AO SELECIONAR NÚMERO DE REGISTROS DE PRODUTOS", e);
        }
    }

}
