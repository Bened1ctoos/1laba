/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication7;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author test
 */
public class DAO_SQL implements DAO<Table> {
    static Connection conn;
    static {
        try {
            conn = Connect.GetConn();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO_SQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO_SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public boolean create(Table obj) {
        try {
            Statement s = conn.createStatement();
            s.execute("CREATE TABLE Client(id INT NOT NULL, "
                    + "login VARCHAR (20) NOT NULL,"
                    + "password VARCHAR(20) NOT NULL,"
                    + "PRIMARY KEY (ID))");
        } catch (SQLException e) {
            Logger.getLogger(DAO_SQL.class.getName()).log(Level.SEVERE, null, e);
        }
        return true;
    }
    
    @Override
    public void SelectCooker(){
    try{
            //Connect conn = new Connect();
            //conn.GetConn();
            ResultSet rs = Connect.statmt.executeQuery("SELECT * FROM Cooker");
            
            System.out.println("Cookers:"); 
            while(rs.next()){
                   System.out.println(rs.getString("id") + "     " + rs.getString("name") + "     " + rs.getString("meal") + "     " + rs.getString("orders"));
            }
            
        }
        catch(SQLException ex){}
        //catch(ClassNotFoundException ex){}
    }
    
    @Override
    public void SelectClient() {
        try{
            //Connect conn = new Connect();
            //conn.GetConn();
            ResultSet rs = Connect.statmt.executeQuery("SELECT * FROM Client");
            System.out.println("Clients:");
            
            while(rs.next()){
                    System.out.println("Name: " + rs.getString("name"));
            }
            
            while(rs.next()){
                    System.out.println("id: " + rs.getString("id") + "      Name: " + rs.getString("name"));
            }
            
        }
        catch(SQLException ex){}
        //catch(ClassNotFoundException ex){}
    }
    
    public void WatchMenu() {
           try{  ResultSet rs = Connect.statmt.executeQuery("SELECT meal FROM Cooker");
            
            System.out.println("Cookers:"); 
            while(rs.next()){
                   System.out.println(rs.getString("meal"));
            }
           }
           catch(SQLException ex){}
    }
    

    @Override
    public void delete(String tab) {
        try{
            ResultSet rs = Connect.statmt.executeQuery("DROP TABLE " + tab);
        }
        catch(SQLException ex){}
    }

    @Override
    public void update(String tab, String id, String clmn, String val) {
        try{
            ResultSet rs = Connect.statmt.executeQuery("UPDATE " + tab + " SET " + clmn + " = " + val + " WHERE id = " + id);
        }
        catch(SQLException ex){}
    }

}
