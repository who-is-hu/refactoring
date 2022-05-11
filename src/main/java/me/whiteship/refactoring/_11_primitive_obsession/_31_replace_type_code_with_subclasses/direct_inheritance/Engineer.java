package me.whiteship.refactoring._11_primitive_obsession._31_replace_type_code_with_subclasses.direct_inheritance;

public class Engineer extends Employee {
    @Override
    public String getType() {
        return "engineer";
    }

    public Engineer(String name) {
        super(name);
    }
}
