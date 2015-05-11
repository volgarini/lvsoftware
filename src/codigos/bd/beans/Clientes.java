/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigos.bd.beans;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Lucas
 */
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String nome;
    private Date dataNascimento;
    private Character sexo;
    private String nomePai;
    private String cpfPai;
    private String emailPai;
    private String facebookPai;
    private String telResPai;
    private String telCelPai;
    private String nomeMae;
    private String cpfMae;
    private String emailMae;
    private String facebookMae;
    private String telResMae;
    private String telCelMae;

    public Clientes() {
    }

    public Clientes(Integer id, String nome, Date dataNascimento, Character sexo, String nomePai, String cpfPai, String emailPai, String facebookPai, String telResPai, String telCelPai, String nomeMae, String cpfMae, String emailMae, String facebookMae, String telResMae, String telCelMae) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.nomePai = nomePai;
        this.cpfPai = cpfPai;
        this.emailPai = emailPai;
        this.facebookPai = facebookPai;
        this.telResPai = telResPai;
        this.telCelPai = telCelPai;
        this.nomeMae = nomeMae;
        this.cpfMae = cpfMae;
        this.emailMae = emailMae;
        this.facebookMae = facebookMae;
        this.telResMae = telResMae;
        this.telCelMae = telCelMae;
    }

    

    public Clientes(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getCpfPai() {
        return cpfPai;
    }

    public void setCpfPai(String cpfPai) {
        this.cpfPai = cpfPai;
    }

    public String getEmailPai() {
        return emailPai;
    }

    public void setEmailPai(String emailPai) {
        this.emailPai = emailPai;
    }

    public String getFacebookPai() {
        return facebookPai;
    }

    public void setFacebookPai(String facebookPai) {
        this.facebookPai = facebookPai;
    }

    public String getTelResPai() {
        return telResPai;
    }

    public void setTelResPai(String telResPai) {
        this.telResPai = telResPai;
    }

    public String getTelCelPai() {
        return telCelPai;
    }

    public void setTelCelPai(String telCelPai) {
        this.telCelPai = telCelPai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getCpfMae() {
        return cpfMae;
    }

    public void setCpfMae(String cpfMae) {
        this.cpfMae = cpfMae;
    }

    public String getEmailMae() {
        return emailMae;
    }

    public void setEmailMae(String emailMae) {
        this.emailMae = emailMae;
    }

    public String getFacebookMae() {
        return facebookMae;
    }

    public void setFacebookMae(String facebookMae) {
        this.facebookMae = facebookMae;
    }

    public String getTelResMae() {
        return telResMae;
    }

    public void setTelResMae(String telResMae) {
        this.telResMae = telResMae;
    }

    public String getTelCelMae() {
        return telCelMae;
    }

    public void setTelCelMae(String telCelMae) {
        this.telCelMae = telCelMae;
    }

    @Override
    public String toString() {
        return "Clientes{" + "id=" + id + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", sexo=" + sexo + ", nomePai=" + nomePai + ", cpfPai=" + cpfPai + ", emailPai=" + emailPai + ", facebookPai=" + facebookPai + ", telResPai=" + telResPai + ", telCelPai=" + telCelPai + ", nomeMae=" + nomeMae + ", cpfMae=" + cpfMae + ", emailMae=" + emailMae + ", facebookMae=" + facebookMae + ", telResMae=" + telResMae + ", telCelMae=" + telCelMae + '}';
    }

}
