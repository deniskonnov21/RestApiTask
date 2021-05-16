package by.deniskonnov.RestAPI.service;

import by.deniskonnov.RestAPI.model.Department;
import by.deniskonnov.RestAPI.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department getOne(Long id) {
        departmentRepository.getOne(id);
        return null;
    }

    @Override
    public void create(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public void delete(Long id) {
        if (departmentRepository.existsById(id)){
            departmentRepository.deleteById(id);
        }
    }

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }
}
