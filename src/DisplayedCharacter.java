import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class DisplayedCharacter
{
    private Image characterImg = null;
    private String imgName = "";
    private CharaPos charaPos = CharaPos.Right;
    private boolean isDisplay;

    public DisplayedCharacter(String pos)
    {
        this.isDisplay = false;
        if (pos.equals("center"))
        {
            charaPos = CharaPos.Center;
        }
        else if (pos.equals("right"))
        {
            charaPos = CharaPos.Right;
        }
        else
        {
            charaPos = CharaPos.Left;
        }
    }

    public void setImage(String imgName)
    {
        this.imgName = imgName;
        try
        {
            this.characterImg = ImageIO.read(new File("./img/" + imgName));
        }
        catch (Exception e)
        {
            this.characterImg = null;
            JOptionPane.showMessageDialog(null, "処理中にエラーが発生しました\n" + e.getMessage());
            System.exit(-1);
        }
    }

    public void setPos(CharaPos pos)
    {
        this.charaPos = pos;
    }

    public void setIsDisplay(boolean display)
    {
        this.isDisplay = display;
    }

    void drawViewImg(Graphics g)
    {
        if (isDisplay)
        {
            int imgWidth = this.characterImg.getWidth(null);

            if (this.charaPos == CharaPos.Left)
            {

                g.drawImage(this.characterImg, 1920/8 - imgWidth/2, 360, null);
            }
            else if (this.charaPos == CharaPos.Right)
            {
                g.drawImage(this.characterImg, 1920/8*6 - imgWidth/2, 360, null);
            }
            else
            {
                g.drawImage(this.characterImg, 1920 / 2 - imgWidth/2, 360, null);
            }
        }
    }
}

;