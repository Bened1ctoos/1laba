/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication7;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author test
 */
public class Cooker {
    int id;
    String name;
    public String menu;
    
    public Cooker(){}

    public Cooker(int id, String name, String menu) {
        this.id = id;
        this.name = name;
        this.menu = menu;
        
    
    }
    
        public String getMenu() {
        return menu;
    }

        public void setMenu(String meal) {
        this.menu = menu;
    }
    
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
    
}
