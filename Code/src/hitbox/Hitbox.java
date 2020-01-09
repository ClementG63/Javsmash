package hitbox;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Hitbox {

    public static final int divisor = 2;
    private static final int RADIUS = 10;
    private static final Color colorOfHitBox = Color.RED;

    private Rectangle hero;
    private ArrayList<Circle> circleArrayList;
    private Circle topRightHandCorner, topLeftHandCorner, bottomRightHandCorner, bottomLeftHandCorner, middleRight, middleLeft, middleTop, middleBottom;

    public Hitbox(Rectangle hero) {
        this.hero = hero;
        initializeHitbox();
        updateXY();
    }

    /***
     * Set position in X & Y for each Circle
     */
    public void updateXY() {
        //<editor-fold desc="TOP">
        //<editor-fold desc="POSITION X TOP">
        topLeftHandCorner.setCenterX(hero.getX());
        topRightHandCorner.setCenterX(hero.getX() + hero.getWidth());
        middleTop.setCenterX(hero.getX() + hero.getWidth() / divisor);
        //</editor-fold>

        //<editor-fold desc="POSITION Y TOP">
        topLeftHandCorner.setCenterY(hero.getY());
        topRightHandCorner.setCenterY(hero.getY());
        middleTop.setCenterY(hero.getY());
        //</editor-fold>
        //</editor-fold>

        //<editor-fold desc="BOTTOM">
        //<editor-fold desc="POSITION X BOTTOM">
        bottomRightHandCorner.setCenterX(hero.getX() + hero.getWidth());
        bottomLeftHandCorner.setCenterX(hero.getX());
        middleBottom.setCenterX(hero.getX() + hero.getWidth() / divisor);
        //</editor-fold>

        //<editor-fold desc="POSITION Y BOTTOM">
        bottomRightHandCorner.setCenterY(hero.getY() + hero.getHeight());
        bottomLeftHandCorner.setCenterY(hero.getY() + hero.getHeight());
        middleBottom.setCenterY(hero.getY() + hero.getHeight());
        //</editor-fold>
        //</editor-fold>

        //<editor-fold desc="MIDDLE">
        //<editor-fold desc="POSITION Y MIDDLE">
        middleLeft.setCenterX(hero.getX());
        middleRight.setCenterX(hero.getX() + hero.getWidth());
        //</editor-fold>

        //<editor-fold desc="POSITION Y MIDDLE">
        middleLeft.setCenterY(hero.getY() + hero.getHeight() / divisor);
        middleRight.setCenterY(hero.getY() + hero.getHeight() / divisor);
        //</editor-fold>
        //</editor-fold>

    }

    private void initializeHitbox() {
        circleArrayList = new ArrayList<>();

        initializeCircle();
        initializeArrayList();
    }

    private void initializeCircle() {
        topLeftHandCorner = new Circle(RADIUS, colorOfHitBox);
        topRightHandCorner = new Circle(RADIUS, colorOfHitBox);
        bottomLeftHandCorner = new Circle(RADIUS, colorOfHitBox);
        bottomRightHandCorner = new Circle(RADIUS, colorOfHitBox);
        middleRight = new Circle(RADIUS, colorOfHitBox);
        middleLeft = new Circle(RADIUS, colorOfHitBox);
        middleTop = new Circle(RADIUS, colorOfHitBox);
        middleBottom = new Circle(RADIUS, colorOfHitBox);
    }

    private void initializeArrayList() {
        circleArrayList.add(topLeftHandCorner);
        circleArrayList.add(topRightHandCorner);
        circleArrayList.add(bottomLeftHandCorner);
        circleArrayList.add(bottomRightHandCorner);
        circleArrayList.add(middleLeft);
        circleArrayList.add(middleRight);
        circleArrayList.add(middleBottom);
        circleArrayList.add(middleTop);
    }

    public ArrayList<Circle> getCircleArrayList() {
        return circleArrayList;
    }
}
