package responseentity.com.example.demo.responseentity.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import responseentity.com.example.demo.responseentity.dto.EmployeeDTO;
import responseentity.com.example.demo.responseentity.entity.EmployeeEntity;
import responseentity.com.example.demo.responseentity.service.EmployeeService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employee/api")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public EmployeeEntity mapDtoToEntity(EmployeeDTO employeeDto) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setAge(employeeDto.getAge());
        employeeEntity.setName(employeeDto.getName());
        employeeEntity.setEmail(employeeDto.getEmail());
        return employeeEntity;
    }

    public EmployeeDTO mapEntityToDto(EmployeeEntity employeeEntity) {
        EmployeeDTO employeeDto = new EmployeeDTO();
        employeeDto.setAge(employeeEntity.getAge());
        employeeDto.setName(employeeEntity.getName());
        employeeDto.setEmail(employeeEntity.getEmail());
        return employeeDto;
    }

    @PostMapping
    public ResponseEntity<EmployeeEntity> addEmployee(@RequestBody EmployeeDTO employeeDto) {
        EmployeeEntity employee = employeeService.addNewEmployee(mapDtoToEntity(employeeDto));
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<EmployeeEntity>(employee, httpHeaders, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getList() {
        List<EmployeeEntity> employeeEntities = employeeService.getEmployeeList();
        List<EmployeeDTO> employeeDTOS = employeeEntities
                .stream()
                .map(employeeEntity -> mapEntityToDto(employeeEntity))
                .collect(Collectors.toList());
        return new ResponseEntity<>(employeeDTOS, HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Optional<EmployeeEntity>> employeeById(@PathVariable("id") Long id) {
        Optional<EmployeeEntity> employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<Optional<EmployeeEntity>>(employee, HttpStatus.FOUND);
    }

    @DeleteMapping(path = "{id}")
    public void deleteById(@PathVariable("id") Long id) {
        employeeService.deleteEmployeeById(id);
    }

}
