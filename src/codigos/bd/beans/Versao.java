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

public class Versao implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String versao;
    private Date dataVersao;

    public Versao() {
    }

    public Versao(Integer id) {
        this.id = id;
    }

    public Versao(Integer id, String versao, Date dataVersao) {
        this.id = id;
        this.versao = versao;
        this.dataVersao = dataVersao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public Date getDataVersao() {
        return dataVersao;
    }

    public void setDataVersao(Date dataVersao) {
        this.dataVersao = dataVersao;
    }

    @Override
    public String toString() {
        return "Versao{" + "id=" + id + ", versao=" + versao + ", dataVersao=" + dataVersao + '}';
    }

   
}
