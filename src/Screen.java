import java.awt.Graphics;


abstract public class Screen {
    protected Screen nextScreen;
    abstract public Screen getNextScreen();
    abstract public void paint(Graphics g);
    abstract public boolean onTick();
    abstract public void onClicked();

    abstract public void drawViewImg(Graphics g);


}
