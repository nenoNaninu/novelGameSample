import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class TitleScreen extends Screen{

    private Screen nextScreen;

    Image titleImg;

    public TitleScreen() {
        this.nextScreen = this;
        try{
            this.titleImg = ImageIO.read(new File("./img/title.jpg"));
        }catch(Exception e) {
            this.titleImg = null;
        }

    }
    @Override
    public Screen getNextScreen() {
        return this.nextScreen;
    }


    @Override
    public boolean onTick() {
        return false;

    }

    @Override
    public void onClicked() {
        nextScreen = new ScenarioScreen("prologue.txt");
    }

    @Override
    public void drawViewImg(Graphics g) {
        if (titleImg != null) {
            g.drawImage(titleImg,0,0,null);
        }else{
            JOptionPane.showMessageDialog(null, "処理中にエラーが発生しました");
            System.exit(-1);
        }
    }
}
