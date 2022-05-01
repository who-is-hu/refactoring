package me.whiteship.refactoring._06_mutable_data._22_combine_functions_into_transform;

public class Client2 extends ReadingClient {

    private double base;
    private double taxableCharge;

    public Client2(Reading reading) {
        this.base = this.enrichReading(reading).baseCharge();
        this.taxableCharge = Math.max(0, this.base - taxThreshold(reading.year()));
    }
}
