/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigos.bd.beans;

import java.io.Serializable;

/**
 *
 * @author Lucas
 */
public class Produtos implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String descricao;
    private String codigoBarras;
    private float valor;
    private Integer quantidade;

    public Produtos() {
    }

    public Produtos(Integer id) {
        this.id = id;
    }

    public Produtos(Integer id, String descricao, String codigoBarras, float valor, Integer quantidade) {
        this.id = id;
        this.descricao = descricao;
        this.codigoBarras = codigoBarras;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return getDescricao();
        //return getDescricao() + " - R$ " + String.format("%.2f", getValor());
        //return "Produtos{" + "id=" + id + ", descricao=" + descricao + ", codigoBarras=" + codigoBarras + ", valor=" + valor + ", quantidade=" + quantidade + '}';
    }

}
