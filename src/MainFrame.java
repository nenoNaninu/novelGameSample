import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class MainFrame extends JFrame{

    public MainFrame() {
        super();
        this.setSize(1920, 1080);
        int width = 1920;
        int height = 1080;
        NovelGameModel novelGameModel = new NovelGameModel(width,height);
        NovelGameController novelGameController = new NovelGameController(novelGameModel);
        NovelGameView novelGameView = new NovelGameView(novelGameModel);
        this.addMouseListener(novelGameController);
        this.add(novelGameView);
        this.setFocusable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public static void main(String[] args){
        new MainFrame();
    }
}
