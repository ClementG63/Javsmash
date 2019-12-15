package model.hero;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;


/**
 * @author Clement GUYON
 * Character is the most used class because it defines the composition of an Character
 */
public class Character {

    private Rectangle hero;
    private CharacterSkinPosition sp;
    private CharacterPosition characterPos;
    private CharacterSkinLoader skin;
    private HealPoints life;

    /**
     * Constructor which defines the circle which represents the Character, his skin and his position, his position at the spawn,
     * opacity and number of Life Points
     *
     * @param sc1 type of Scene, is the Scene where the Character will moves
     */
    public Character(Scene sc1) {
        this.hero = new Rectangle(50, 50);
        skin = new CharacterSkinLoader(1);
        sp = new CharacterSkinPosition(skin);
        life = new HealPoints();

        sp.setPosX(hero.getX());
        sp.setPosY(hero.getY());

        hero.setOpacity(0);
        characterPos = new CharacterPosition(this, sc1);
        characterPos.spawnHeroPosition();
        life.setHP(100);
    }

    /**
     * Getter of the Hero
     *
     * @return hero type of Rectangle
     */
    public Rectangle getHero() {
        return hero;
    }

    /**
     * Getter of the skin image
     *
     * @return skin type of ImageView
     */
    public ImageView getSkin() {
        return skin.getSkinImage();
    }

    /**
     * Getter of the skin manager
     *
     * @return skin type of CharacterSkinLoader
     */
    CharacterSkinLoader getSkinLoader() {
        return skin;
    }

    /**
     * Getter of the CharacterSkinPosition which defines the position of the skin
     *
     * @return sp type of skin position
     */
    CharacterSkinPosition getSp() {
        return sp;
    }

}
