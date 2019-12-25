package model.entity;


import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import model.hero.Character;

public class Fire {
    private Character character;
    private Pane root;
    private Circle fireBall;

    public Fire(Character character, Pane root) {
        this.root= root;
        this.character = character;

        initializeFireball();
        FirePosition fireballPosition = new FirePosition(fireBall);
    }

    private void initializeFireball(){
        fireBall = new Circle();
        fireBall.setRadius(20);
        fireBall.setFill(Color.RED);
        fireBall.setOpacity(20);
        fireBall.setCenterX(character.getHero().getX());
        fireBall.setCenterY(character.getHero().getY());

        root.getChildren().addAll(fireBall);
    }

}
