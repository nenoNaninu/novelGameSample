import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class NovelGameView extends JPanel implements Observer {

    public NovelGameModel model;

    public NovelGameView(NovelGameModel model) {
        this.model = model;
        this.model.addObserver(this);

    }
    @Override
    public void update(Observable o, Object arg) {
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.model.setViewImg(g);
    }
}
