package com.homework18.homework18;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee) throws EmployeeAlreadyAddedException, ArrayIsFullException;
    Employee removeEmployee(Employee employee) throws EmployeeNotFoundException;
    Employee findEmployee(String firstName, String lastName) throws EmployeeNotFoundException;
    List<Employee> getAllEmployees();
}
