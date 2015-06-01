/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigos.bd.models;

import codigos.bd.Banco;
import codigos.bd.beans.Vendas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;

/**
 *
 * @author Lucas
 */
public class VendasModel extends Banco {

    public VendasModel() {
    }

    public int inserir(Vendas vendas) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = getConnection().prepareStatement("INSERT INTO VENDAS "
                + "(CLIENTE_ID, PAGAMENTO_ID, VALOR_TOTAL, DESCONTO, VALOR_FINAL, DATA_CADASTRO, CLIENTE, OBSERVACAO)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

        if (vendas.getClienteId() == null) {
            ps.setNull(1, Types.INTEGER);
        } else {
            ps.setInt(1, vendas.getClienteId());
        }
        ps.setInt(2, vendas.getPagamentoId());
        ps.setFloat(3, vendas.getValorTotal());
        ps.setFloat(4, vendas.getDesconto());
        ps.setFloat(5, vendas.getValorFinal());
        ps.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
        ps.setString(7, vendas.getCliente());
        ps.setString(8, vendas.getObservacao());
        
        if (ps.executeUpdate() > 0) {
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return -1;

    }

    public int atualizar(Vendas pagamentos) throws SQLException {
//        PreparedStatement ps = getConnection().prepareStatement("UPDATE PAGAMENTOS SET "
//                + "DESCRICAO = ? WHERE ID = ?");
//
//        ps.setString(1, pagamentos.getDescricao());
//        ps.setInt(2, pagamentos.getId());
//
//        if (ps.executeUpdate() > 0) {
//            return pagamentos.getId();
//        }
        return -1;

    }

    public int desativar(Vendas pagamentos) throws SQLException {
//        PreparedStatement ps = getConnection().prepareStatement("UPDATE PAGAMENTOS SET "
//                + "DATA_EXCLUSAO = ? WHERE ID = ?");
//
//        ps.setDate(1, new Date(System.currentTimeMillis()));
//        ps.setInt(2, pagamentos.getId());
//
//        if (ps.executeUpdate() > 0) {
//            return pagamentos.getId();
//        }
        return -1;
    }
}
