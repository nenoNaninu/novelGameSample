import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class NovelGameController  implements MouseListener{

    NovelGameModel model;

    public NovelGameController(NovelGameModel model) {
        this.model = model;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        model.clicked(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
