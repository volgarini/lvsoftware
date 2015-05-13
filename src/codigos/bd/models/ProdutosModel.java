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

    public int inserir(Produtos produto) throws SQLException {
        System.out.println(produto);
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
        return 0;

    }
    
    public int atualizar(Produtos produto) throws SQLException {
        PreparedStatement ps = getConnection().prepareStatement("UPDATE PRODUTOS SET "
                + "DESCRICAO = ?, CODIGO_BARRAS = ?, VALOR = ?, QUANTIDADE = ?"
                + " WHERE ID = ?");

        ps.setString(1, produto.getDescricao());
        ps.setString(2, produto.getCodigoBarras());
        ps.setInt(3, produto.getQuantidade());
        ps.setFloat(4, produto.getValor());
        ps.setInt(5, produto.getId());
        

        if (ps.executeUpdate() > 0) {
            return produto.getId();
        }
        return 0;

    }

    public Produtos byDescricao(String descricao) throws SQLException {
        PreparedStatement ps = getConnection().prepareStatement("SELECT * FROM PRODUTOS WHERE DESCRICAO = ?");
        ps.setString(1, descricao);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new Produtos(rs.getInt("ID"), rs.getString("DESCRICAO"), rs.getString("CODIGO_BARRAS"), rs.getFloat("VALOR"), rs.getInt("QUANTIDADE"));
        }
        return new Produtos(-1);
    }

    public ArrayList<Produtos> likeDescricao(String descricao) throws SQLException {
        ArrayList<Produtos> produtos = new ArrayList<>();

        PreparedStatement ps = getConnection().prepareStatement("SELECT * FROM PRODUTOS WHERE lower(DESCRICAO) LIKE lower('%" + descricao + "%')");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            produtos.add(new Produtos(rs.getInt("ID"), rs.getString("DESCRICAO"), rs.getString("CODIGO_BARRAS"), rs.getFloat("VALOR"), rs.getInt("QUANTIDADE")));
        }

        return produtos;
    }

    public ArrayList<Produtos> getAll() throws SQLException {
        ArrayList<Produtos> produtos = new ArrayList<>();

        PreparedStatement ps = getConnection().prepareStatement("SELECT * FROM PRODUTOS");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            produtos.add(new Produtos(rs.getInt("ID"), rs.getString("DESCRICAO"), rs.getString("CODIGO_BARRAS"), rs.getFloat("VALOR"), rs.getInt("QUANTIDADE")));
        }

        return produtos;
    }

}
