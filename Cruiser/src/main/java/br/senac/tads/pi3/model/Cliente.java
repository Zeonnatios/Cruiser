package br.senac.tads.pi3.model;

/**
 *
 * @author Sony
 */
public class Cliente {
    private int idCliente;
    private String nome;
    private String cpf;
    private String email;

    public Cliente(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void inserirCliente(){
        //IMPLEMENTAR
    }
    
    public void editarCliente(){
        //IMPLEMENTAR
    }
    
    public void consultarCliente(String cpf){
        //IMPLEMENTAR
    }
}
