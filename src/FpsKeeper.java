public class FpsKeeper {
    long frameStartTime = 0;
    private final long requireWaitTime = 40;

    public FpsKeeper() { }


    public void keepFps() {
        long frameUsedTime = System.currentTimeMillis() - this.frameStartTime;
        long waitTime = this.requireWaitTime - frameUsedTime;

        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.frameStartTime = System.currentTimeMillis();
    }
}
