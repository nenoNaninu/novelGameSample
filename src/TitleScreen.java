import java.awt.*;

public class TitleScreen extends Screen{

    private Screen nextScreen;

    public TitleScreen() {
        this.nextScreen = this;
    }
    @Override
    public Screen getNextScreen() {
        return this.nextScreen;
    }

    @Override
    public void paint(Graphics g) {

    }

    @Override
    public void onTick() {

    }
}
