package br.senac.tads.pi3.model;

import java.time.LocalDate;

/**
 *
 * @author Cruiser
 */
public class Relatorios {

    private int idVenda;
    private int idLoja;
    private Produto produto;
    private double valorTotalProdutoUnitario;
    private LocalDate dataVenda;
    private Filial filial;
    private double totalDiario;
    private int qtdeTotalDiario;

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getValorTotalProdutoUnitario() {
        return valorTotalProdutoUnitario;
    }

    public void setValorTotalProdutoUnitario(double valorTotalProdutoUnitario) {
        this.valorTotalProdutoUnitario = valorTotalProdutoUnitario;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Filial getFilial() {
        return filial;
    }

    public void setFilial(Filial filial) {
        this.filial = filial;
    }

    public double getTotalDiario() {
        return totalDiario;
    }

    public void setTotalDiario(double totalDiario) {
        this.totalDiario = totalDiario;
    }

    public int getQtdeTotalDiario() {
        return qtdeTotalDiario;
    }

    public void setQtdeTotalDiario(int qtdeTotalDiario) {
        this.qtdeTotalDiario = qtdeTotalDiario;
    }

}
