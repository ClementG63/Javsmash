package model.hero;

import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import model.entity.Fire;
import model.hitbox.Hitbox;
import model.manager.SkinManager;

import java.util.ArrayList;


/**
 * @author Clement GUYON
 * Character is the most used class because it defines the composition of an Character
 */
public class Character {

    private static final int HERO_WIDTH = 50;
    private static final int HERO_HEIGHT = 50;
    private static final int OPACITY = 0;

    private Rectangle hero;
    private HealPoints life;
    private Hitbox hitbox;

    //SKINABLE
    private SkinManager skin;
    private CharacterSkinPosition sp;

    private ArrayList<Fire> listFireBall;
    /**
     * Constructor which defines the circle which represents the Character, his skin and his position, his position at the spawn,
     * opacity and number of Life Points
     *
     */
    public Character(String characterSelected, boolean isFirstCharacterSelected) {
        this.hero = new Rectangle(HERO_WIDTH, HERO_HEIGHT);
        skin            = new SkinManager(characterSelected);
        sp              = new CharacterSkinPosition(skin);
        life = new HealPoints();
        hitbox = new Hitbox(hero);
        listFireBall = new ArrayList<>();

        initializeSpawn();

        CharacterPosition characterPos = new CharacterPosition(this);
        characterPos.spawnHeroPosition(isFirstCharacterSelected);
    }

    private void initializeSpawn() {
        hero.setOpacity(OPACITY);
    }

    public void heroDestructor() {
        hero = null;
        skin = null;
        sp = null;
        hitbox = null;
        life = null;

        System.gc();
    }

    /**
     * Getter of the Hero
     *
     * @return hero type of Rectangle
     */
    public Rectangle getHero() {
        return hero;
    }

    public Hitbox getHitbox() {
        return hitbox;
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
    public SkinManager getSkinManager() {
        return skin;
    }

    /**
     * Getter of the CharacterSkinIPosition which defines the position of the skin
     *
     * @return sp type of skin position
     */

    CharacterSkinPosition getSp() {
        return sp;
    }

    public HealPoints getLifeStatus() {
        return life;
    }

    public void setLife(double life) {
        getLifeStatus().setHP(getLifeStatus().getHP() + life);
    }

    public ArrayList<Fire> getListFireBall() {
        return listFireBall;
    }

    public void AddFireBall(Fire ball){
        listFireBall.add(ball);
    }
}
