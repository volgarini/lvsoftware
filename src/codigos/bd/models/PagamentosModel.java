/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigos.bd.models;

import codigos.bd.Banco;
import codigos.bd.beans.Pagamentos;
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
public class PagamentosModel extends Banco {

    public PagamentosModel() {
    }

    public int inserir(Pagamentos pagamento) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = getConnection().prepareStatement("INSERT INTO PAGAMENTOS "
                + "(DESCRICAO, DATA_CADASTRO)"
                + " VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);

        ps.setString(1, pagamento.getDescricao());
        ps.setDate(2, new Date(System.currentTimeMillis()));
        

        if (ps.executeUpdate() > 0) {
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return -1;

    }

    public int atualizar(Pagamentos pagamentos) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = getConnection().prepareStatement("UPDATE PAGAMENTOS SET "
                + "DESCRICAO = ? WHERE ID = ?");

        ps.setString(1, pagamentos.getDescricao());
        ps.setInt(2, pagamentos.getId());
        
        if (ps.executeUpdate() > 0) {
            return pagamentos.getId();
        }
        return -1;

    }

    public int desativar(Pagamentos pagamentos) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = getConnection().prepareStatement("UPDATE PAGAMENTOS SET "
                + "DATA_EXCLUSAO = ? WHERE ID = ?");

        ps.setDate(1, new Date(System.currentTimeMillis()));
        ps.setInt(2, pagamentos.getId());

        if (ps.executeUpdate() > 0) {
            return pagamentos.getId();
        }
        return -1;
    }

    public Pagamentos byDescricao(String descricao) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = getConnection().prepareStatement("SELECT * FROM PAGAMENTOS WHERE DESCRICAO = ? AND DATA_EXCLUSAO IS NULL");
        ps.setString(1, descricao);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new Pagamentos(rs.getInt("ID"), rs.getString("DESCRICAO"));
        }
        return new Pagamentos(-1);
    }

    public ArrayList<Pagamentos> likeDescricao(String descricao) throws SQLException, ClassNotFoundException {
        ArrayList<Pagamentos> pagamentos = new ArrayList<>();

        PreparedStatement ps = getConnection().prepareStatement("SELECT * FROM PAGAMENTOS WHERE lower(DESCRICAO) LIKE lower('%" + descricao + "%') AND DATA_EXCLUSAO IS NULL");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            pagamentos.add(new Pagamentos(rs.getInt("ID"), rs.getString("DESCRICAO")));
        }

        return pagamentos;
    }

    public ArrayList<Pagamentos> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Pagamentos> pagamentos = new ArrayList<>();

        PreparedStatement ps = getConnection().prepareStatement("SELECT * FROM PAGAMENTOS WHERE DATA_EXCLUSAO IS NULL ORDER BY DESCRICAO");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            pagamentos.add(new Pagamentos(rs.getInt("ID"), rs.getString("DESCRICAO")));
        }

        return pagamentos;
    }

}
