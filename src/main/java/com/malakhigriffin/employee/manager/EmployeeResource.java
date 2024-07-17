package com.malakhigriffin.employee.manager;

import com.malakhigriffin.employee.manager.model.Employee;
import com.malakhigriffin.employee.manager.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
    private final EmployeeService employeeService;

    //inject the employeeService into constructer so that we can autowire the service into this class
    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //get request to get all employees
    @GetMapping("/all")
    //returns http response
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.findAllEmployees();
        //http response that everything works
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    //get request to find an employee by their id
    @GetMapping("/find/{id}")
    //returns http response                         the @PathVarible "id" is from the /find/{id}
    public ResponseEntity<Employee> getEmployeebyId(@PathVariable("id") Long id ) {
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    //Post request to add new employee
    @PostMapping("/add")
    //returns http response
    //receiving the entire employee object through JSON
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
       Employee newEmployee = employeeService.addEmployee(employee);
        //http response that a new instance was created
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    //Put Request to update employee
    @PutMapping("/update")
    //returns http response
    //receiving the entire employee object through JSON
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee updateEmployee = employeeService.updateEmployee(employee);
        //http response that everything works
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    //Delete request to delete the employee by their id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        //http response that everything works
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
