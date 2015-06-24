/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigos.telas.relatorio;

import java.io.Serializable;

/**
 *
 * @author Lucas
 */
public class VendasProduto implements Serializable {

    private String descricao;
    private String quantidade;
    private String valor;
    
    
    
    public VendasProduto() {
    }

    public VendasProduto(String descricao, String quantidade, String valor) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

  
}
