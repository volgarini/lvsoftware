/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigos.bd.beans;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Lucas
 */
public class Vendas implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer clienteId;
    private Integer pagamentoId;
    private Date dataCadastro;
    private float valorTotal;
    private float desconto;
    private float valorFinal;
    private String cliente;
    private String observacao;
    
    public Vendas() {
    }

    public Vendas(Integer id) {
        this.id = id;
    }

    public Vendas(Integer id, Integer clienteId, Integer pagamentoId, Date dataCadastro, float valorTotal, float desconto, float valorFinal, String cliente, String observacao) {
        this.id = id;
        this.clienteId = clienteId;
        this.pagamentoId = pagamentoId;
        this.dataCadastro = dataCadastro;
        this.valorTotal = valorTotal;
        this.desconto = desconto;
        this.valorFinal = valorFinal;
        this.cliente = cliente;
        this.observacao = observacao;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public Integer getPagamentoId() {
        return pagamentoId;
    }

    public void setPagamentoId(Integer pagamentoId) {
        this.pagamentoId = pagamentoId;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public float getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(float valorFinal) {
        this.valorFinal = valorFinal;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public String toString() {
        return "Vendas{" + "id=" + id + ", clienteId=" + clienteId + ", pagamentoId=" + pagamentoId + ", dataCadastro=" + dataCadastro + ", valorTotal=" + valorTotal + ", desconto=" + desconto + ", valorFinal=" + valorFinal + ", cliente=" + cliente + ", observacao=" + observacao + '}';
    }

    
}
