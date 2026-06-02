// Glória a Deus nos mais altos céus e Paz no mundo aos homens por Ele amados!
package org.example.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descricao;
    private String dataVenda;
    private String nomeProduto;
    private double valorProduto;
    private int qtd;
    private double valorTotalVenda;

    private int funcionarioId;
    private String funcionarioNome;
    private String funcionarioTelefone;
    private String funcionarioEmail;
    private String funcionarioEndereco;
    private String funcionarioCidade;
    private double funcionarioSalario;
    private String funcionarioDataNasc;
    private String funcionarioDataCadas;

    public int getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(int funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public String getFuncionarioNome() {
        return funcionarioNome;
    }

    public void setFuncionarioNome(String funcionarioNome) {
        this.funcionarioNome = funcionarioNome;
    }

    public String getFuncionarioTelefone() {
        return funcionarioTelefone;
    }

    public void setFuncionarioTelefone(String funcionarioTelefone) {
        this.funcionarioTelefone = funcionarioTelefone;
    }

    public String getFuncionarioEmail() {
        return funcionarioEmail;
    }

    public void setFuncionarioEmail(String funcionarioEmail) {
        this.funcionarioEmail = funcionarioEmail;
    }

    public String getFuncionarioEndereco() {
        return funcionarioEndereco;
    }

    public void setFuncionarioEndereco(String funcionarioEndereco) {
        this.funcionarioEndereco = funcionarioEndereco;
    }

    public String getFuncionarioCidade() {
        return funcionarioCidade;
    }

    public void setFuncionarioCidade(String funcionarioCidade) {
        this.funcionarioCidade = funcionarioCidade;
    }

    public double getFuncionarioSalario() {
        return funcionarioSalario;
    }

    public void setFuncionarioSalario(double funcionarioSalario) {
        this.funcionarioSalario = funcionarioSalario;
    }

    public String getFuncionarioDataNasc() {
        return funcionarioDataNasc;
    }

    public void setFuncionarioDataNasc(String funcionarioDataNasc) {
        this.funcionarioDataNasc = funcionarioDataNasc;
    }

    public String getFuncionarioDataCadas() {
        return funcionarioDataCadas;
    }

    public void setFuncionarioDataCadas(String funcionarioDataCadas) {
        this.funcionarioDataCadas = funcionarioDataCadas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getValorTotalVenda() {
        return this.qtd * this.valorProduto;
    }

    public void setValorTotalVenda(double valorTotalVenda) {
        this.valorTotalVenda = valorTotalVenda;
    }

    public Venda(int id, String descricao, String dataVenda, String nomeProduto, double valorProduto, int qtd, double valorTotalVenda) {
        this.id = id;
        this.descricao = descricao;
        this.dataVenda = dataVenda;
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
        this.qtd = qtd;
        this.valorTotalVenda = valorTotalVenda;
    }
    public Venda() {
    }
}
