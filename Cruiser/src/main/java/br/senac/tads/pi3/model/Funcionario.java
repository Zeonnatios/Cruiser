package br.senac.tads.pi3.model;

/**
 *
 * @author Sony
 */
public class Funcionario {
    private int idFuncionario;
    private int idFilial;
    private String nome;
    private String email;
    private String senha;
    private String departamento;

    public Funcionario(int idFilial, String nome, String email, String senha, String departamento) {
        this.idFilial = idFilial;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.departamento = departamento;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
    public void inserirFuncionario(){
        //IMPLEMENTAR
    }
    
    public void editarFuncionario(){
        //IMPLEMENTAR
    }
    
    public void consultarFuncionario(){
        //IMPLEMENTAR
    }
    
    public void ativarFuncionario(int idFuncionario){
        //IMPLEMENTAR
    }
    
    public void inativarFuncionario(int idFuncionario){
        //IMPLEMENTAR
    }
    
    public boolean verificarLogin(){
        //IMPLEMENTAR
        return true;
    }
}
