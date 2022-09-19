package me.whiteship.refactoring._20_large_class._41_extract_superclass;

public abstract class Party {
    protected String name;
    public abstract double monthlyCost();

    public double annualCost() {
        return this.monthlyCost() * 12;
    }
}
