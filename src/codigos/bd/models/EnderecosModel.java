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
import java.sql.Types;

/**
 *
 * @author Lucas
 */
public class EnderecosModel extends Banco {

    public EnderecosModel() {
    }

    public int inserir(Enderecos endereco) throws SQLException {
        PreparedStatement ps = getConnection().prepareStatement("INSERT INTO ENDERECOS (CLIENTE_ID, CIDADE_ID, "
                + "LOGRADOURO, COMPLEMENTO, BAIRRO, CEP, DATA_CADASTRO)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

        ps.setInt(1, endereco.getClienteId());
        ps.setInt(2, endereco.getCidadeId());
        ps.setString(3, endereco.getLogradouro());
        ps.setString(4, endereco.getComplemento());
        ps.setString(5, endereco.getBairro());
        ps.setString(6, endereco.getCep());
        ps.setDate(7, new Date(System.currentTimeMillis()));

        if (ps.executeUpdate() > 0) {
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return 0;

    }

}
