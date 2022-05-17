package ferencattila.departmentservice.service;

import ferencattila.departmentservice.DepartmentMapper;
import ferencattila.departmentservice.dto.DepartmentDto;
import ferencattila.departmentservice.dto.SaveDepartmentCommand;
import ferencattila.departmentservice.entity.Department;
import ferencattila.departmentservice.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class DepartmentService {

    private DepartmentRepository repository;

    private DepartmentMapper mapper;

    public DepartmentService(DepartmentRepository repository, DepartmentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public DepartmentDto saveDepartment(SaveDepartmentCommand command) {
        log.info("Inside saveDepartment of DepartmentService");
        if (repository.findByCode(command.getCode()).isPresent()) {
            throw new IllegalArgumentException("Department with code: " + command.getCode() + " is already in the database!");
        }
        Department result = repository.save(mapper.departmentFromSaveDepartmentCommand(command));
        return mapper.dtoFromDepartment(result);
    }

    public DepartmentDto findDepartmentById(Long id) {
        log.info("Inside findDepartmentById of DepartmentService");
        Optional<Department> result = repository.findById(id);
        Department department = result.orElseThrow(
                () -> new IllegalArgumentException("Cannot find department by id: " + id));
        return mapper.dtoFromDepartment(department);
    }
}
