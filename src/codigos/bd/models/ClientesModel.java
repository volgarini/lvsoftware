/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigos.bd.models;

import codigos.bd.Banco;
import codigos.bd.beans.Clientes;
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
public class ClientesModel extends Banco {

    public ClientesModel() {
    }

    public int inserir(Clientes cliente) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = getConnection().prepareStatement("INSERT INTO CLIENTES (NOME, DATA_NASCIMENTO, SEXO, "
                + "NOME_PAI, CPF_PAI, EMAIL_PAI, FACEBOOK_PAI, TEL_RES_PAI, TEL_CEL_PAI, NOME_MAE, CPF_MAE, EMAIL_MAE, "
                + "FACEBOOK_MAE, TEL_RES_MAE, TEL_CEL_MAE, DATA_CADASTRO)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

        ps.setString(1, cliente.getNome());
        if (cliente.getDataNascimento() == null) {
            ps.setNull(2, Types.DATE);
        } else {
            ps.setDate(2, cliente.getDataNascimento());
        }
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
        ps.setTimestamp(16, new Timestamp(System.currentTimeMillis()));

        if (ps.executeUpdate() > 0) {
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return 0;

    }

    public int atualizar(Clientes cliente) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = getConnection().prepareStatement("UPDATE CLIENTES SET NOME = ?, DATA_NASCIMENTO = ?, SEXO = ?, "
                + "NOME_PAI = ?, CPF_PAI = ?, EMAIL_PAI = ?, FACEBOOK_PAI = ?, TEL_RES_PAI = ?, TEL_CEL_PAI = ?, NOME_MAE = ?, CPF_MAE = ?, EMAIL_MAE = ?, "
                + "FACEBOOK_MAE = ?, TEL_RES_MAE = ?, TEL_CEL_MAE = ?"
                + " WHERE ID = ?");

        ps.setString(1, cliente.getNome());
        if (cliente.getDataNascimento() == null) {
            ps.setNull(2, Types.DATE);
        } else {
            ps.setDate(2, cliente.getDataNascimento());
        }
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
        ps.setInt(16, cliente.getId());

        if (ps.executeUpdate() > 0) {
            return cliente.getId();
        }
        return 0;

    }

    public int desativar(Clientes cliente) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = getConnection().prepareStatement("UPDATE CLIENTES "
                + " SET DATA_EXCLUSAO = ? WHERE ID = ?");

        ps.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
        ps.setInt(2, cliente.getId());

