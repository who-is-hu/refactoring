package me.whiteship.refactoring._20_large_class._41_extract_superclass;

public class Employee extends Party{

    private Integer id;

    private String name;

    private double monthlyCost;

    @Override
    public double monthlyCost() {
        return this.monthlyCost;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
