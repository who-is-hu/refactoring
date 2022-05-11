package me.whiteship.refactoring._11_primitive_obsession._31_replace_type_code_with_subclasses.direct_inheritance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void employeeType() {
        assertEquals("engineer", Employee.createEmployee("keesun", EmployeeType.ENGINEER).getType());
        assertEquals("manager", Employee.createEmployee("keesun", EmployeeType.MANAGER).getType());
    }

}