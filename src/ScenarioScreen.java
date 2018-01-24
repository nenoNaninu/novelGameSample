import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.CharacterIterator;

public class ScenarioScreen extends Screen
{

    private boolean workingFlag = true;
    private String scriptName;
    private ScenarioReader scenarioReader;
    private Image backGroundImg;
    private DisplayedCharacter[] character = new DisplayedCharacter[3];
    private TextWindow textWindow;

    private void setDisplayCharacter(String position, String imgName)
    {
        int idx = CharaPos.cvtStr2Value(position);
        if (idx == -1)
        {
            JOptionPane.showMessageDialog(null, "スクリプトエラー");
        }
        character[idx].setImage(imgName);
        character[idx].setIsDisplay(true);
    }

    private void setBackGroundImg(String imgName)
    {
        try
        {
            this.backGroundImg = ImageIO.read(new File("./img/" + imgName));
        }
        catch (IOException e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "処理中にエラーが発生しました\n" + e.getMessage());
            System.exit(-1);
        }
    }

    private void executeCtrlStatement(){
        while (true)
        {
            //この中でスクリプトの制御文を読み取って初期の設定をしていく。
            //背景画像の選択は必ず必要。キャラは任意。@startがあった時点でブレイクする。
            String[] str = this.scenarioReader.isCtrlStatement();


            if (str != null)
            {
                this.scenarioReader.readNext();
                if (str[0].equals("backGroundImg"))
                {
                    if (str.length == 2)
                    {
                        setBackGroundImg(str[1]);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "スクリプトエラー");
                        System.exit(-1);
                    }
                }
                else if (str[0].equals("character"))
                {
                    //@character gakuseiSmatphone.png left
                    //↑こんな感じで出てくる。
                    if (str.length == 3)
                    {
                        setDisplayCharacter(str[2], str[1]);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "スクリプトエラー");
                        System.exit(-1);
                    }
                }
                else if (str[0].equals("start"))
                {
                    break;
                }

            }
            else
            {
                break;
            }
        }

    }

    public ScenarioScreen(String scriptName)
    {
        this.nextScreen = this;
        this.scriptName = scriptName;

        try
        {
            this.scenarioReader = new ScenarioReader(scriptName);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        character[CharaPos.Left.getValue()] = new DisplayedCharacter("left");
        character[CharaPos.Right.getValue()] = new DisplayedCharacter("right");
        character[CharaPos.Center.getValue()] = new DisplayedCharacter("center");

        textWindow = new TextWindow();

        executeCtrlStatement();

    }

    @Override
    public Screen getNextScreen()
    {
        return this.nextScreen;
    }

    @Override
    public boolean onTick()
    {
        if (this.workingFlag)
        {
            this.scenarioReader.onTick();
            String displayStr = scenarioReader.getDisplaytStr();
            this.textWindow.setText(displayStr);
        }
        return false;
    }

    @Override
    public void onClicked()
    {
        if (!workingFlag)
        {
            this.scenarioReader.onClicked();
            //制御文が来た時にいろいろ制御する処理を書く。
            executeCtrlStatement();
            this.workingFlag = true;
        }
        else
        {
            //再生中に強制的にクリックされた場合がこっちに入ってくる。

        }
    }

    @Override
    public void drawViewImg(Graphics g)
    {
        /*描画する順番は背景、キャラ、テキストの順*/
        g.drawImage(backGroundImg, 0, 0, null);
        for (int i = 0; i < 3; i++)
        {
            this.character[i].drawViewImg(g);
        }
        this.textWindow.drawViewImg(g);
    }
}
