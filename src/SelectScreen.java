import java.awt.*;

public class SelectScreen extends Screen {

    public SelectScreen() {
        this.nextScreen = this;
    }

    @Override
    public Screen getNextScreen() {
        return null;
    }

    @Override
    public void paint(Graphics g) {

    }

    @Override
    public boolean onTick() {
        return false;
    }

    @Override
    public void onClicked() {

    }

    @Override
    public void drawViewImg(Graphics g) {

    }
}
