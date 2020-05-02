package br.senac.tads.pi3.controller;

import java.util.List;
import java.sql.SQLException;
import br.senac.tads.pi3.dao.FilialDao;
import br.senac.tads.pi3.exception.FiliaisException;
import br.senac.tads.pi3.model.Filial;

/**
 *
 * @author Cruiser
 */
public class FilialService extends SQLException {

    private FilialDao filialDAO = new FilialDao();

    public List<Filial> listarFilial() throws FiliaisException {
        try {
            System.out.println("LSITAGEM DE FILIAIS");
            return filialDAO.listarFilial();
        } catch (SQLException e) {
            throw new FiliaisException("ERRO NA LSITAGEM DE FILIAIS", e);
        }
    }

    private boolean isValid(Filial f) {
        return f != null && f.getCidade() != null && f.getTelefone() != null && f.getTipo() != null;
    }

    public void inserirFilial(Filial f) throws FiliaisException {
        try {
            if (isValid(f)) {
                filialDAO.inserirFilial(f);
            } else {
                throw new FiliaisException("DADOS INVALIDOS", null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new FiliaisException("ERRO NA INCLUSÃO DOS DADOS", e);
        }
    }

}
