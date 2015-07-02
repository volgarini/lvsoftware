/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigos.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Lucas
 */
public class Banco {

    private static final String URL = "jdbc:derby:madurrodb;create=true";
    private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";

    private String usuario;
    private String senha;
    private String banco;
    private static Connection conn = null;

    public Banco() {
        usuario = "root";
        senha = "root";
        banco = "madurro";
    }

    public Banco(String usuario, String senha, String banco) {
        this.usuario = usuario;
        this.senha = senha;
        this.banco = banco;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        if (conn == null || conn.isClosed()) {
            System.out.println("Conectando....");
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL);
            System.out.println("Conectado ao banco de dados");

//            Properties connectionProps = new Properties();
//            connectionProps.put("user", this.usuario);
//            connectionProps.put("password", this.senha);
//            conn = DriverManager.getConnection(
//                    "jdbc:derby://localhost:1527/"
//                    + this.banco
//                    + ";create=true",
//                    connectionProps);
//            System.out.println("Connected to database");
        }
        return conn;
    }

    public void fechar() throws SQLException {
        conn.close();
    }

    public void createTableCidades() throws SQLException {

        String sql = "create table CIDADES "
                + "(ID integer not null GENERATED ALWAYS AS "
                + "IDENTITY (START WITH 1, INCREMENT BY 1) CONSTRAINT PK_CIDADES PRIMARY KEY, "
                + "ESTADO_ID INTEGER, "
                + "NOME VARCHAR(150), "
                + "CONSTRAINT FK_CIDADES_ESTADOS FOREIGN KEY (ESTADO_ID) "
                + "REFERENCES ESTADOS (ID)"
                + ")";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.execute();
        stmt.close();
        System.out.println("CreateTables.createTableCidades Ok!");

    }

    public void createTableEstados() throws SQLException {

        String sql = "create table ESTADOS "
                + "(ID integer not null GENERATED ALWAYS AS "
                + "IDENTITY (START WITH 1, INCREMENT BY 1) CONSTRAINT PK_ESTADOS PRIMARY KEY, "
                + "NOME VARCHAR(150), "
                + "SIGLA CHAR(2)"
                + ")";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.execute();
        stmt.close();
        System.out.println("CreateTables.createTableEstados Ok!");

    }

    public void createTableClientes() throws SQLException {

        String sql = "create table CLIENTES "
                + "(ID integer not null GENERATED ALWAYS AS "
                + "IDENTITY (START WITH 1, INCREMENT BY 1) CONSTRAINT PK_CLIENTES PRIMARY KEY, "
                + "NOME VARCHAR(150), "
                + "DATA_NASCIMENTO DATE, "
                + "SEXO CHAR(1), "
                + "NOME_PAI VARCHAR(150), "
                + "CPF_PAI VARCHAR(14), "
                + "EMAIL_PAI VARCHAR(50), "
                + "FACEBOOK_PAI VARCHAR(50), "
                + "TEL_RES_PAI VARCHAR(15), "
                + "TEL_CEL_PAI VARCHAR(15), "
                + "NOME_MAE VARCHAR(150), "
                + "CPF_MAE VARCHAR(14), "
                + "EMAIL_MAE VARCHAR(50), "
                + "FACEBOOK_MAE VARCHAR(50), "
                + "TEL_RES_MAE VARCHAR(15), "
                + "TEL_CEL_MAE VARCHAR(15), "
                + "DATA_CADASTRO TIMESTAMP, "
                + "DATA_EXCLUSAO TIMESTAMP"
                + ")";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.execute();
        stmt.close();
        System.out.println("CreateTables.createTableClientes Ok!");

    }

    public void createTableEnderecos() throws SQLException {

        String sql = "create table ENDERECOS "
                + "(ID integer not null GENERATED ALWAYS AS "
                + "IDENTITY (START WITH 1, INCREMENT BY 1) CONSTRAINT PK_ENDERECOS PRIMARY KEY, "
                + "ESTADO_ID INTEGER, "
                + "CLIENTE_ID INTEGER, "
                + "CIDADE_ID INTEGER, "
                + "LOGRADOURO VARCHAR(150), "
                + "COMPLEMENTO VARCHAR(150), "
                + "BAIRRO VARCHAR(150), "
                + "CEP VARCHAR(9), "
                + "DATA_CADASTRO TIMESTAMP, "
                + "CONSTRAINT FK_ENDERECOS_ESTADOS FOREIGN KEY (ESTADO_ID) "
                + "REFERENCES ESTADOS (ID), "
                + "CONSTRAINT FK_ENDERECOS_CLIENTES FOREIGN KEY (CLIENTE_ID) "
                + "REFERENCES CLIENTES (ID), "
                + "CONSTRAINT FK_ENDERECOS_CIDADES FOREIGN KEY (CIDADE_ID) "
                + "REFERENCES CIDADES (ID)"
                + ")";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.execute();
        stmt.close();
        System.out.println("CreateTables.createTableEnderecos Ok!");

    }

    public void createTablePagamentos() throws SQLException {

        String sql = "create table PAGAMENTOS "
                + "(ID integer not null GENERATED ALWAYS AS "
                + "IDENTITY (START WITH 1, INCREMENT BY 1) CONSTRAINT PK_PAGAMENTOS PRIMARY KEY, "
                + "DESCRICAO VARCHAR(150), "
                + "DATA_CADASTRO TIMESTAMP, "
                + "DATA_EXCLUSAO TIMESTAMP"
                + ")";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.execute();
        stmt.close();
        System.out.println("CreateTables.createTablePagamentos Ok!");

    }

    public void createTableProdutos() throws SQLException {

        String sql = "create table PRODUTOS "
                + "(ID integer not null GENERATED ALWAYS AS "
                + "IDENTITY (START WITH 1, INCREMENT BY 1) CONSTRAINT PK_PRODUTOS PRIMARY KEY, "
                + "DESCRICAO VARCHAR(150), "
                + "TIPO CHAR(1), "
                + "CODIGO_BARRAS VARCHAR(150), "
                + "QUANTIDADE INTEGER, "
                + "VALOR DECIMAL(10,2), "
                + "DATA_CADASTRO TIMESTAMP, "
                + "DATA_EXCLUSAO TIMESTAMP"
                + ")";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.execute();
        stmt.close();
        System.out.println("CreateTables.createTableProdutos Ok!");
    }

    public void createTableVendas() throws SQLException {

        String sql = "create table VENDAS "
                + "(ID integer not null GENERATED ALWAYS AS "
                + "IDENTITY (START WITH 1, INCREMENT BY 1) CONSTRAINT PK_VENDAS PRIMARY KEY, "
                + "CLIENTE_ID INTEGER, "
                + "PAGAMENTO_ID INTEGER, "
                + "VALOR_TOTAL DECIMAL(6,2), "
                + "DESCONTO DECIMAL(6,2), "
                + "VALOR_FINAL DECIMAL(6,2), "
                + "CLIENTE VARCHAR(150), "
                + "OBSERVACAO LONG VARCHAR, "
                + "PAGO CHAR(1), "
                + "DATA_CADASTRO TIMESTAMP, "
                + "CONSTRAINT FK_VENDAS_CLIENTES FOREIGN KEY (CLIENTE_ID) "
                + "REFERENCES CLIENTES (ID), "
                + "CONSTRAINT FK_VENDAS_PAGAMENTOS FOREIGN KEY (PAGAMENTO_ID) "
                + "REFERENCES PAGAMENTOS (ID)"
                + ")";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.execute();
        stmt.close();
        System.out.println("CreateTables.createTableVendas Ok!");

    }

    public void createTableVendasHasProdutos() throws SQLException {

        String sql = "create table VENDAS_HAS_PRODUTOS "
                + "(ID integer not null GENERATED ALWAYS AS "
                + "IDENTITY (START WITH 1, INCREMENT BY 1) CONSTRAINT PK_VENDAS_HAS_PRODUTOS PRIMARY KEY, "
                + "PRODUTO_ID INTEGER, "
                + "VENDA_ID INTEGER, "
                + "VALOR DECIMAL(6,2), "
                + "QUANTIDADE INTEGER, "
                + "CONSTRAINT FK_VENDAS_HAS_PRODUTOS_PRODUTOS FOREIGN KEY (PRODUTO_ID) "
                + "REFERENCES PRODUTOS (ID), "
                + "CONSTRAINT FK_VENDAS_HAS_PRODUTOS_VENDAS FOREIGN KEY (VENDA_ID) "
                + "REFERENCES VENDAS (ID)"
                + ")";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.execute();
        stmt.close();
        System.out.println("CreateTables.createTableVendasHasProdutos Ok!");

    }
}
