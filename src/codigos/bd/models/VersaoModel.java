/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigos.bd.models;

import codigos.bd.Banco;
import codigos.bd.beans.Cidades;
import codigos.bd.beans.Versao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

/**
 *
 * @author Lucas
 */
public class VersaoModel extends Banco {

    public Versao byId(int id) throws SQLException, ClassNotFoundException {
        PreparedStatement ps;
        Versao versao = new Versao();
        ps = getConnection().prepareStatement("SELECT * FROM VERSAO WHERE ID = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            versao.setId(rs.getInt("ID"));
            versao.setVersao(rs.getString("VERSAO"));
            versao.setDataVersao(rs.getDate("DATA_VERSAO"));
        }
        
        return versao;

    }

    public Versao byVersao(String nVersao) throws SQLException, ClassNotFoundException {
        PreparedStatement ps;
        Versao versao = new Versao();
        ps = getConnection().prepareStatement("SELECT * FROM VERSAO WHERE VERSAO = ?");
        ps.setString(1, nVersao);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            versao.setId(rs.getInt("ID"));
            versao.setVersao(rs.getString("VERSAO"));
            versao.setDataVersao(rs.getDate("DATA_VERSAO"));
        }
        
        return versao;

    }
    public int inserir(Versao versao) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = getConnection().prepareStatement("INSERT INTO VERSAO (VERSAO, DATA_VERSAO) "
                + "VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);

        ps.setString(1, versao.getVersao());
        ps.setTimestamp(2, new Timestamp(System.currentTimeMillis()));

        if (ps.executeUpdate() > 0) {
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return -1;

    }
}
