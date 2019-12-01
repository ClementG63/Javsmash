import javafx.scene.image.ImageView;

public class SkinPosition implements PositionAbstract {
    private ImageView skin;

    public SkinPosition(ImageView skin) {
        this.skin=skin;
    }

    protected void updatePosSkinY(CharacterPosition cp){
        setPosY(cp.getHeroPosY());
    }

    protected void updatePosSkinX(CharacterPosition cp){
        setPosX(cp.getHeroPosX());
    }

    @Override
    public void setPosX(double pos) {
        skin.setX(pos);
    }

    @Override
    public void setPosY(double pos) {
        skin.setY(pos);
    }


}
