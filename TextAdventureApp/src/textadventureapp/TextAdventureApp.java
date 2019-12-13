package textadventureapp;

import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.application.Platform;
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
    private Map<String, Command> commands = new HashMap<>();
    
    private Parent createContent(){
        VBox root = new VBox(15,output,input);
        root.setPadding(new Insets(15));
        root.setPrefSize(800, 600);
        output.setEditable(false);
        output.setFocusTraversable(false);
        input.requestFocus();
        
        input.setOnAction(e -> {
            String inputText = input.getText();
            input.clear();
            onInput(inputText);
        });
        
        initCommands();
        initGame();
        return root;
    }
    
    private void initGame(){
        println("v 1.0");
    }
    
    private void println(String line){output.appendText( line + "\n");}
    @Override
    public void start(Stage stage) {
        
        stage.setScene(new Scene(createContent()));
        stage.setTitle("Hello World!");
        stage.show();
    }

    private void onInput(String line){
        if(!commands.containsKey(line)){
            println("Command " + line + " not found!");
            return;
        }
        
        commands.get(line).execute();
    }
    
    private void initCommands(){
        commands.put("exit", new Command("exit", "Exit game!", Platform::exit));
        commands.put("help", new Command("help", "Print all commands", this::runHelp));
     
    }
    private void runHelp(){
        commands.forEach((name,cmd) -> println(name + " : " + cmd.getDescription()));
    }
    
    public static void main(String[] args) {
        Application.launch(TextAdventureApp.class,args);
    }
    
}
