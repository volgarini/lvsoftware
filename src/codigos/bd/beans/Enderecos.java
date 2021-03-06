/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigos.bd.beans;

import java.io.Serializable;
import javax.persistence.Column;

/**
 *
 * @author Lucas
 */
public class Enderecos implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer clienteId;
    private Integer cidadeId;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String cep;
    private Integer estadoId;
    public Enderecos() {
    }

    public Enderecos(Integer id) {
        this.id = id;
    }

    public Enderecos(Integer id, Integer clienteId, Integer cidadeId, String logradouro, String complemento, String bairro, String cep, Integer estadoId) {
        this.id = id;
        this.clienteId = clienteId;
        this.cidadeId = cidadeId;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.estadoId = estadoId;
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

    public Integer getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(Integer cidadeId) {
        this.cidadeId = cidadeId;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Integer estadoId) {
        this.estadoId = estadoId;
    }

    @Override
    public String toString() {
        return "Enderecos{" + "id=" + id + ", clienteId=" + clienteId + ", cidadeId=" + cidadeId + ", logradouro=" + logradouro + ", complemento=" + complemento + ", bairro=" + bairro + ", cep=" + cep + ", estadoId=" + estadoId + '}';
    }


}
