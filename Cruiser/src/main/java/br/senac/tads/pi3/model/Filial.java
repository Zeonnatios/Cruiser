package br.senac.tads.pi3.model;

/**
 *
 * @author Cruiser
 */
public class Filial {

    private int idFilial;
    private String cidade;
    private String telefone;
    private String tipo; 

    public Filial() {

    }

    public int getIdFilial() {
        return idFilial;
    }

    public void setIdFilial(int idFilial) {
        this.idFilial = idFilial;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void editarFilial(String cidade, String telefone, String tipo) {
        this.cidade = cidade;
        this.telefone = telefone;
        this.tipo = tipo;
    }
}
