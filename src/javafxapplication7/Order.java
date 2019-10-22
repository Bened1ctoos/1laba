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
public class Order {
    
    int add;
    String meal;
    String name;
    
    public Order(int add, String meal, String name){
        this.add = add;
        this.meal = meal;
        this.name = name;
    }
    
    public Order(int add, String meal){
        this.add = add;
        this.meal = meal;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }
    
    
    
    public Order(){}
    
    public void MakeOrder(){
        try{
            String str = Integer.toString(add);
            //Connect conn = new Connect();
            //conn.GetConn();
            Connect.statmt.execute("UPDATE Cooker SET orders = " + "orders + " + str + " WHERE meal = " + "'" + meal + "'");
            Connect.conn.commit();
            
            
        }
        catch(SQLException ex){}
        //catch(ClassNotFoundException ex){}
    }
    

    
     
    
}
