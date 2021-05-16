package by.deniskonnov.RestAPI.service;

import by.deniskonnov.RestAPI.model.Department;

import java.util.List;

public interface DepartmentService {

    Department getOne(Long id);
    void create(Department department);
    void delete(Long id);
    List<Department> getAll();
}
