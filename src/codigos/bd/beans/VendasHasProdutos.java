/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigos.bd.beans;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author Lucas
 */
public class VendasHasProdutos implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer produtoId;
    private Integer vendaId;
    private float valor;
    private Integer quantidade;
    
    public VendasHasProdutos() {
    }

    public VendasHasProdutos(Integer id) {
        this.id = id;
    }

    public VendasHasProdutos(Integer id, Integer produtoId, Integer vendaId, float valor, Integer quantidade) {
        this.id = id;
        this.produtoId = produtoId;
        this.vendaId = vendaId;
        this.valor = valor;
        this.quantidade = quantidade;
    }





    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Integer produtoId) {
        this.produtoId = produtoId;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Integer getVendaId() {
        return vendaId;
    }

    public void setVendaId(Integer vendaId) {
        this.vendaId = vendaId;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

}
