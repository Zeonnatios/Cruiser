package br.senac.tads.pi3.model;

/**
 *
 * @author Sony
 */
public class Filial {
    private int idFilial;
    private String nome;
    private String cidade;
    private String telefone;
    private String estado;
    private String tipo;

    public Filial(String nome, String cidade, String telefone, String estado, String tipo) {
        this.nome = nome;
        this.cidade = cidade;
        this.telefone = telefone;
        this.estado = estado;
        this.tipo = tipo;
    }

    public int getIdFilial() {
        return idFilial;
    }

    public void setIdFilial(int idFilial) {
        this.idFilial = idFilial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public void inserirFilial(){
        //IMPLEMENTAR
    }
    
    public void editarFilial(){
        //IMPLEMENTAR
    }
    
    public void consultarFilial(){
        //IMPLEMENTAR
    }
}
