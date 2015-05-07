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
            fechar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return estados;
    }
}
