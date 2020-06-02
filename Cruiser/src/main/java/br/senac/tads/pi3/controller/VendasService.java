package br.senac.tads.pi3.controller;

import java.sql.SQLException;
import br.senac.tads.pi3.dao.VendasDao;
import br.senac.tads.pi3.exception.VendaException;
import br.senac.tads.pi3.model.Venda;

/**
 *
 * @author CRUISER
 */
public class VendasService {

    private VendasDao vendasDAO = new VendasDao();

    public int consultarEstoque(int id) throws VendaException {
        try {
            return vendasDAO.consultarEstoque(id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new VendaException("ERRO AO CONSULTAR ESTOQUE", e);
        }
    }

    public void inserirVenda(Venda v) throws VendaException {
        try {

            System.out.println("FINALIZANDO COMPRA");
            vendasDAO.inserirItem(v);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new VendaException("ERRO AO FINALIZAR COMPRA", e);
        }
    }

}
