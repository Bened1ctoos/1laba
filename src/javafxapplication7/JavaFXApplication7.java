/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication7;

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
        DAOClient dao = new DAOClient();
        Client client = new Client();
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
        
        int choice;
        int finish = 0;
        
        System.out.println("1 -> Watch all clients in db;");
        System.out.println("2 -> Watch all cookers in db;");
        System.out.println("3 -> Watch menu");
        
        for(int i = 0; i<100; i++){
        
        choice = in.nextInt();
        switch(choice){
            case 1: client.SelectClient(); break;
            case 2: cooker.SelectCooker(); break;
            case 3: order.WatchMenu();
                    break;
            case 4: 
                try {
                    System.out.print("\ninput menu = ");
                    meal = in2.nextLine();
                    System.out.print("input amount of meal = ");
                    amount = in.nextInt();
                    
                    Order ord = new Order(amount, meal);
                    ord.MakeOrder();
                    break;
                    } catch (InputMismatchException e) { 
                        in.next();
                    }
            case 5: 
                    finish = 1; break;
            
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
