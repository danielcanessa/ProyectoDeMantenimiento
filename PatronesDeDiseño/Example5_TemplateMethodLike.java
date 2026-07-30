
public class Beverage {
    public void prepare() {
        boilWater();
        brew();
        pourInCup();
        addExtras();
    }

    private void boilWater() { System.out.println("Boiling water"); }
    private void brew() { System.out.println("Brewing beverage"); }
    private void pourInCup() { System.out.println("Pouring in cup"); }
    private void addExtras() { System.out.println("Adding extras"); }
}
