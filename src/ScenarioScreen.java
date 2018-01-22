import java.awt.*;
import java.io.FileNotFoundException;

public class ScenarioScreen extends Screen {

    private boolean workingFlag = true;
    private String scriptName;
    private ScenarioReader scenarioReader;
    private Image backGroundImg;
    private DisplayedCharacter[] character = new DisplayedCharacter[2];
    private TextWindow textWindow;
    public ScenarioScreen(String scriptName) {
        this.nextScreen = this;
        this.scriptName = scriptName;
        try {
            this.scenarioReader = new ScenarioReader(scriptName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        character[0] = new DisplayedCharacter();
        character[1] = new DisplayedCharacter();
        textWindow = new TextWindow();
    }

    @Override
    public Screen getNextScreen() {
        return this.nextScreen;
    }

    @Override
    public boolean onTick() {
        if(this.workingFlag){

        }
        return false;
    }

    @Override
    public void onClicked() {
        if(!workingFlag){
            this.workingFlag = true;

        }
    }

    @Override
    public void drawViewImg(Graphics g) {
        g.drawImage(backGroundImg, 0, 0, null);

    }
}
