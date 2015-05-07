/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigos.bd.models;

import codigos.bd.Banco;
import codigos.bd.beans.Clientes;
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
public class ClientesModel extends Banco {

    public ClientesModel() {
    }

    public int inserir(Clientes cliente) throws SQLException {
        PreparedStatement ps = getConnection().prepareStatement("INSERT INTO CLIENTES (NOME, DATA_NASCIMENTO, SEXO, "
                + "NOME_PAI, CPF_PAI, EMAIL_PAI, FACEBOOK_PAI, TEL_RES_PAI, TEL_CEL_PAI, NOME_MAE, CPF_MAE, EMAIL_MAE, "
                + "FACEBOOK_MAE, TEL_RES_MAE, TEL_CEL_MAE, DATA_CADASTRO)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

        ps.setString(1, cliente.getNome());
        ps.setDate(2, cliente.getDataNascimento());
        ps.setString(3, String.valueOf(cliente.getSexo()));
        ps.setString(4, cliente.getNomePai());
        ps.setString(5, cliente.getCpfPai());
        ps.setString(6, cliente.getEmailPai());
        ps.setString(7, cliente.getFacebookPai());
        ps.setString(8, cliente.getTelResPai());
        ps.setString(9, cliente.getTelCelPai());
        ps.setString(10, cliente.getNomeMae());
        ps.setString(11, cliente.getCpfMae());
        ps.setString(12, cliente.getEmailMae());
        ps.setString(13, cliente.getFacebookMae());
        ps.setString(14, cliente.getTelResMae());
        ps.setString(15, cliente.getTelCelMae());
        ps.setDate(16, new Date(System.currentTimeMillis()));

        if (ps.executeUpdate() > 0) {
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return 0;

    }

}
