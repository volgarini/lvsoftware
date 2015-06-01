/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigos.bd.models;

import codigos.bd.Banco;
import codigos.bd.beans.Estados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class EstadosModel extends Banco {

    public ArrayList<Estados> getEstados() {
        ArrayList<Estados> estados = new ArrayList<>();
        PreparedStatement ps;

        try {
            ps = getConnection().prepareStatement("SELECT * FROM ESTADOS");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                estados.add(new Estados(rs.getInt("ID"), rs.getString("NOME"), rs.getString("SIGLA")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return estados;
    }

    public int inserir(Estados estado) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = getConnection().prepareStatement("INSERT INTO ESTADOS (NOME, SIGLA) "
                + "VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);

        ps.setString(1, estado.getNome());
        ps.setString(2, estado.getSigla());

        if (ps.executeUpdate() > 0) {
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return -1;

    }
}
