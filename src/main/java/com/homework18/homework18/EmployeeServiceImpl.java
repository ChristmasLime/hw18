package com.homework18.homework18;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final int MAX_EMPLOYEES = 10;
    private final List<Employee> employees = new ArrayList<>();

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee addEmployee(Employee employee) throws EmployeeAlreadyAddedException, ArrayIsFullException {
        if (employees.size() == MAX_EMPLOYEES) {
            throw new ArrayIsFullException();
        }
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }

    public Employee removeEmployee(Employee employee) throws EmployeeNotFoundException {
        Employee removedEmployee = null;
        for (Employee emp : employees) {
            if (emp.getFirstName().equals(employee.getFirstName()) && emp.getLastName().equals(employee.getLastName())) {
                removedEmployee = emp;
                employees.remove(emp);
                break;
            }
        }
        if (removedEmployee == null) {
            throw new EmployeeNotFoundException();
        }
        return removedEmployee;
    }

    public Employee findEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }
}
