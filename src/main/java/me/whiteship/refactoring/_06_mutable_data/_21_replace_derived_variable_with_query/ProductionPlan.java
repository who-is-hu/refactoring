package me.whiteship.refactoring._06_mutable_data._21_replace_derived_variable_with_query;

import java.util.ArrayList;
import java.util.List;

public class ProductionPlan {

    private List<Double> adjustments = new ArrayList<>();

    public void applyAdjustment(double adjustment) {
        this.adjustments.add(adjustment);
        //this.production += adjustment; 메서드가 두가지 일을 하는 경우??
    }

    public double getProduction() {
        return adjustments.stream().mapToDouble(Double::valueOf).sum();
    }
}
