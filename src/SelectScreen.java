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
    public void onTick() {

    }

    @Override
    public void onClicked() {

    }
}
