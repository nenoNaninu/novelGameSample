import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class DisplayedCharacter {
    private Image characterImg = null;
    private String imgName = "";
    private CharaPos charaPos = CharaPos.Right;

    public void setImage(String imgName) {
        this.imgName = imgName;
        try{
            this.characterImg = ImageIO.read(new File("./img/"+imgName+".png"));
        }catch(Exception e) {
            this.characterImg = null;
            JOptionPane.showMessageDialog(null, "処理中にエラーが発生しました\n"+e.getMessage());
            System.exit(-1);
        }
    }

    public void setPos(CharaPos pos) {
        this.charaPos = pos;
    }

    void drawViewImg(Graphics g) {
        if(this.charaPos == CharaPos.Right){
            g.drawImage(this.characterImg,480,360,null);
        }else{
            g.drawImage(this.characterImg,1440,360,null);
        }
    }
}

enum CharaPos{
  Left,
  Right
};