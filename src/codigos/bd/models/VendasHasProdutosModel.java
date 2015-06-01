/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigos.bd.models;

import codigos.bd.Banco;
import codigos.bd.beans.VendasHasProdutos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Lucas
 */
public class VendasHasProdutosModel extends Banco {

    public VendasHasProdutosModel() {
    }

    public int inserir(VendasHasProdutos vendas) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = getConnection().prepareStatement("INSERT INTO VENDAS_HAS_PRODUTOS "
                + "(PRODUTO_ID, VENDA_ID, VALOR)"
                + " VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

        ps.setInt(1, vendas.getProdutoId());
        ps.setInt(2, vendas.getVendaId());
        ps.setFloat(3, vendas.getValor());

        if (ps.executeUpdate() > 0) {
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return -1;

    }
}
