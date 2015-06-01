/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigos.bd.models;

import codigos.bd.Banco;
import codigos.bd.beans.Enderecos;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

/**
 *
 * @author Lucas
 */
public class EnderecosModel extends Banco {

    public EnderecosModel() {
    }

    public int inserir(Enderecos endereco) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = getConnection().prepareStatement("INSERT INTO ENDERECOS (CLIENTE_ID, CIDADE_ID, "
                + "LOGRADOURO, COMPLEMENTO, BAIRRO, CEP, DATA_CADASTRO, ESTADO_ID)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

        ps.setInt(1, endereco.getClienteId());
        ps.setInt(2, endereco.getCidadeId());
        ps.setString(3, endereco.getLogradouro());
        ps.setString(4, endereco.getComplemento());
        ps.setString(5, endereco.getBairro());
        ps.setString(6, endereco.getCep());
        ps.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
        ps.setInt(8, endereco.getEstadoId());

        if (ps.executeUpdate() > 0) {
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return 0;

    }
    
    public int atualizar(Enderecos endereco) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = getConnection().prepareStatement("UPDATE ENDERECOS SET CIDADE_ID = ?, "
                + "LOGRADOURO = ?, COMPLEMENTO = ?, BAIRRO = ?, CEP = ?, ESTADO_ID = ?"
                + " WHERE ID = ?");

        ps.setInt(1, endereco.getCidadeId());
        ps.setString(2, endereco.getLogradouro());
        ps.setString(3, endereco.getComplemento());
        ps.setString(4, endereco.getBairro());
        ps.setString(5, endereco.getCep());
        ps.setInt(6, endereco.getEstadoId());
        ps.setInt(7, endereco.getId());

        if (ps.executeUpdate() > 0) {
            return endereco.getId();
        }
        return 0;

    }
    
    public Enderecos byClienteId(int clienteId) throws SQLException, ClassNotFoundException{
        PreparedStatement ps = getConnection().prepareStatement("SELECT * FROM ENDERECOS WHERE CLIENTE_ID = ?");
        ps.setInt(1, clienteId);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            return new Enderecos(rs.getInt("ID"), rs.getInt("CLIENTE_ID"), rs.getInt("CIDADE_ID"), rs.getString("LOGRADOURO"), rs.getString("COMPLEMENTO"), rs.getString("BAIRRO"), rs.getString("CEP"), rs.getInt("ESTADO_ID"));
        }
        
        return new Enderecos(-1);
    }

}
