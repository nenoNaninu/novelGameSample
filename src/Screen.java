import java.awt.Graphics;


abstract public class Screen {

    abstract public Screen getNextScreen();
    abstract public void paint(Graphics g);
    abstract public void onTick();
}
