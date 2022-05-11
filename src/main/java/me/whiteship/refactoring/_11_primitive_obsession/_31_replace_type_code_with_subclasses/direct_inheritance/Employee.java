package me.whiteship.refactoring._11_primitive_obsession._31_replace_type_code_with_subclasses.direct_inheritance;

public abstract class Employee {

    private String name;

    protected Employee(String name) {
        this.name = name;
    }

    // 이것도 필요없는거 아닌가... 외부에 있어야 의미있을듯
    public static Employee createEmployee(String name, EmployeeType type){
        return switch (type) {
            case ENGINEER -> new Engineer(name);
            case MANAGER -> new Manager(name);
            case SALES_MAN -> new Salesman(name);
            default -> throw new IllegalArgumentException(type.toString());
        };
    }

    public abstract String getType();

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + getType() + '\'' +
                "type='" +
                '}';
    }
}
