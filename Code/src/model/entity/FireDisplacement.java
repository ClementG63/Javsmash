package model.entity;

import model.animation.Sprite;

public class FireDisplacement {
    public static final int FIREBALL_MOVEMENT_ITERATOR = 10;
    public static final int MAX_RANGE_FIREBALL_VALUE = 600;
    private static final long ONE_MICRO_SECOND = 1000000;

    private long timeDisplacementFireball;

    private Fire fire;
    private Sprite sprite;

    /***
     * Instantiates the fireball
     *
     * @param fire current fireball
     */
    public FireDisplacement(Fire fire) {
        this.fire = fire;
        this.sprite = new Sprite(fire.getSkinManager(), "Entity");
    }

    /***
     * Methods that permits to the firewall to go forward
     *
     */
    public void goForward() {

        fire.getSkinManager().getSkinImage().setScaleX(fire.getDirection());
        sprite.spriteAnimation("Forward");
        fire.getFireballPosition().setPosXY(fire.getFireballPosition().getPosX() + FIREBALL_MOVEMENT_ITERATOR * fire.getDirection(), fire.getFireballPosition().getPosY());
    }

    /**
     * Check if an fireball is casted, if not throw new Fireball at the position of the character who attacked )
     *
     * @throws NullPointerException is thrown if any fireBall is casted
     */
  /* public void hasAttacked(long time) {
        try {
            if (fire != null) {
                if (!(fire.getFireballPosition().getPosX() > fire.getCharacter().getHero().getX() + MAX_RANGE_FIREBALL_VALUE)) {
                    if (time - timeDisplacementFireball > ONE_MICRO_SECOND) {
                        goForward(fire.getCharacter().getSkin().getScaleX());
                        timeDisplacementFireball = time;
                    }
                } else {
                    fire.destruction();
                    System.gc();
                }
            }
        } catch (NullPointerException ignored) {
        }
    }*/
}
