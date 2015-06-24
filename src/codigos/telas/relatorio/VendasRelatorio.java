/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigos.telas.relatorio;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class VendasRelatorio implements Serializable {

    private List<String> descricoes;
    private List<String> quantidades;
    private List<String> valores;
    
    private List<VendasProduto> produtos;
    private String nome;
    private String valorTotal;
    private String desconto;
    private String valorFinal;
    private String observacao;
    
    public VendasRelatorio() {
    }

    public List<VendasProduto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<VendasProduto> produtos) {
        this.produtos = produtos;
    }

    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getDesconto() {
        return desconto;
    }

    public void setDesconto(String desconto) {
        this.desconto = desconto;
    }

    public String getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(String valorFinal) {
        this.valorFinal = valorFinal;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public List<String> getDescricoes() {
        return descricoes;
    }

    public void setDescricoes(List<String> descricoes) {
        this.descricoes = descricoes;
    }

    public List<String> getQuantidades() {
        return quantidades;
    }

    public void setQuantidades(List<String> quantidades) {
        this.quantidades = quantidades;
    }

    public List<String> getValores() {
        return valores;
    }

    public void setValores(List<String> valores) {
        this.valores = valores;
    }

    

}
