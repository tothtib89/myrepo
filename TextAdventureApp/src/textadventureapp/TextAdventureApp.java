package textadventureapp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TextAdventureApp extends Application {
    private TextArea output = new TextArea();
    private TextField input = new TextField();
    
    private Parent createContent(){
        VBox root = new VBox(15,output,input);
        root.setPadding(new Insets(15));
        root.setPrefSize(800, 600);
        return root;
    }
    
    
    @Override
    public void start(Stage stage) {
        
        stage.setScene(new Scene(createContent()));
        stage.setTitle("Hello World!");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(TextAdventureApp.class,args);
    }
    
}
