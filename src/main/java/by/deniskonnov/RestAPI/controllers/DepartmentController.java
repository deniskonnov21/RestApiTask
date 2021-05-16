package by.deniskonnov.RestAPI.controllers;


import by.deniskonnov.RestAPI.model.Department;
import by.deniskonnov.RestAPI.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@Api(value = "Department resources")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("")
    @ApiOperation(value = "Show all departments", response = Iterable.class)
    public ResponseEntity<List<Department>> getAll() {
        List<Department> departments = this.departmentService.getAll();
        if (departments.isEmpty()) {
            return new ResponseEntity<>(departments, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/department/{id}")
    @ApiOperation(value = "Show one department by id", response = Department.class)
    public ResponseEntity<Department> getOne(@PathVariable("id") Long departmentId) {
        if (departmentId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Department department = this.departmentService.getOne(departmentId);
        if (department == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @PostMapping("/department/create")
    @ApiOperation(value = "Create new department", response = Department.class)
    public ResponseEntity<Department> createDepartment(Department department) {
        if (department == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.departmentService.create(department);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }

    @PostMapping("/department/delete/{id}")
    @ApiOperation(value = "Delete department by id", response = Department.class)
    public ResponseEntity<Department> deleteDepartment(@PathVariable("id") Long id) {
        Department department = this.departmentService.getOne(id);
        if(department == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.departmentService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
