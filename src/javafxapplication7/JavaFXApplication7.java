/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication7;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author test
 */
public class JavaFXApplication7 extends Application {
    
    @Override
    public void start(Stage primaryStage) throws SQLException {
        DAO_SQL dao = new DAO_SQL();
        Table client = new Table();
        Cooker cooker = new Cooker();
        Order order = new Order();
        int amount;
        String meal;
        //Order order = new Order(78, "Sushi and rolls", "Ninja fish");
        //Order order2 = new Order(20, "Mexican rider", "Taco fucker");
        
        
        /*ArrayList<Client> list = new ArrayList<Client>();
        list = client.getAllClients();
        for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}*/
        /*client.SelectClient();
        cooker.SelectCooker();
        
        order.MadeOrder();
        order2.MadeOrder();
        
        cooker.SelectCooker();*/
        
        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        Scanner in3 = new Scanner(System.in);
        
        int choice;
        int finish = 0;
        
        System.out.println("1 -> Watch all clients in db;");
        System.out.println("2 -> Watch all cookers in db;");
        System.out.println("3 -> Watch menu");
        System.out.println("4 -> Make an order");
        System.out.println("5 -> exit");
        System.out.println("6 -> Delete or clean up a table");
        System.out.println("7 -> Update the database");
        
        for(int i = 0; i<100; i++){
        
        choice = in.nextInt();
        switch(choice){
            case 1: dao.SelectClient(); break;
            case 2: dao.SelectCooker(); break;
            case 3: dao.WatchMenu();
                    break;
            case 4: 
                try {
                    System.out.print("\ninput menu = ");
                    meal = in2.nextLine();
                    System.out.print("input amount of meal = ");
                    amount = in.nextInt();
                    ResultSet rs = Connect.statmt.executeQuery("SELECT * FROM Cooker WHERE meal = '" + meal +"'");
                    if(!rs.next()){
                        System.out.println("cannot find menu like that");
                    }
                    Order ord = new Order(amount, meal);
                    ord.MakeOrder();
                    break;
                    } catch (Exception e) {}
            case 5: 
                    finish = 1; break;
         case 6: 
             try{
            System.out.println("1 -> Delete a table");
            System.out.println("2 -> Clean up a table");
            int choice2 = in.nextInt();
        
            switch(choice2){
                case 1:
                    String table;
                    table = in2.nextLine();
                    ResultSet rs = Connect.statmt.executeQuery("SELECT * FROM " + table);
                    if(!rs.next()){
                        System.out.println("cannot find table like that");
                    }
                    dao.delete(table); break;
                   

                case 2: 
                    String table2;
                    table2 = in3.nextLine();
                    ResultSet rs2 = Connect.statmt.executeQuery("SELECT * FROM " + table2);
                    if(!rs2.next()){
                        System.out.println("cannot find table like that");
                    }
                    dao.delete(table2); break;
            }
                   
        }   catch(Exception e){} break;
         case 7:
            try{ 
             System.out.print("Input the name of the table you want to update: ");
             String tab = in3.nextLine();
             ResultSet rs = Connect.statmt.executeQuery("SELECT * FROM " + tab);
                    if(!rs.next()){
                        System.out.println("cannot find table like that"); 
                    }
             System.out.print("\nInput id of the row: ");
             String id = in3.nextLine();
             System.out.print("\nInput the name of the column you want to change: ");
             String clmn = in3.nextLine();
             System.out.print("\nInput the value you want to input into the table");
             String value = in3.nextLine();
             
             dao.update(tab, id, clmn, value); break;
            }
            catch(Exception e){}
       }
         if(finish>0) break;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
