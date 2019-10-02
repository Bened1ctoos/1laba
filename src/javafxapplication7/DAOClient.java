/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication7;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author test
 */
public class DAOClient implements DAO<Client> {
    static Connection conn;
    static {
        try {
            conn = Connect.GetConn();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public boolean create(Client obj) {
        try {
            Statement s = conn.createStatement();
            s.execute("CREATE TABLE Client(id INT NOT NULL, "
                    + "login VARCHAR (20) NOT NULL,"
                    + "password VARCHAR(20) NOT NULL,"
                    + "PRIMARY KEY (ID))");
        } catch (SQLException e) {
            Logger.getLogger(DAOClient.class.getName()).log(Level.SEVERE, null, e);
        }
        return true;
    }

    @Override
    public boolean search() {
        try{
            Statement s = conn.createStatement();
            s.execute("SELECT * FROM Cooker WHERE meal");
        }
        catch (SQLException e){
            Logger.getLogger(DAOClient.class.getName()).log(Level.SEVERE, null, e);
        }
        return true;
    }
    
    

    @Override
    public boolean delete(Client obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Client obj1, Client obj2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
