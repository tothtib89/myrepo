/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotto;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewController implements Initializable {
    private final int MIN = 1;
    private final int MAX = 90;
    private ArrayList<Integer> list = new ArrayList<Integer>();
    private int rnd;
    private int getNum1;
    private int getNum2;
    private int getNum3;
    private int getNum4;
    private int getNum5;
    
    private int selNum1;
    private int selNum2;
    private int selNum3;
    private int selNum4;
    private int selNum5;
 
    @FXML
    private Label l1;
       @FXML
    private Label l2;
    @FXML
    private Label l3;
    @FXML
    private Label l4;
    @FXML
    private Label l5;
 
    @FXML
    private TextField input1;
       @FXML
    private TextField input2;
    @FXML
    private TextField input3;
    @FXML
    private TextField input4;
    @FXML
    private TextField input5;

    @FXML
    private void button(ActionEvent event) {
        selNum1 = Integer.parseInt(input1.getText());
        selNum2 = Integer.parseInt(input2.getText());
        selNum3 = Integer.parseInt(input3.getText());
        selNum4 = Integer.parseInt(input4.getText());
        selNum5 = Integer.parseInt(input5.getText());
       while(list.size() < 5){
            rnd = getRnd();
            if (list.contains(rnd)){
                rnd = getRnd();
            }else{
             list.add(rnd);        
            }
        }
        l1.setText(list.get(0) + " ");
        l2.setText(list.get(1) + " ");
        l3.setText(list.get(2) + " ");
        l4.setText(list.get(3) + " ");
        l5.setText(list.get(4) + " ");
        list.clear();
     }
    
    private int getRnd(){
        return (int) (Math.random() * MAX) + MIN;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Start...");
    }    
    
}
//https://codingbat.com/java