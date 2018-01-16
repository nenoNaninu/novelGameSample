import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;

public class NovelGameModel extends Observable implements Runnable{
    boolean workingFlag = false;
    FpsKeeper fpsKeeper;
    Screen currentScreen;
    public NovelGameModel() {
        this.fpsKeeper = new FpsKeeper();
        this.currentScreen = new TitleScreen();
        new Thread(this).start();
    }

    void clicked(MouseEvent mouseEvent) {
        if(workingFlag){
            return;
        }else{
            workingFlag = true;
            //ここにいろいろ書いていく感じ。

        }
    }

    void onTick() {

    }

    @Override
    public void run() {
        this.fpsKeeper.keepFps();
        this.currentScreen.onTick();
        this.setChanged();
        this.notifyObservers();

    }
}
