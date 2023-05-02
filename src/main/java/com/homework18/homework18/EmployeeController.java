package com.homework18.homework18;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {


    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName) throws EmployeeAlreadyAddedException, ArrayIsFullException {
        Employee employee = new Employee(firstName, lastName);
        return employeeService.addEmployee(employee);
    }
    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, lastName);
        return employeeService.removeEmployee(employee);
    }
    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName) throws EmployeeNotFoundException {
        return employeeService.findEmployee(firstName, lastName);
    }

}