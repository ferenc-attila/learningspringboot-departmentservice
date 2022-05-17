package ferencattila.departmentservice.controller;

import ferencattila.departmentservice.dto.DepartmentDto;
import ferencattila.departmentservice.dto.SaveDepartmentCommand;
import ferencattila.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
@Slf4j
public class DepartmentController {

    private DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @PostMapping("/")
    public DepartmentDto saveDepartment(@RequestBody SaveDepartmentCommand command) {
        log.info("Inside saveDepartment method of DepartmentController");
        return service.saveDepartment(command);
    }

    @GetMapping("/{id}")
    public DepartmentDto findDepartmentById(@PathVariable("id") Long id) {
        log.info("Inside findDepartmentById method of DepartmentController");
        return service.findDepartmentById(id);
    }
}
