/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigos.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Lucas
 */
public class Banco {

    private String usuario;
    private String senha;
    private String banco;
    private Connection conn;

    public Banco() {
        usuario = "root";
        senha = "root";
        banco = "madurro";
        conn = null;
    }

    public Banco(String usuario, String senha, String banco) {
        this.usuario = usuario;
        this.senha = senha;
        this.banco = banco;
        conn = null;
    }

    public Connection getConnection() throws SQLException {
        if (conn == null || conn.isClosed()) {
            Properties connectionProps = new Properties();
            connectionProps.put("user", this.usuario);
            connectionProps.put("password", this.senha);
            conn = DriverManager.getConnection(
                    "jdbc:derby://localhost:1527/"
                    + this.banco
                    + ";create=true",
                    connectionProps);
            System.out.println("Connected to database");
        }

        return conn;
    }

    public void fechar() throws SQLException {
        conn.close();
    }
}
