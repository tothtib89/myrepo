package checkers;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Ellipse;
import static checkers.Checkers.TILE_SIZE;
import javafx.scene.paint.Color;

public class Piece extends StackPane {

    private PieceType type;
    private double mouseX, mouseY, oldX, oldY;
    
    public Piece(PieceType type, int x, int y) {
        this.type = type;

        relocate(x * TILE_SIZE, y * TILE_SIZE);

        Ellipse bg = new Ellipse(TILE_SIZE * .3125, TILE_SIZE * .26);
        bg.setFill(type == PieceType.RED ? Color.valueOf("c40003") : 
                Color.valueOf("#fff9f4"));
        bg.setStroke(Color.BLACK);
        bg.setStrokeWidth(TILE_SIZE * .03);

        bg.setTranslateX((TILE_SIZE - TILE_SIZE * .3125 * 2) / 2);
        bg.setTranslateY((TILE_SIZE - TILE_SIZE * .26 * 2) / 2 + TILE_SIZE * .07);

        Ellipse ellipse = new Ellipse(TILE_SIZE * .3125, TILE_SIZE * .26);
        ellipse.setFill(type == PieceType.RED ? Color.valueOf("c40003") :
                Color.valueOf("#fff9f4"));
        ellipse.setStroke(Color.BLACK);
        ellipse.setStrokeWidth(TILE_SIZE * .03);

        ellipse.setTranslateX((TILE_SIZE - TILE_SIZE * .3125 * 2) / 2);
        ellipse.setTranslateY((TILE_SIZE - TILE_SIZE * .26 * 2) / 2);

        getChildren().addAll(bg, ellipse);
        
        setOnMousePressed(e -> {
            relocate(e.getSceneX() - mouseX + oldX, e.getSceneY() - mouseY + oldY);
        });
    }
    
    public void move(int x, int y){
        oldX = x * TILE_SIZE;
        oldY = y * TILE_SIZE;
        relocate(oldX,oldY);
    }

    public PieceType getType() {
        return type;
    }

    public void setType(PieceType type) {
        this.type = type;
    }

}
