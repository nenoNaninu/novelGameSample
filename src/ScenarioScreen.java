import java.awt.*;
import java.io.FileNotFoundException;

public class ScenarioScreen extends Screen {

    private boolean workingFlag = true;
    private String scriptName;
    private ScenarioReader scenarioReader;
    public ScenarioScreen(String scriptName) {
        this.nextScreen = this;
        this.scriptName = scriptName;
        try {
            this.scenarioReader = new ScenarioReader(scriptName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Screen getNextScreen() {
        return this.nextScreen;
    }

    @Override
    public void paint(Graphics g) {

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

    }
}
