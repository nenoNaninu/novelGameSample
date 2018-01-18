import java.awt.*;

public class ScenarioScreen extends Screen {

    private boolean workingFlag = false;

    public ScenarioScreen() {
        this.nextScreen = this;
    }

    @Override
    public Screen getNextScreen() {
        return this.nextScreen;
    }

    @Override
    public void paint(Graphics g) {

    }

    @Override
    public void onTick() {
        if(this.workingFlag){

        }
    }

    @Override
    public void onClicked() {
        if(!workingFlag){
            this.workingFlag = true;
        }
    }
}
