import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;

public class NovelGameModel extends Observable implements Runnable {
    boolean workingFlag = false;
    FpsKeeper fpsKeeper;
    Screen currentScreen;
    Image image;
    int width;
    int height;
    public NovelGameModel(int width,int height) {
        this.fpsKeeper = new FpsKeeper();
        this.currentScreen = new TitleScreen();
        new Thread(this).start();
        this.width = width;
        this.height = height;
    }

    void clicked(MouseEvent mouseEvent) {
        this.currentScreen.onClicked();
        System.out.println("clicked");
    }

    void onTick() {

    }

    @Override
    public void run() {
        while (true) {
            this.fpsKeeper.keepFps();
            this.currentScreen.onTick();
            System.out.println("hoge");
            if(this.currentScreen.nextScreen != this.currentScreen){
                this.currentScreen = this.currentScreen.getNextScreen();
            }
            this.setChanged();
            this.notifyObservers();
        }
    }

    public void setViewImg(Graphics g) {
        //viewに渡すための画像を生成する
        this.currentScreen.drawViewImg(g);
    }
}
