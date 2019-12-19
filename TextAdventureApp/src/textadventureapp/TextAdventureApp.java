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
    private Room[][] rooms = new Room[10][10];
    private int currentX = 5;
    private int currentY = 4;

    private Parent createContent() {
        VBox root = new VBox(15, output, input);
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

    private void initGame() {
        println("v 1.0");
        initCommands();
        initRooms();
     }

    private void println(String line) {
        output.appendText(line + "\n");
   }

    @Override
    public void start(Stage stage) {

        stage.setScene(new Scene(createContent()));
        stage.setTitle("Hello World!");
        stage.show();
    }

    private void onInput(String line) {
        if (!commands.containsKey(line)) {
            println("Command " + line + " not found!");
            return;
        }

        commands.get(line).execute();
    }

    private void initCommands() {
        commands.put("exit", new Command("exit", "Exit game!", Platform::exit));
        commands.put("help", new Command("help", "Print all commands", this::runHelp));
        commands.put("go west", new Command("go west", "Move  west", () -> runGo(-1, 0)));
        commands.put("go east", new Command("go east", "Move east", () -> runGo(1, 0)));
        commands.put("go north", new Command("go north", "Go north", () -> runGo(0, -1)));
        commands.put("go south", new Command("go south", "Go south", () -> runGo(0, 1)));
 //       commands.put("kill monster", new Command("kill", "Kill", () -> this::runKill));
        commands.put("attack", new Command("attack", "Kill monster in the room", this::runAttack));
    }

    private Room getCurrentRoom() {
        return rooms[currentX][currentY];
    }

    private void initRooms() {
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                rooms[x][y] = new Room(x, y);
                if (Math.random() < .2) {
                    rooms[x][y].spawnMonster();
                }
            }
        }
    }

    private void runAttack() {
        getCurrentRoom().killMonsters();
        println("Kill monster in the room");

    }

    private void runHelp() {
        commands.forEach((name, cmd) -> println(name + " : " + cmd.getDescription()));
    }

    private void runGo(int dx, int dy) {
        if (getCurrentRoom().hasMonsters()) {
            println("The room still has monster!");
            return;
        }

        currentX += dx;
        currentY += dy;
        println(dx + " " + dy);
    }

    public static void main(String[] args) {
        Application.launch(TextAdventureApp.class, args);
    }

}
