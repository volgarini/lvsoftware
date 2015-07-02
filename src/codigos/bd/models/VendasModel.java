/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigos.bd.models;

import codigos.bd.Banco;
import codigos.bd.beans.Vendas;
import java.sql.Date;
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
public class VendasModel extends Banco {

    public VendasModel() {
    }

    public int inserir(Vendas vendas) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = getConnection().prepareStatement("INSERT INTO VENDAS "
                + "(CLIENTE_ID, PAGAMENTO_ID, VALOR_TOTAL, DESCONTO, VALOR_FINAL, DATA_CADASTRO, CLIENTE, OBSERVACAO, PAGO)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

        if (vendas.getClienteId() == null) {
            ps.setNull(1, Types.INTEGER);
        } else {
            ps.setInt(1, vendas.getClienteId());
        }
        ps.setInt(2, vendas.getPagamentoId());
        ps.setFloat(3, vendas.getValorTotal());
        ps.setFloat(4, vendas.getDesconto());
        ps.setFloat(5, vendas.getValorFinal());
        if (vendas.getDataCadastro() == null) {
            ps.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
        }else{
            ps.setTimestamp(6, new Timestamp(vendas.getDataCadastro().getTime()));
        }
        ps.setString(7, vendas.getCliente());
        ps.setString(8, vendas.getObservacao());
        ps.setString(9, String.valueOf(vendas.getPago()));

        if (ps.executeUpdate() > 0) {
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return -1;

    }

    public ArrayList<Vendas> filtrar(Date dataI, Date dataF, int cliente, char pago) throws SQLException, ClassNotFoundException {
        ArrayList<Vendas> vendas = new ArrayList<>();
        PreparedStatement ps = null;
        String query = "select * from VENDAS ";

        String complemento = " WHERE ";
        if (dataI != null && dataF != null) {
            query += "where (date(DATA_CADASTRO) between '" + dataI + "' and '" + dataF + "') ";
            complemento = " AND";
        } else if (dataI != null) {
            query += "where (date(DATA_CADASTRO) >= '" + dataI + "') ";
            complemento = " AND";
        } else if (dataF != null) {
            query += "where (date(DATA_CADASTRO) <= '" + dataF + "') ";
            complemento = " AND";
        }

        if (cliente > 0) {
            query += complemento + " CLIENTE_ID = " + cliente;
            complemento = " AND ";
        }

        if (pago != '\0') {
            query += complemento + " PAGO = '" + pago + "'";
        }
        query += " ORDER BY DATA_CADASTRO";

        System.out.println(query);
        ps = getConnection().prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            vendas.add(new Vendas(rs.getInt("ID"), rs.getInt("CLIENTE_ID"), rs.getInt("PAGAMENTO_ID"), rs.getTimestamp("DATA_CADASTRO"), rs.getFloat("VALOR_TOTAL"), rs.getFloat("DESCONTO"), rs.getFloat("VALOR_FINAL"), rs.getString("CLIENTE"), rs.getString("OBSERVACAO"), rs.getString("PAGO").charAt(0)));
        }

        return vendas;
    }

    public int atualizarPagamento(Vendas vendas) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = getConnection().prepareStatement("UPDATE VENDAS SET "
                + "PAGO = ? WHERE ID = ?");

        ps.setString(1, String.valueOf(vendas.getPago()));
        ps.setInt(2, vendas.getId());

        if (ps.executeUpdate() > 0) {
            return vendas.getId();
        }
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
