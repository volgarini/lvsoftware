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
public class Pagamentos implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String descricao;

    public Pagamentos() {
    }

    public Pagamentos(Integer id) {
        this.id = id;
    }

    public Pagamentos(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
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

    @Override
    public String toString() {
        return getDescricao();
    }
}
