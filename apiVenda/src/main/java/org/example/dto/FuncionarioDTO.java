// Glória a Deus nos mais altos céus e Paz no mundo aos homens por Ele amados!
package org.example.dto;

public class FuncionarioDTO {

    private int id;
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private String cidade;
    private double salario;
    private String dataNasc;
    private String dataCadas;

    public FuncionarioDTO() {
    }

    public FuncionarioDTO(int id, String nome, String telefone, String email,
                          String endereco, String cidade, double salario,
                          String dataNasc, String dataCadas) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.cidade = cidade;
        this.salario = salario;
        this.dataNasc = dataNasc;
        this.dataCadas = dataCadas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }


    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }


    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }


    public String getDataCadas() {
        return dataCadas;
    }

    public void setDataCadas(String dataCadas) {
        this.dataCadas = dataCadas;
    }
}