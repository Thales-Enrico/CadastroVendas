// Glória a Deus nos mais altos céus e Paz no mundo aos homens por Ele amados!
package org.example.dto;

public class VendaRequestDTO {

    private String descricao;
    private String dataVenda;
    private String nomeProduto;
    private double valorProduto;
    private int qtd;

    private int funcionarioId;

    public VendaRequestDTO() {
    }

    public VendaRequestDTO(String descricao, String dataVenda,
                           String nomeProduto, double valorProduto,
                           int qtd, int funcionarioId) {
        this.descricao = descricao;
        this.dataVenda = dataVenda;
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
        this.qtd = qtd;
        this.funcionarioId = funcionarioId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public int getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(int funcionarioId) {
        this.funcionarioId = funcionarioId;
    }
}