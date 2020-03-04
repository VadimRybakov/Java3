package Race;

public abstract class Stage {
    protected int length;
    protected boolean theStageIsChecked = false;
    protected String description;
    public String getDescription() {
        return description;
    }
    public abstract void go(Car c);
    public abstract boolean checkStage();
}