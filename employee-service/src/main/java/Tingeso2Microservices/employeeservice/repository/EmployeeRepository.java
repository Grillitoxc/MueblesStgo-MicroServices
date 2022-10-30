package Tingeso2Microservices.employeeservice.repository;

import Tingeso2Microservices.employeeservice.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    @Query(value = "SELECT id FROM employee WHERE rut = ?1", nativeQuery = true)
    Long findIdByRut(String rut);

    @Query(value = "SELECT id FROM employee WHERE name = ?1", nativeQuery = true)
    Long findIdByName(String name);
}

