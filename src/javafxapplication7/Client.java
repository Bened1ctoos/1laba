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
import java.util.ArrayList;



public class Client {
    int id;
    String name;
    public static Connection conn;
    
    public Client(){
        
    }

    public Client(int id, String name) {
        this.id = id;
        this.name = name;
        
    }

    public ArrayList<Client> getAllClients() throws SQLException{
        try(Statement st = this.conn.createStatement()){
        ArrayList<Client> client = new ArrayList<Client>();
        ResultSet result = st.executeQuery("SELECT id, name FROM Client");
        
        while(result.next()){
            client.add(new Client(result.getInt("id"), result.getString("name")));
        }
        return client;
                }
        
    }
    
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

    
    }

