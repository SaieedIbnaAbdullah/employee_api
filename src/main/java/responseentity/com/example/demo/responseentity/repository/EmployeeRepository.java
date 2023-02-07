package responseentity.com.example.demo.responseentity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import responseentity.com.example.demo.responseentity.entity.EmployeeEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
//   Optional<EmployeeEmail> findByEmail(String email);
}
