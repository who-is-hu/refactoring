package me.whiteship.refactoring._07_divergent_change._26_extract_class;

public class TelephoneNumber {
    String officeAreaCode;
    String officeNumber;

    public TelephoneNumber() {
    }

    public String officeAreaCode() {
        return officeAreaCode;
    }

    public void setOfficeAreaCode(String officeAreaCode) {
        this.officeAreaCode = officeAreaCode;
    }

    public String officeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }
}