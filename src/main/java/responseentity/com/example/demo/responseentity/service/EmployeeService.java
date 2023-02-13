package responseentity.com.example.demo.responseentity.service;

import org.springframework.stereotype.Service;
import responseentity.com.example.demo.responseentity.entity.EmployeeEntity;
import responseentity.com.example.demo.responseentity.exception.CustomException;
import responseentity.com.example.demo.responseentity.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeEntity addNewEmployee(EmployeeEntity employeeEntity) {
        EmployeeEntity employeeEmail = employeeRepository.findByEmail(employeeEntity.getEmail());

        if (employeeEntity.getName().isEmpty()) {
            throw new CustomException("Name is required","400");
        } else if (employeeEntity.getEmail().isEmpty()) {
            throw new CustomException("Email is required","400");
        } else if (employeeEntity.getAge() == null) {
            throw new CustomException("Age is required","400");

        } else if (employeeEmail != null) {
            throw new CustomException("Email already exist","400");
        } else {
            return employeeRepository.save(employeeEntity);
        }
    }

    public List<EmployeeEntity> getEmployeeList() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        if (employeeEntities.isEmpty()) {
            throw new CustomException("Record not founded","404");
        } else {
            return employeeEntities;
        }
    }

    public Optional<EmployeeEntity> findEmployeeById(Long id) {
        Optional<EmployeeEntity> employee = employeeRepository.findById(id);
        if (employee.isEmpty()) {
            throw new CustomException("Record not founded");
        } else {
            return employee;
        }
    }

    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }
}
