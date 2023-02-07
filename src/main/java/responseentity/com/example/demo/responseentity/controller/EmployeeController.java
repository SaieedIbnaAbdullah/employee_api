package responseentity.com.example.demo.responseentity.controller;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import responseentity.com.example.demo.responseentity.entity.EmployeeEntity;
import responseentity.com.example.demo.responseentity.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee/api")
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping
    public ResponseEntity<EmployeeEntity> addEmployee(@RequestBody EmployeeEntity employeeEntity){
        EmployeeEntity employee = employeeService.addNewEmployee(employeeEntity);
        final HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<EmployeeEntity>(employee, httpHeaders, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<EmployeeEntity>> getList(){
        List<EmployeeEntity> employee = employeeService.getEmployeeList();
        return new ResponseEntity<List<EmployeeEntity>>(employee, HttpStatus.OK);
    }
    @GetMapping(path = "{id}")
    public ResponseEntity<Optional<EmployeeEntity>> employeeById(@PathVariable("id") Long id){
        Optional<EmployeeEntity> employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<Optional<EmployeeEntity>>(employee, HttpStatus.FOUND);
    }
    @DeleteMapping(path = "{id}")
    public void deleteById(@PathVariable("id") Long id){
       employeeService.deleteEmployeeById(id);
    }

}
