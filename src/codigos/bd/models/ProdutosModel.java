/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigos.bd.models;

import codigos.bd.Banco;
import codigos.bd.beans.Produtos;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class ProdutosModel extends Banco {

    public ProdutosModel() {
    }

    public int inserir(Produtos produto) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = getConnection().prepareStatement("INSERT INTO PRODUTOS "
                + "(DESCRICAO, CODIGO_BARRAS, VALOR, QUANTIDADE, DATA_CADASTRO)"
                + " VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

        ps.setString(1, produto.getDescricao());
        ps.setString(2, produto.getCodigoBarras());
        ps.setFloat(3, produto.getValor());
        ps.setInt(4, produto.getQuantidade());
        ps.setDate(5, new Date(System.currentTimeMillis()));

        if (ps.executeUpdate() > 0) {
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return -1;

    }

    public int atualizar(Produtos produto) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = getConnection().prepareStatement("UPDATE PRODUTOS SET "
                + "DESCRICAO = ?, CODIGO_BARRAS = ?, VALOR = ?, QUANTIDADE = ?"
                + " WHERE ID = ?");

        ps.setString(1, produto.getDescricao());
        ps.setString(2, produto.getCodigoBarras());
        ps.setFloat(3, produto.getValor());
        ps.setInt(4, produto.getQuantidade());
        ps.setInt(5, produto.getId());

        if (ps.executeUpdate() > 0) {
            return produto.getId();
        }
        return -1;

    }

    public int desativar(Produtos produto) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = getConnection().prepareStatement("UPDATE PRODUTOS SET "
                + "DATA_EXCLUSAO = ? WHERE ID = ?");

        ps.setDate(1, new Date(System.currentTimeMillis()));
        ps.setInt(2, produto.getId());

        if (ps.executeUpdate() > 0) {
            return produto.getId();
        }
        return -1;
    }

    public Produtos byDescricao(String descricao) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = getConnection().prepareStatement("SELECT * FROM PRODUTOS WHERE DESCRICAO = ? AND DATA_EXCLUSAO IS NULL");
        ps.setString(1, descricao);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new Produtos(rs.getInt("ID"), rs.getString("DESCRICAO"), rs.getString("CODIGO_BARRAS"), rs.getFloat("VALOR"), rs.getInt("QUANTIDADE"));
        }
        return new Produtos(-1);
    }

    public ArrayList<Produtos> likeDescricao(String descricao) throws SQLException, ClassNotFoundException {
        ArrayList<Produtos> produtos = new ArrayList<>();

        PreparedStatement ps = getConnection().prepareStatement("SELECT * FROM PRODUTOS WHERE lower(DESCRICAO) LIKE lower('%" + descricao + "%') AND DATA_EXCLUSAO IS NULL");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            produtos.add(new Produtos(rs.getInt("ID"), rs.getString("DESCRICAO"), rs.getString("CODIGO_BARRAS"), rs.getFloat("VALOR"), rs.getInt("QUANTIDADE")));
        }

        return produtos;
    }

    public ArrayList<Produtos> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Produtos> produtos = new ArrayList<>();

        PreparedStatement ps = getConnection().prepareStatement("SELECT * FROM PRODUTOS WHERE DATA_EXCLUSAO IS NULL ORDER BY DESCRICAO");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            produtos.add(new Produtos(rs.getInt("ID"), rs.getString("DESCRICAO"), rs.getString("CODIGO_BARRAS"), rs.getFloat("VALOR"), rs.getInt("QUANTIDADE")));
        }

        return produtos;
    }

}
