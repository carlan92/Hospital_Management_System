package pt.iscte.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.iscte.hospital.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
