/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigos.telas.relatorio;

import codigos.bd.beans.Clientes;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Lucas
 */
public class ClientesRelatorio extends Clientes implements Serializable {

    private static final long serialVersionUID = 1L;

    private String endereco;
    private String complemento;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;

    public ClientesRelatorio() {
    }

    public ClientesRelatorio(String endereco, String complemento, String bairro, String cep, String cidade, String uf, Integer id, String nome, Date dataNascimento, Character sexo, String nomePai, String cpfPai, String emailPai, String facebookPai, String telResPai, String telCelPai, String nomeMae, String cpfMae, String emailMae, String facebookMae, String telResMae, String telCelMae, Timestamp dataCadastro) {
        super(id, nome, dataNascimento, sexo, nomePai, cpfPai, emailPai, facebookPai, telResPai, telCelPai, nomeMae, cpfMae, emailMae, facebookMae, telResMae, telCelMae, dataCadastro);
        this.endereco = endereco;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "ClientesRelatorio{" + "endereco=" + endereco + ", complemento=" + complemento + ", bairro=" + bairro + ", cep=" + cep + ", cidade=" + cidade + ", uf=" + uf + '}';
    }

    
}
