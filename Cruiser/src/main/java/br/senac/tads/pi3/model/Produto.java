package br.senac.tads.pi3.model;

import java.util.Objects;

/**
 *
 * @author Cruiser
 */
public class Produto {
    private int idProduto;
    private String nome;
    private int quantidade;
    private double preco;
    private String categoria;
    private boolean disponivel;

  

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

      @Override
    public boolean equals(Object obj) {
        if( obj instanceof Produto) {
            Produto p = (Produto) obj;
            if(this.nome.equals(p.nome)) {
                return true;
            }
           
        }
        return false;
    }

    @Override
    public int hashCode() {
        
        return nome.hashCode();
    }
    
    
}
