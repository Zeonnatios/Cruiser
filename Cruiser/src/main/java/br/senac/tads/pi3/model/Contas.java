
package br.senac.tads.pi3.model;

public class Contas {
    private Integer id_usuario;
    private String nomeUsuario;
    private String senhaUsuario;
    private String permissaoUsuario;

    public Contas( String nomeUsuario, String senhaUsuario,String permissaoUsuario) {
        
        this.nomeUsuario = nomeUsuario;
        this.permissaoUsuario = permissaoUsuario;
        this.senhaUsuario = senhaUsuario;
    }

    public Contas() {
      
    }

    public String getPermissaoUsuario() {
        return permissaoUsuario;
    }

    public void setPermissaoUsuario(String permissaoUsuario) {
        this.permissaoUsuario = permissaoUsuario;
    }
    
    

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

}
