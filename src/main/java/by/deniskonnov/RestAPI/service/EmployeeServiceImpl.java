package by.deniskonnov.RestAPI.service;

import by.deniskonnov.RestAPI.model.Employee;
import by.deniskonnov.RestAPI.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee getOne(Long id) {
        return employeeRepository.getOne(id);
    }

    @Override
    public void create(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void delete(Long id) {
        if (employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
        }
    }

    @Override
    public void addEmployeeInDepartment(Employee employee) {
        employeeRepository.addEmployeeInDepartment(employee);
    }

    @Override
    public void deleteEmployeeInDepartment(Long id) {
        if (employeeRepository.existsById(id)){
            employeeRepository.deleteEmployeeInDepartment(id);
        }
    }

    @Override
    public List<Employee> getAllEmployeesWithoutDepartment() {
        return employeeRepository.getAllEmployeesWithoutDepartment();
    }
}
