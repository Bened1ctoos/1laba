/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author test
 */
class Connect {
    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;   
    
    public static Connection GetConn() throws ClassNotFoundException, SQLException{

        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:/Users/test/Desktop/sqlite-2.db");
        statmt = conn.createStatement();
        System.out.println("Connected!");
        return conn;}

    void commit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
