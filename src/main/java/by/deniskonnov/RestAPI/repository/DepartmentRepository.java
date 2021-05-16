package by.deniskonnov.RestAPI.repository;

import by.deniskonnov.RestAPI.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
