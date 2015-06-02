/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigos.bd.models;

import codigos.bd.Banco;
import codigos.bd.beans.Cidades;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class CidadesModel extends Banco {

    public ArrayList<Cidades> getCidades(int estadoId) {
        ArrayList<Cidades> cidades = new ArrayList<>();
        PreparedStatement ps;

        try {
            ps = getConnection().prepareStatement("SELECT * FROM CIDADES WHERE ESTADO_ID = ?");
            ps.setInt(1, estadoId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                cidades.add(new Cidades(rs.getInt("ID"), rs.getInt("ESTADO_ID"), rs.getString("NOME")));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return cidades;
    }

    public Cidades byId(int id) throws SQLException, ClassNotFoundException {
        PreparedStatement ps;
        Cidades cidades = new Cidades(-1);
        ps = getConnection().prepareStatement("SELECT * FROM CIDADES WHERE ID = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            cidades.setId(rs.getInt("ID"));
            cidades.setEstadoId(rs.getInt("ESTADO_ID"));
            cidades.setNome(rs.getString("NOME"));
        }
        
        return cidades;

    }

    public int inserir(Cidades cidade) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = getConnection().prepareStatement("INSERT INTO CIDADES (ESTADO_ID, NOME) "
                + "VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);

        ps.setInt(1, cidade.getEstadoId());
        ps.setString(2, cidade.getNome());

        if (ps.executeUpdate() > 0) {
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return -1;

    }
}
