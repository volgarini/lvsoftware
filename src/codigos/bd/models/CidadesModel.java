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
            
            fechar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return cidades;
    }
}
