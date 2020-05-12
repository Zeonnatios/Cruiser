package br.senac.tads.pi3.controller;

import java.util.List;
import java.sql.SQLException;
import br.senac.tads.pi3.dao.ProdutoDao;
import br.senac.tads.pi3.exception.ProdutoException;
import br.senac.tads.pi3.model.Produto;

/**
 *
 * @author Cruiser
 */
public class ProdutoService extends SQLException {

    private ProdutoDao produtoDAO = new ProdutoDao();

    public List<Produto> listarProduto() throws ProdutoException {
        try {
            System.out.println("LSITAGEM DE FILIAIS");
            return produtoDAO.listarProduto();
        } catch (SQLException e) {
            throw new ProdutoException("ERRO NA LSITAGEM DE FILIAIS", e);
        }
    }

    private boolean isValid(Produto p) {
        return p != null && p.getNome() != null && p.getPreco() != 0;
    }

    public void inserirProduto(Produto p) throws ProdutoException {
        try {
            if (isValid(p)) {
                produtoDAO.inserirProduto(p);
            } else {
                throw new ProdutoException("DADOS INVALIDOS", null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ProdutoException("ERRO NA INCLUSÃO DOS DADOS", e);
        }
    }
    
    public Produto select(int id) throws ProdutoException {

        try {
            System.out.println("PESQUISANDO PRODUTO PELO ID");
            return produtoDAO.select(id);
        } catch (SQLException e) {
            throw new ProdutoException("ERRO AO PESQUISAR DADOS DO PRODUTO", e);
        }

    }
    
    public void editarProduto(Produto p) throws ProdutoException {
        try {
            if (isValid(p)) {
                System.out.println("ALTERANDO DADOS DE UM PRODUTO");
                produtoDAO.editarProduto(p);
            } else {
                throw new ProdutoException("DADOS INVALIDOS", null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ProdutoException("ERRO NA ATUALIZAÇÃO DOS DADOS", e);
        }
    }
}
