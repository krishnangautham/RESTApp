package com.restapp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreator {

    private static final String HOST = "jdbc:derby://localhost:1527/sample";
    private static final String USERNAME = "app";
    private static final String PASSWORD = "app";
    private static Connection con;
    private static Statement stmt;
    /***************************************************************************
                                 Create scripts   
    ****************************************************************************/
    private static final String CREATE_TABLE_ADDRESS = "CREATE TABLE address (\n"
            + "    customer_id      INTEGER NOT NULL PRIMARY KEY,\n"
            + "    address_line_1   VARCHAR(50),\n"
            + "    address_line_2   VARCHAR(50),\n"
            + "    city             VARCHAR(30),\n"
            + "    state            VARCHAR(30)\n"
            + ")";
    private static final String CREATE_TABLE_CLIENT = "CREATE TABLE client (\n"
            + "    customer_id     INTEGER NOT NULL PRIMARY KEY,\n"
            + "    salutation_id   INTEGER NOT NULL,\n"
            + "    name            VARCHAR(30),\n"
            + "    email           VARCHAR(30),\n"
            + "    credit_limit    INTEGER\n"
            + ")";
    private static final String CREATE_TABLE_PRODUCT = "CREATE TABLE product_catalog (\n"
            + "    product_id         INTEGER NOT NULL PRIMARY KEY,\n"
            + "    product_name       VARCHAR(30),\n"
            + "    product_category   VARCHAR(5) NOT NULL,\n"
            + "    purchase_cost      REAL,\n"
            + "    quantity_on_hand   INTEGER\n"
            + ")";
    private static final String CREATE_TABLE_CATEGORY = "CREATE TABLE product_category (\n"
            + "    category_code   VARCHAR(5) NOT NULL PRIMARY KEY,\n"
            + "    name            VARCHAR(50)\n"
            + ")";
    private static final String CREATE_TABLE_ORDER = "CREATE TABLE sales_order (\n"
            + "    order_number   INTEGER NOT NULL PRIMARY KEY,\n"
            + "    customer_id    INTEGER NOT NULL,\n"
            + "    product_id     INTEGER NOT NULL,\n"
            + "    quantity       INTEGER,\n"
            + "    order_date     DATE\n"
            + ")";
    private static final String CREATE_TABLE_SALUTATION = "CREATE TABLE salutation (\n"
            + "    salutation_id   INTEGER NOT NULL PRIMARY KEY,\n"
            + "    salutation      VARCHAR(10)\n"
            + ")\n"
            + "";
    private static final String ALTER_TABLE_ADDRESS = "ALTER TABLE address\n"
            + "    ADD CONSTRAINT address_customer_fk FOREIGN KEY ( customer_id )\n"
            + "        REFERENCES client ( customer_id )";
    private static final String ALTER_TABLE_CLIENT = "ALTER TABLE client\n"
            + "    ADD CONSTRAINT customer_salutation_fk FOREIGN KEY ( salutation_id )\n"
            + "        REFERENCES salutation ( salutation_id )";
    private static final String ALTER_TABLE_PRODUCT = "ALTER TABLE product_catalog\n"
            + "    ADD CONSTRAINT product_product_category_fk FOREIGN KEY ( product_category )\n"
            + "        REFERENCES product_category ( category_code )";
    private static final String ALTER_TABLE_ORDER_1 = "ALTER TABLE sales_order\n"
            + "    ADD CONSTRAINT purchase_order_customer_fk FOREIGN KEY ( customer_id )\n"
            + "        REFERENCES client ( customer_id )";
    private static final String ALTER_TABLE_ORDER_2 = "ALTER TABLE sales_order\n"
            + "    ADD CONSTRAINT purchase_order_product_fk FOREIGN KEY ( product_id )\n"
            + "        REFERENCES product_catalog ( product_id )";

    
    public void createTables() throws Exception {

        try {
            con = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
            System.out.println("Connection successful!");
        } catch (SQLException e) {
            System.err.println("There was an error getting the connection");
            throw e;
        }

        try {
            stmt = con.createStatement();

            stmt.executeUpdate(CREATE_TABLE_ADDRESS);
            stmt.executeUpdate(CREATE_TABLE_CLIENT);
            stmt.executeUpdate(CREATE_TABLE_PRODUCT);
            stmt.executeUpdate(CREATE_TABLE_CATEGORY);
            stmt.executeUpdate(CREATE_TABLE_ORDER);
            stmt.executeUpdate(CREATE_TABLE_SALUTATION);

            stmt.executeUpdate(ALTER_TABLE_ADDRESS);
            stmt.executeUpdate(ALTER_TABLE_CLIENT);
            stmt.executeUpdate(ALTER_TABLE_PRODUCT);
            stmt.executeUpdate(ALTER_TABLE_ORDER_1);
            stmt.executeUpdate(ALTER_TABLE_ORDER_2);

            System.out.println("Tables created!");
        } catch (SQLException e) {
            System.err.println("Error creating tables");
            throw e;
        } finally {
            try {
                // Close connection
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }

}
