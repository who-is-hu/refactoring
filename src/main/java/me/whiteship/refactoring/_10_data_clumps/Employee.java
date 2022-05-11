package me.whiteship.refactoring._10_data_clumps;

public class Employee {

    private String name;

    private PhoneNumber phoneNumber;

    public Employee(String name, PhoneNumber phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String personalPhoneNumber() {
        return this.phoneNumber.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonalAreaCode() {
        return phoneNumber.getAreaCode();
    }

    public void setPersonalAreaCode(String personalAreaCode) {
        this.phoneNumber.setAreaCode(personalAreaCode);
    }

    public String getPersonalNumber() {
        return this.phoneNumber.getNumber();
    }

    public void setPersonalNumber(String personalNumber) {
        this.phoneNumber.setNumber(personalNumber);
    }
}
