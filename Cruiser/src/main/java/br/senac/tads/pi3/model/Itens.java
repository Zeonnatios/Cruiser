package br.senac.tads.pi3.model;

/**
 *
 * @author Sony
 */
public class Itens {
    private int idVenda;
    private int idProduto;
    private int quantidade;
    private double precoUnitario;

    public Itens(int idVenda, int idProduto, int quantidade, double precoUnitario) {
        this.idVenda = idVenda;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
    
   public void gerarVenda(){
        //IMPLEMENTAR
    }
   
   public void consultarVenda(){
        //IMPLEMENTAR
    }
   
   public void alterarEstoque(){
        //QUAL A FINALIDADE DESSA CLASSE?????? O ESTOQUE
        // JÁ FOI ALTERADO NA CLASSE VENDA
    }
}
