package br.senac.tads.pi3.model;

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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    private boolean disponivel;

    public Produto() {
     
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
    
    
    public void desativarProduto(int idProduto){
        //IMPLEMENTAR
    }
    
    public void ativarProduto(int idProduto){
        //IMPLEMENTAR
    }
    
    public void editarProduto(String nome, int quantidade, double preco, boolean disponivel) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.disponivel = disponivel;
    }
}
