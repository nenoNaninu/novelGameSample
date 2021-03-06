import java.io.File;
import java.io.FileNotFoundException;
import java.security.spec.ECField;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Scanner;

public class ScenarioReader
{
    private Scanner scanner;
    private String lineString;
    StringCharacterIterator textIterator;
    private String displayStr = "";
    private boolean isFinishReadLine = false;

    public ScenarioReader(String scriptName) throws FileNotFoundException
    {
        try
        {
            this.scanner = new Scanner(new File("./script/" + scriptName), "UTF-8");
        }
        catch (Exception e)
        {
            System.out.println("script is not found");
        }

        lineString = this.scanner.nextLine();
        this.displayStr = "";
        this.textIterator = new StringCharacterIterator("");
    }

    public void onClicked()
    {
        if (this.scanner.hasNext())
        {
            this.displayStr = "";
            this.lineString = this.scanner.nextLine();
            this.textIterator = new StringCharacterIterator(lineString);
            this.displayStr += this.textIterator.first();
            this.isFinishReadLine = false;
        }
    }

    public void onTick()
    {
        char next = this.textIterator.next();
        if (next != CharacterIterator.DONE)
        {
            this.displayStr += next;
        }else{
            this.isFinishReadLine = true;
        }
    }

    //制御文ならそのあとの文字列を返す関数。
    public String[] isCtrlStatement()
    {
        if (this.lineString.charAt(0) == '@')
        {
            String[] strings = this.lineString.substring(1).split(" ", 0);
            return strings;
        }
        else
        {
            return null;
        }
    }

    public void readNextLine()
    {
        if (this.scanner.hasNext())
        {
            this.lineString = this.scanner.nextLine();
            this.textIterator = new StringCharacterIterator(lineString);
        }
    }

    public String getDisplayStr()
    {
        return this.displayStr;
    }

    public boolean isFinishReadLine(){
        return this.isFinishReadLine;
    }
}
