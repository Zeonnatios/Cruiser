package br.senac.tads.pi3.model;

import java.util.Date;

/**
 *
 * @author Sony
 */
public class Venda {
    private int idVenda;
    private int idFuncionario;
    private Date dataVenda;
    private String idCliente;
    private double valorTotal;

    public Venda(int idFuncionario, Date dataVenda, String idCliente, double valorTotal) {
        this.idFuncionario = idFuncionario;
        this.dataVenda = dataVenda;
        this.idCliente = idCliente;
        this.valorTotal = valorTotal;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    public void gerarVenda(){
        //IMPLEMENTAR
    }
    
    public void consultarVenda(){
        //IMPLEMENTAR
    }
    
    public void alterarEstoque(){
        //IMPLEMENTAR
    }
}
