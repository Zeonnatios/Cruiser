package br.senac.tads.pi3.model;

import java.util.Objects;

/**
 *
 * @author Cruiser
 */
public class Cliente {
    private int idCliente;
    private String nome;
    private String cpf;
    private String email;

    public Cliente() {
     
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
    
    public void editarCliente(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

       @Override
    public boolean equals(Object obj) {
        if( obj instanceof Cliente) {
            Cliente c = (Cliente) obj;
            if(this.cpf.equals(c.cpf)) {
                return true;
            }
           
        }
        return false;
    }

    @Override
    public int hashCode() {
        
        return cpf.hashCode();
    }
}
