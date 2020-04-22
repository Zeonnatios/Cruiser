package br.senac.tads.pi3.model;

/**
 *
 * @author Sony
 */
public class Produto {
    private int idProduto;
    private String nome;
    private int quantidade;
    private double preco;
    private boolean disponivel;

    public Produto(String nome, int quantidade, double preco, boolean disponivel) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.disponivel = disponivel;
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

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    
    public void inserirProduto(){
        //IMPLEMENTAR
    }
    
    public void editarProduto(){
        //IMPLEMENTAR
    }
    
    public void consultarProduto(){
        //IMPLEMENTAR
    }
    
    public void desativarProduto(int idProduto){
        //IMPLEMENTAR
    }
    
    public void ativarProduto(int idProduto){
        //IMPLEMENTAR
    }
}
