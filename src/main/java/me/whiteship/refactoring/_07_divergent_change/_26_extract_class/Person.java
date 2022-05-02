package me.whiteship.refactoring._07_divergent_change._26_extract_class;

public class Person {

    private TelephoneNumber telephoneNumber;
    private String name;

    public String telephoneNumber() {
        return this.telephoneNumber.officeAreaCode() + " " + this.telephoneNumber.officeNumber();
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
