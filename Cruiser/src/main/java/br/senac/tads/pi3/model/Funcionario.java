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
    private String status;

    public Funcionario() {
        
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
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
    
    public void ativarInativarFuncionario(int idFuncionario){
        //IMPLEMENTAR
        //NAO É MELHOR SO USAR O GET E SET STATUS?
    }
    
    public boolean verificarLogin(){
        //IMPLEMENTAR
        return true;
    }
}