        if (ps.executeUpdate() > 0) {
            return cliente.getId();
        }
        return 0;

    }

    public Clientes byNome(String nome) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = getConnection().prepareStatement("SELECT * FROM CLIENTES WHERE NOME = ? AND DATA_EXCLUSAO IS NULL");
        ps.setString(1, nome);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new Clientes(rs.getInt("ID"), rs.getString("NOME"), rs.getDate("DATA_NASCIMENTO"), rs.getString("SEXO").charAt(0),
                    rs.getString("NOME_PAI"), rs.getString("CPF_PAI"), rs.getString("EMAIL_PAI"), rs.getString("FACEBOOK_PAI"), rs.getString("TEL_RES_PAI"), rs.getString("TEL_CEL_PAI"),
                    rs.getString("NOME_MAE"), rs.getString("CPF_MAE"), rs.getString("EMAIL_MAE"), rs.getString("FACEBOOK_MAE"), rs.getString("TEL_RES_MAE"), rs.getString("TEL_CEL_MAE"),
                    rs.getTimestamp("DATA_CADASTRO"));
        }
        return new Clientes(-1);
    }

    public ArrayList<Clientes> likeNome(String nome) throws SQLException, ClassNotFoundException {
        ArrayList<Clientes> clientes = new ArrayList<>();

        PreparedStatement ps = getConnection().prepareStatement("SELECT * FROM CLIENTES WHERE lower(NOME) LIKE lower('%" + nome + "%') AND DATA_EXCLUSAO IS NULL");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            clientes.add(new Clientes(rs.getInt("ID"), rs.getString("NOME"), rs.getDate("DATA_NASCIMENTO"), rs.getString("SEXO").charAt(0),
                    rs.getString("NOME_PAI"), rs.getString("CPF_PAI"), rs.getString("EMAIL_PAI"), rs.getString("FACEBOOK_PAI"), rs.getString("TEL_RES_PAI"), rs.getString("TEL_CEL_PAI"),
                    rs.getString("NOME_MAE"), rs.getString("CPF_MAE"), rs.getString("EMAIL_MAE"), rs.getString("FACEBOOK_MAE"), rs.getString("TEL_RES_MAE"), rs.getString("TEL_CEL_MAE"),
                    rs.getTimestamp("DATA_CADASTRO")));
        }

        return clientes;
    }

    public ArrayList<Clientes> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Clientes> clientes = new ArrayList<>();

        PreparedStatement ps = getConnection().prepareStatement("SELECT * FROM CLIENTES WHERE DATA_EXCLUSAO IS NULL ORDER BY NOME");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            clientes.add(new Clientes(rs.getInt("ID"), rs.getString("NOME"), rs.getDate("DATA_NASCIMENTO"), rs.getString("SEXO").charAt(0),
                    rs.getString("NOME_PAI"), rs.getString("CPF_PAI"), rs.getString("EMAIL_PAI"), rs.getString("FACEBOOK_PAI"), rs.getString("TEL_RES_PAI"), rs.getString("TEL_CEL_PAI"),
                    rs.getString("NOME_MAE"), rs.getString("CPF_MAE"), rs.getString("EMAIL_MAE"), rs.getString("FACEBOOK_MAE"), rs.getString("TEL_RES_MAE"), rs.getString("TEL_CEL_MAE"),
                    rs.getTimestamp("DATA_CADASTRO")));
        }

        return clientes;
    }

    public ArrayList<Clientes> getAllParent(String parent) throws SQLException, ClassNotFoundException {
        ArrayList<Clientes> clientes = new ArrayList<>();

        PreparedStatement ps = getConnection().prepareStatement("SELECT * FROM CLIENTES WHERE (" + parent + " <> '' AND " + parent + " is not null) AND DATA_EXCLUSAO IS NULL");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            clientes.add(new Clientes(rs.getInt("ID"), rs.getString("NOME"), rs.getDate("DATA_NASCIMENTO"), rs.getString("SEXO").charAt(0),
                    rs.getString("NOME_PAI"), rs.getString("CPF_PAI"), rs.getString("EMAIL_PAI"), rs.getString("FACEBOOK_PAI"), rs.getString("TEL_RES_PAI"), rs.getString("TEL_CEL_PAI"),
                    rs.getString("NOME_MAE"), rs.getString("CPF_MAE"), rs.getString("EMAIL_MAE"), rs.getString("FACEBOOK_MAE"), rs.getString("TEL_RES_MAE"), rs.getString("TEL_CEL_MAE"),
                    rs.getTimestamp("DATA_CADASTRO")));
        }

        return clientes;
    }

    public ArrayList<Clientes> likeParent(String parent, String nome) throws SQLException, ClassNotFoundException {
        ArrayList<Clientes> clientes = new ArrayList<>();

        PreparedStatement ps = getConnection().prepareStatement("SELECT * FROM CLIENTES WHERE lower(" + parent + ") LIKE lower('%" + nome + "%') AND DATA_EXCLUSAO IS NULL");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            clientes.add(new Clientes(rs.getInt("ID"), rs.getString("NOME"), rs.getDate("DATA_NASCIMENTO"), rs.getString("SEXO").charAt(0),
                    rs.getString("NOME_PAI"), rs.getString("CPF_PAI"), rs.getString("EMAIL_PAI"), rs.getString("FACEBOOK_PAI"), rs.getString("TEL_RES_PAI"), rs.getString("TEL_CEL_PAI"),
                    rs.getString("NOME_MAE"), rs.getString("CPF_MAE"), rs.getString("EMAIL_MAE"), rs.getString("FACEBOOK_MAE"), rs.getString("TEL_RES_MAE"), rs.getString("TEL_CEL_MAE"),
                    rs.getTimestamp("DATA_CADASTRO")));
        }

        return clientes;
    }
}
