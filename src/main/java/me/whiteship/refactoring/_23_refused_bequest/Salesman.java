package me.whiteship.refactoring._23_refused_bequest;

public class Salesman extends Employee {

    private Quota quota;

    public Quota getQuota() {
        return new Quota();
    }
}

