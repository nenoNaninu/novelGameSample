import java.awt.*;

public class TextWindow
{

    private String text;
    private String textLine1 = "";
    private String textLine2 = "";

    private Font font;

    public TextWindow()
    {
        font = new Font("メイリオ", Font.BOLD, 50);
    }

    void setText(String text)
    {
        this.text = text;
        this.textLine1 = "";
        this.textLine2 = "";
        if (this.text.length() < 30)
        {
            this.textLine1 = this.text;
        }
        else
        {
            this.textLine1 = this.text.substring(0, 30);
            this.textLine2 = this.text.substring(30);
        }
    }


    void drawViewImg(Graphics g)
    {
        g.setColor(Color.orange);
        g.fillRect(0, 810, 1920, 1080 - 810);
        g.setFont(this.font);
        g.setColor(Color.black);
        g.drawString(this.textLine1, 20, 860);
        g.drawString(this.textLine2, 20, 910);
    }
}
