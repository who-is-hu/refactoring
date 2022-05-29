package me.whiteship.refactoring._16_temporary_field._36_introduce_special_case;

public class Customer {

    private String name;

    private BillingPlan billingPlan;

    private PaymentHistory paymentHistory;

    public Customer(String name, BillingPlan billingPlan, PaymentHistory paymentHistory) {
        this.name = name;
        this.billingPlan = billingPlan;
        this.paymentHistory = paymentHistory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BillingPlan getBillingPlan() {
        return billingPlan;
    }

    public void setBillingPlan(BillingPlan billingPlan) {
        this.billingPlan = billingPlan;
    }

    public PaymentHistory getPaymentHistory() {
        return paymentHistory;
    }

    public void setPaymentHistory(PaymentHistory paymentHistory) {
        this.paymentHistory = paymentHistory;
    }

    boolean isUnknown() {
        return this.getName().equals("unknown");
    }

    public static Customer UNKNOWN = new Customer("occupant", new BasicBillingPlan(), PaymentHistory.NULL);
}
