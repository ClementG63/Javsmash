package model.entity;

import javafx.scene.image.ImageView;
import model.Interface.Positionable;
import model.Interface.SkinPositionable;
import model.manager.SkinManager;

public class FireSkinPosition implements Positionable, SkinPositionable {
    public static final int CHARACTER_FIREBALL_SHIFT_X = 50;
    public static final int CHARACTER_FIREBALL_SHIFT_Y = 20;
    private ImageView skin;

    /***
     * Constructor of the skinPosition
     * @param skin the skin of the fireball
     */
    FireSkinPosition(SkinManager skin) {
        this.skin = skin.getSkinImage();
        skin.getSkinImage().setFitHeight(60);
        skin.getSkinImage().setFitWidth(80);
    }


    //<editor-fold desc="POSITION X & Y UPDATER">
    public void updatePosSkinX(double pos) {
        setPosX(pos - CHARACTER_FIREBALL_SHIFT_X);
    }

    public void updatePosSkinY(double pos) {
        setPosY(pos - CHARACTER_FIREBALL_SHIFT_Y);
    }
    //</editor-fold>


    //<editor-fold desc="POSITION SETTER X & Y">

    /***
     * Position in X
     * @param pos type of double
     */
    @Override
    public void setPosX(double pos) {
        skin.setX(pos);
    }

    /***
     * Position in Y
     * @param pos type of double
     */
    @Override
    public void setPosY(double pos) {
        skin.setY(pos);
    }
    //</editor-fold>


}
