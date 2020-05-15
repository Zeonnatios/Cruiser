package br.senac.tads.pi3.dao;

import br.senac.tads.pi3.model.Venda;
import java.util.ArrayList;

/**
 *
 * @author lukas
 */
public class VendasDao {

    public static ArrayList<Venda> listaVendas = new ArrayList<Venda>();

    public static void addVendas(Venda venda) {

        listaVendas.add(venda);
        for (int i = 0; i < listaVendas.size(); i++) {
            Venda get = listaVendas.get(i);
        }
    }
}
