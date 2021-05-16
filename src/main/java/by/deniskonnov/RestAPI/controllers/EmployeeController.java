package by.deniskonnov.RestAPI.controllers;


import by.deniskonnov.RestAPI.model.Employee;
import by.deniskonnov.RestAPI.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@Api(value = "Employee resources")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/employee/{id}")
    @ApiOperation(value = "Show one employee by id", response = Employee.class)
    public ResponseEntity<Employee> getOne(@PathVariable("id") Long employeeId){
        if(employeeId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Employee employee = this.employeeService.getOne(employeeId);
        if(employee == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/employee/create")
    @ApiOperation(value = "Create new employee", response = Employee.class)
    public ResponseEntity<Employee> createEmployee(Employee employee){
        if(employee == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.employeeService.create(employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @PostMapping("/employee/delete/{id}")
    @ApiOperation(value = "Delete employee by id", response = Employee.class)
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") Long id) {
        Employee employee = this.employeeService.getOne(id);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.employeeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/employee/department/add")
    @ApiOperation(value = "Create new employee in the department")
    public ResponseEntity<Employee> addEmployeeInDepartment(Employee employee){
        if (employee == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.employeeService.addEmployeeInDepartment(employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @PostMapping("/employee/department/delete/{id}")
    @ApiOperation(value = "Delete employee in the department by id")
    public ResponseEntity<Employee> deleteEmployeeInDepartment(@PathVariable("id") Long id){
        Employee employee = this.employeeService.getOne(id);
        if (employee == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.employeeService.deleteEmployeeInDepartment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("")
    @ApiOperation(value = "Show all employees without department", response = Iterable.class)
    public ResponseEntity<List<Employee>> getAllEmployeesWithoutDepartment() {
        List<Employee> employeesWithoutDepartment = this.employeeService.getAllEmployeesWithoutDepartment();
        if (employeesWithoutDepartment.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeesWithoutDepartment, HttpStatus.OK);
    }
}