import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class MainFrame extends JFrame{

    public MainFrame() {
        super();
        this.setSize(1920, 1080);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        NovelGameModel novelGameModel = new NovelGameModel();
        NovelGameController novelGameController = new NovelGameController(novelGameModel);
        NovelGameView novelGameView = new NovelGameView(novelGameModel);
        this.addMouseListener(novelGameController);
        this.add(novelGameView);
    }


    public static void main(String[] args){
        new MainFrame();
    }
}
