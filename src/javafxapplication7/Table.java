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



public class Table {
    int id;
    String name;
    public static Connection conn;
    
    public Table(){
        
    }

    public Table(int id, String name) {
        this.id = id;
        this.name = name;
        
    }

    /*public ArrayList<Client> getAllClients() throws SQLException{
        try(Statement st = this.conn.createStatement()){
        ArrayList<Client> client = new ArrayList<Client>();
        ResultSet result = st.executeQuery("SELECT id, name FROM Client");
        
        while(result.next()){
            client.add(new Client(result.getInt("id"), result.getString("name")));
        }
        return client;
                }
        
    }*/
    
    

    
    }

