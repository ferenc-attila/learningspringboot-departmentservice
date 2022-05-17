package ferencattila.departmentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveDepartmentCommand {

    private Long id;

    private String name;

    private String address;

    private String code;
}
