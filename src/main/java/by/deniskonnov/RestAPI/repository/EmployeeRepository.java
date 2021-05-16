package by.deniskonnov.RestAPI.repository;

import by.deniskonnov.RestAPI.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "insert into employee where departmentId not null", nativeQuery = true)
    void addEmployeeInDepartment(Employee employee);

    @Query(value = "delete from employee where departmentId={id}", nativeQuery = true)
    boolean deleteEmployeeInDepartment(Long id);

    @Query(value = "select * from employee where departmentId = null", nativeQuery = true)
    List<Employee> getAllEmployeesWithoutDepartment();
}
