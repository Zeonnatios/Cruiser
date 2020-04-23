package br.senac.tads.pi3.model;

/**
 *
 * @author Sony
 */
public class Funcionario {
    private int idFuncionario;
    private String nome;
    private String email;
    private String senha;
    private String cidade;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
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
    
    public void editarFuncionario(String nome, String email, String senha, String cidade, String departamento, String status){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cidade = cidade;
        this.departamento = departamento;
        this.status = status;
    }
}
