package by.deniskonnov.RestAPI.service;

import by.deniskonnov.RestAPI.model.Employee;
import java.util.List;


public interface EmployeeService {

    Employee getOne(Long id);
    void create(Employee employee);
    void delete(Long id);
    void addEmployeeInDepartment(Employee employee);
    void deleteEmployeeInDepartment(Long id);
    List<Employee> getAllEmployeesWithoutDepartment();
}
