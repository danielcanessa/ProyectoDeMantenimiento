package com.pswe03.patrones;

abstract class BeverageTemplate {
    public final void prepare() {
        boilWater();
        brew();
        pourInCup();
        addExtras();
    }

    private void boilWater() { System.out.println("Boiling water"); }

    protected abstract void brew();

    private void pourInCup() { System.out.println("Pouring in cup"); }

    protected abstract void addExtras();
}

class Beverage extends BeverageTemplate {
    @Override
    protected void brew() {
        System.out.println("Brewing beverage");
    }

    @Override
    protected void addExtras() {
        System.out.println("Adding extras");
    }
}
