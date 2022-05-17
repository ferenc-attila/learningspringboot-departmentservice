package ferencattila.departmentservice;

import ferencattila.departmentservice.dto.DepartmentDto;
import ferencattila.departmentservice.dto.SaveDepartmentCommand;
import ferencattila.departmentservice.entity.Department;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    DepartmentDto dtoFromDepartment(Department department);

    List<DepartmentDto> dtoFromDepartment(List<Department> departments);

    Department departmentFromSaveDepartmentCommand(SaveDepartmentCommand command);
}
